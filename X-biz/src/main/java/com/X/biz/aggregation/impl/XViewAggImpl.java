package com.X.biz.aggregation.impl;

import com.X.biz.admin.manager.ICourseCategoryManager;
import com.X.biz.admin.manager.ICourseManager;
import com.X.biz.admin.manager.ITrafficAnalysisManager;
import com.X.biz.admin.vo.XView;
import com.X.biz.aggregation.XViewAgg;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.exception.XException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-22 10:33 AM
 **/
@Service("XViewAgg")
public class XViewAggImpl implements XViewAgg {
    @Autowired
    private ITopicManager topicManager;
    @Autowired
    private ICourseCategoryManager courseCategoryManager;
    @Autowired
    private ICourseManager courseManager;
    @Autowired
    private ITrafficAnalysisManager trafficAnalysisManager;

    @Override
    public XView view() throws XException {
        XView view = new XView();
        view.setTopics(topicManager.countAllTopics());
        view.setCourseCategories(courseCategoryManager.queryAllCourseCategories().size());
        view.setCourses(courseManager.countAll());
        view.setViews(trafficAnalysisManager.countAll());
        return view;
    }
}
