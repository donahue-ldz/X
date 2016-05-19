package com.X.biz.aggregation;

import com.X.biz.bbs.vo.TopicDetails;
import com.X.biz.bbs.vo.TopicStat;
import com.X.biz.bbs.vo.TopicVO;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicDO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 10:18 AM
 **/
public interface TopicAgg {
    TopicDetails queryTopicDetailsByID(@NotNull Long topicID,String topicCategory) throws XException;
    TopicStat queryTopicStat(@NotNull Long topicID)throws XException;

    TopicVO queryTopicVOByTopic(@NotNull TopicDO topicDO,String topicCategory) throws XException;

    List<TopicVO> queryTopicVOsByCategoryWithPage(@NotEmpty String category,int pageNO,int pageSize) throws XException;
}
