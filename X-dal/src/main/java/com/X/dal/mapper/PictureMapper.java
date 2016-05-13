package com.X.dal.mapper;

import com.X.dal.domain.PictureDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:21 AM
 **/
@Repository
public interface PictureMapper {
    long save(PictureDO picture);
    PictureDO queryPictureByID(@Param("id")String id);
}
