package sales.images.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sales.images.domain.Image;
import sales.images.service.ImageService;

import java.util.List;

@Api(basePath = "/image", value = "images", description = "Endpoint for images management")
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    public ImageController() {
    }

    @ApiOperation(httpMethod = "GET",
            value = "Get images",
            notes = "Get all images for good with %goodId%",
            response = Image.class,
            responseContainer="List")
    @RequestMapping(value = "/good/{goodId}/all",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<Image> getImagesByGoodId(@ApiParam(value = "int goodId - id of good", required = true)
                                         @PathVariable(value = "goodId") int goodId) {
        return imageService.getImagesByGoodId(goodId);
    }

    @ApiOperation(httpMethod = "POST",
            value = "Load image",
            notes = "Load image to db (first encode image to base64 then send via json)")
    @RequestMapping(value = "/{type}",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public Image loadImage(@ApiParam(value = "type = 'user' or type = 'good', depend on what picture you want post", required = true)
                           @PathVariable(value = "type") String type,
                           @ApiParam(value = "Image json:{userId, goodId, image}", required = true)
                           @RequestBody Image image) {
        return imageService.loadImage(image, type);
    }

    @ApiOperation(httpMethod = "GET",
            value = "Get small image",
            notes = "Get small preview image for good with %goodId%",
            response = Image.class)
    @RequestMapping(value = "/good/{goodId}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Image getImageByGoodId(@ApiParam(value = "int goodId - id of good", required = true)
                                  @PathVariable(value = "goodId") int goodId) {
        return imageService.getImageByGoodId(goodId);
    }

    @ApiOperation(httpMethod = "GET",
            value = "Get user image",
            notes = "Get image for user with %userId%",
            response = Image.class)
    @RequestMapping(value = "/user/{userId}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Image getImageByUserId(@ApiParam(value = "Long userId - id of user", required = true)
                                  @PathVariable(value = "userId") Long userId)
    {
        return imageService.getImageByUserId(userId);
    }

    @ApiOperation(httpMethod = "PUT",
            value = "Change user image",
            notes = "Update user image")
    @RequestMapping(value = "/user",
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json")
    public Image updateUserImage(@ApiParam(value = "Image json:{userId, goodId, image}", required = true)
                                 @RequestBody Image image)
    {
        return imageService.updateUserImage(image);
    }
}
