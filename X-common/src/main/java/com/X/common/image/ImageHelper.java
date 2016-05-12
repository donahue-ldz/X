package com.X.common.image;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.*;
import java.io.File;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 10:36 PM
 **/
public class ImageHelper {
    public static Image resize(File image, int width, int height) throws Exception {

        return Thumbnails.of(image).size(width,height).asBufferedImage();
    }
    public static Image convertFormat(File image,String format) throws Exception{
        return Thumbnails.of(image).outputFormat(format).asBufferedImage();
    }
}
