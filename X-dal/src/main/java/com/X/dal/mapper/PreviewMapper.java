package com.X.dal.mapper;

import com.X.dal.domain.PreviewDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-26 AM9:36
 **/
@Repository
public interface PreviewMapper {
    void save(PreviewDO preview);
    PreviewDO queryPreviewByID(@Param("id") final long id);

}
