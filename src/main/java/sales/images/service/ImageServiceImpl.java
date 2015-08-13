package sales.images.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sales.images.domain.Image;
import sales.images.repository.ImageRepository;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getImagesByGoodId(int goodId) {
        return imageRepository.findByGoodId(goodId);
    }

    @Override
    public Image loadImage(Image image) {
        Image img = imageRepository.save(image);
        List<Image> images = imageRepository.findByGoodIdOrderByChainDesc(img.getGoodId());
        if (images.size() == 0) {
            img.setChain(1);
        } else {
            img.setChain(images.get(0).getChain() + 1);
        }
        return imageRepository.save(img);
    }

    @Override
    public Image getImageByGoodId(int goodId) {
        Image imgOrig = imageRepository.findByGoodIdAndChain(goodId, 1);

        int NEW_HEIGHT = 260;

        Image imgScaled = new Image();
        imgScaled.setId(imgOrig.getId());
        imgScaled.setGoodId(imgOrig.getGoodId());
        imgScaled.setChain(imgOrig.getChain());
        imgScaled.setImage(resizeImage(imgOrig.getImage(), NEW_HEIGHT));

        return imgScaled;
    }

    private byte[] resizeImage(byte[] input, int newHeight) {
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        try {
            BufferedImage img = ImageIO.read(in);
            int newWidth = (int) ((double)newHeight * ((double)img.getWidth() / (double)img.getHeight()));
            java.awt.Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            bufferedImage.getGraphics().drawImage(scaledImage, 0, 0, new Color(0,0,0), null);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", out);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
