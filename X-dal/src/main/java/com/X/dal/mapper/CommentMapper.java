package com.X.dal.mapper;

import com.X.dal.domain.CommentDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:31 PM
 **/
@Repository
public interface CommentMapper {
    /**
     * 添加评论
     *
     * @param comment CommentDO
     * @return long
     */
    void save(CommentDO comment);
    CommentDO queryCommentByID(@Param("id") Long id) ;

    /**
     * 根据帖子ID查询评论
     *
     * @param topicID long
     * @return List<CommentDO>
     */
    List<CommentDO> queryCommentsByTopicID(@Param("topicID") long topicID);

    long countCommentsByTopicID(@Param("topicID") long topicID);
    long countCommentsByUser(@Param("userID") long userID,@Param("userRole") String userRole);
    List<Long> queryUsers();
}
