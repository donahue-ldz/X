package com.X.dal.mapper;

import com.X.dal.domain.TopicCategoryDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:30 PM
 **/
@Repository
public interface TopicCategoryMapper {
    /**
     * 添加帖子分类
     *
     * @param topicCategory TopicCategoryDO
     * @return long
     */
    long save(TopicCategoryDO topicCategory);

    /**
     * 根据中文名查找帖子目录
     *
     * @param titleEn String
     * @return TopicCategory
     */
    TopicCategoryDO queryTopicCategoryByName(@Param("titleEn") String titleEn);

    /**
     * 查询所有贴子的类别
     *
     * @return List<TopicCategoryDO>
     */
    List<TopicCategoryDO> queryAllTopicCategories();
}
