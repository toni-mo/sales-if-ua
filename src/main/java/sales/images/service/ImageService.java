package sales.images.service;


import sales.images.domain.Image;

import java.util.List;

public interface ImageService {

    public List<Image> getImagesByGoodId(int goodId);

    public Image loadImage(Image image);

    public Image getImageByGoodId(int goodId);

}
