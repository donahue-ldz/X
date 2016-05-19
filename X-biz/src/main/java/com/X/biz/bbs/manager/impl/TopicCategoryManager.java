package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicCategoryDO;
import com.X.dal.mapper.TopicCategoryMapper;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;

import static com.X.common.utils.Tool.safeList;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:38 PM
 **/
@Service("topicCategoryManager")
@Transactional(rollbackFor = Exception.class)
public class TopicCategoryManager implements ITopicCategoryManager {

    public static List<String> AGG_CATEGORIES = Lists.newArrayList(
            "hot",
            "recently"
    );
    @Resource
    private TopicCategoryMapper topicCategoryMapper;

    @Override
    public long save(final TopicCategoryDO topicCategory) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                topicCategoryMapper.save(topicCategory);
                return topicCategory.getId();
            }
        }, topicCategory);
    }

    @Override
    public TopicCategoryDO queryTopicCategoryByName(final String titleEn) throws XException {
        return RunWrapper.run(new Callable<TopicCategoryDO>() {
            @Override
            public TopicCategoryDO call() throws Exception {
                return topicCategoryMapper.queryTopicCategoryByName(titleEn);
            }
        });
    }

    @Override
    public List<TopicCategoryDO> queryAllTopicCategories() throws XException {
        return RunWrapper.run(new Callable<List<TopicCategoryDO>>() {
            @Override
            public List<TopicCategoryDO> call() throws Exception {
                return topicCategoryMapper.queryAllTopicCategories();
            }
        });
    }

    @Override
    public List<TopicCategoryDO> avaiCategories() throws XException {
        return RunWrapper.run(new Callable<List<TopicCategoryDO>>() {
            @Override
            public List<TopicCategoryDO> call() throws Exception {
                List<TopicCategoryDO> topicCategoryDOs = safeList(queryAllTopicCategories());
                List<TopicCategoryDO> avaiCategories = Lists.newArrayList(Iterables.filter(topicCategoryDOs, new Predicate<TopicCategoryDO>() {
                    @Override
                    public boolean apply(@Nullable TopicCategoryDO topicCategoryDO) {
                        return !AGG_CATEGORIES.contains(topicCategoryDO.getNameEn());
                    }
                }));

                return avaiCategories;
            }
        });
    }
}
