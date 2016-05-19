package com.X.dal.mapper;

import com.X.dal.domain.CommentFavoriteDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 9:24 PM
 **/
@Repository
public interface CommentFavoriteMapper {
    void save(CommentFavoriteDO commentFavorite);

    long countFavoritesByCommentID(@Param("commentID") Long commentID);
}
