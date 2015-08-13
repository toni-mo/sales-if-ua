package sales.images.service;


import sales.images.domain.Image;

import java.util.List;

public interface ImageService {

    public List<Image> getImagesByGoodId(int goodId);

    public Image loadImage(Image image, String key);

    public Image getImageByGoodId(int goodId);

    public Image getImageByUserId(Long userId);

    public Image updateUserImage(Image image);

}
