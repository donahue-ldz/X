package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.ITrafficAnalysisManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TrafficAnalysisDO;
import com.X.dal.mapper.TrafficAnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-22 10:20 AM
 **/
@Service("trafficAnalysisManager")
public class TrafficAnalysisManager implements ITrafficAnalysisManager {
    @Autowired
    private TrafficAnalysisMapper trafficAnalysisMapper;

    @Override
    public long save(final TrafficAnalysisDO trafficAnalysis) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                trafficAnalysisMapper.save(trafficAnalysis);
                return trafficAnalysis.getId();
            }
        }, trafficAnalysis);
    }

    @Override
    public long countAll() throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return trafficAnalysisMapper.countAll();
            }
        });
    }
}
