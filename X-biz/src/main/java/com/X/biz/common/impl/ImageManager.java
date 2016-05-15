package com.X.biz.common.impl;

import com.X.biz.RunWrapper;
import com.X.biz.common.IFileManager;
import com.X.biz.common.IImageManager;
import com.X.biz.exception.XException;
import com.X.biz.system.Config;
import com.X.common.utils.DateUtils;
import com.X.common.utils.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 11:05 PM
 **/
@Service("imageManager")
public class ImageManager implements IImageManager {
    public static final String AVATAR_DIRECOTRY = "/avatar";
    @Autowired
    private IFileManager fileManager;


    @Override
    public String save(final byte[] imageBytes, final HttpServletRequest request) throws XException {
        return RunWrapper.run(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String configDirectory = Config.FILE_UPLOAD_DIRECTORY + AVATAR_DIRECOTRY;
                String directory = request.getSession().getServletContext().getRealPath(configDirectory);
                StringBuffer fileName = new StringBuffer(DateUtils.currentDate())
                        .append("_").append(Tool.getUUID32())
                        .append(".").append(Config.IMAGE_TYPE);

                fileManager.save(imageBytes,directory,fileName.toString());
                StringBuffer buffer = new StringBuffer();
                String protocol = "http";
                buffer.append(protocol).append("://")
                        .append(request.getServerName())
                        .append(":").append(request.getServerPort());
                return buffer.append(configDirectory).append("/").append(fileName).toString();
            }
        });
    }
}
