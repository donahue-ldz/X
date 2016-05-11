package com.X.biz.common.impl;

import com.X.biz.common.IPictureManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.PictureDO;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:12 AM
 **/
@Service("pictureManager")
public class PictureManager implements IPictureManager {
    @Override
    public long save(PictureDO picture) throws XException {
        return 0;
    }

    @Override
    public PictureDO queryPicturesByIDs(@NotEmpty List<Long> ids) {
        return null;
    }
}
