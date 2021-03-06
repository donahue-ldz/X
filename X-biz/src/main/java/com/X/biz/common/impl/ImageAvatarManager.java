package com.X.biz.common.impl;

import com.X.biz.RunWrapper;
import com.X.biz.cloud.CloudConfig;
import com.X.biz.cloud.upload.Upload;
import com.X.biz.common.IImageAvatarManager;
import com.X.biz.common.IPictureManager;
import com.X.biz.exception.XException;
import com.X.biz.system.Config;
import com.X.common.utils.DateUtils;
import com.X.common.utils.Tool;
import com.X.dal.domain.PictureDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 11:05 PM
 **/
@Service("imageAvatarManager")
public class ImageAvatarManager implements IImageAvatarManager {
    @Autowired
    private IPictureManager pictureManager;

    @Override
    public long save(final byte[] imageBytes, final HttpServletRequest request) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                final StringBuffer fileName = new StringBuffer(DateUtils.currentDate())
                        .append("_").append(Tool.getUUID32())
                        .append(".").append(Config.IMAGE_TYPE);

                Upload upload = new Upload() {
                    @Override
                    protected byte[] getBytes() {
                        return imageBytes;
                    }

                    @Override
                    protected String getKey() {
                        return fileName.toString();
                    }

                    @Override
                    protected String getBucketName() {
                        return CloudConfig.BUCKET_IMAGE_AVATAR;
                    }
                };
                upload.service();
                String pictureURL = CloudConfig.CLOUD_IMAGE_AVATAR_URL + "/" + fileName;
                PictureDO picture = new PictureDO();
                picture.setUrl(CloudConfig.PROTOCAL+pictureURL);
                picture.setGmtCreate(new Date());
                return pictureManager.save(picture);

            }
        });
    }
}
