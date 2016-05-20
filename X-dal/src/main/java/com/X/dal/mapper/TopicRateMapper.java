package com.X.dal.mapper;

import com.X.dal.domain.TopicRateDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 8:44 PM
 **/
@Repository
public interface TopicRateMapper {
    /**
     * 添加评论
     *
     * @param topicRate
     */
    long save(TopicRateDO topicRate);

    TopicRateDO queryTopicRate(@Param("topicID") Long topicID,
                               @Param("userID") Long userID,
                               @Param("rateType") String rateType);

    /**
     * 查看用户的评价 排除 views
     *
     * @param topicID
     * @param userID
     * @return
     */
    List<TopicRateDO> queryTopicRatesByUser(@Param("topicID") Long topicID, @Param("userID") Long userID);

    /**
     * 评论
     *
     * @param id     帖子ID
     * @param status 点赞/不赞
     * @return boolean
     */
    int update(@Param("id") long id, @Param("rateType") String rateType, @Param("status") String status);

    long countFavoritesByTopicID(@Param("topicID") long topicID);

    long countViewsByTopicID(@Param("topicID") long topicID);

    long countBookmarksByTopicID(@Param("topicID") long topicID);

    long countFavoritesByUserID(@Param("userID") Long userID);

    long countViewsByUserID(@Param("userID") Long userID);

    long countBookmarksByUserID(@Param("userID") Long userID);


}
