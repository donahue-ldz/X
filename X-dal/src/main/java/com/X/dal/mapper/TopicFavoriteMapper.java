package com.X.dal.mapper;

import com.X.dal.domain.TopicFavoriteDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 8:44 PM
 **/
@Repository
public interface TopicFavoriteMapper {
    /**
     * 添加用户点赞的帖子
     *
     * @param topicFavorite TopicFavoriteDO
     */
    long save(TopicFavoriteDO topicFavorite);

    /**
     * 取消点赞/再次点赞
     *
     * @param id     帖子ID
     * @param status 点赞/不赞
     * @return boolean
     */
    int update(@Param("id") long id, @Param("status") int status);

    long countFavoritesByTopicID(@Param("topicID") long topicID);

}
