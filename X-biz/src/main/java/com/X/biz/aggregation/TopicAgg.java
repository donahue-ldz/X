package com.X.biz.aggregation;

import com.X.biz.bbs.vo.TopicDetails;
import com.X.biz.bbs.vo.TopicStat;
import com.X.biz.bbs.vo.TopicVO;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicDO;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 10:18 AM
 **/
public interface TopicAgg {
    TopicDetails queryTopicDetailsByID(Long topicID) throws XException;
    TopicStat queryTopicStat(Long topicID)throws XException;

    TopicVO queryTopicVOByTopic(TopicDO topicDO) throws XException;

    List<TopicVO> queryTopicVOsByCategoryWithPage(@NotEmpty String category,int pageNO,int pageSize) throws XException;
}
