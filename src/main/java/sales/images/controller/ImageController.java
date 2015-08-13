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
    @RequestMapping(value = "/{goodId}/all",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<Image> getImagesByGoodId(@ApiParam(value = "int goodId - id of good", required = true)
                                         @PathVariable(value = "goodId") int goodId) {
        return imageService.getImagesByGoodId(goodId);
    }

    @ApiOperation(httpMethod = "POST",
            value = "Load image",
            notes = "Load image to db (first encode image to base64 then send via json)")
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = "application/json")
    public Image loadImage(@ApiParam(value = "int goodId - id of good", required = true)
                           @RequestBody Image image) {
        return imageService.loadImage(image);
    }

    @ApiOperation(httpMethod = "GET",
            value = "Get small image",
            notes = "Get small preview image for good with %goodId%",
            response = Image.class)
    @RequestMapping(value = "/{goodId}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Image getImageByGoodId(@ApiParam(value = "int goodId - id of good", required = true)
                                  @PathVariable(value = "goodId") int goodId) {
        return imageService.getImageByGoodId(goodId);
    }
}
