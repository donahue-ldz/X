package com.X.biz.common;

import com.X.biz.exception.XException;
import com.X.dal.domain.PictureDO;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:12 AM
 **/
public interface IPictureManager {
    long save(PictureDO picture) throws XException;
    PictureDO queryPicturesByIDs(@NotEmpty List<Long> ids);
}
