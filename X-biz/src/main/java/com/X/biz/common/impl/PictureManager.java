package com.X.biz.common.impl;

import com.X.biz.RunWrapper;
import com.X.biz.common.IPictureManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.PictureDO;
import com.X.dal.mapper.PictureMapper;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:12 AM
 **/
@Service("pictureManager")
public class PictureManager implements IPictureManager {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public long save(final PictureDO picture) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return pictureMapper.save(picture);
            }
        });
    }

    @Override
    public PictureDO queryPicturesByID(@NotEmpty final Long id) throws XException{
        return RunWrapper.run(new Callable<PictureDO>() {
            @Override
            public PictureDO call() throws Exception {
                return pictureMapper.queryPictureByID(id);
            }
        });
    }
}
