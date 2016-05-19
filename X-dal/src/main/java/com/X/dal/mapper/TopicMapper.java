package com.X.dal.mapper;

import com.X.dal.domain.TopicDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:30 PM
 **/
@Repository
public interface TopicMapper {
    /**
     * 保存帖子并返回帖子的id
     *
     * @param topic TopicDO
     * @return long
     */
    long save(TopicDO topic);


    void updateStatus(@Param("id") Long id, @Param("status") String status);

    TopicDO queryTopicByID(@Param("id") Long id);

    /**
     * 根据条件查询帖子
     *
     * @param topicCategory 帖子类别
     * @param offSet        偏移量
     * @param rowCount      记录行数
     * @return List<TopicDO>
     */
    List<TopicDO> queryTopicsWithPage(@Param("topicCategory") String topicCategory, @Param("offSet") int offSet, @Param("rowCount") int rowCount);
}
