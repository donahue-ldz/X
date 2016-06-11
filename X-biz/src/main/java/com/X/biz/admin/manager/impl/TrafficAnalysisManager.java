package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.ITrafficAnalysisManager;
import com.X.biz.admin.vo.SiteVisitedCountVO;
import com.X.biz.exception.XException;
import com.X.dal.domain.TrafficAnalysisDO;
import com.X.dal.mapper.TrafficAnalysisMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
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
    public List<SiteVisitedCountVO> visitedReport(final Date fromDay, final Date toDay) throws XException {
        return RunWrapper.run(new Callable<List<SiteVisitedCountVO>>() {
            @Override
            public List<SiteVisitedCountVO> call() throws Exception {
                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd");
                    }
                }.get();
                List<HashMap> maps =  trafficAnalysisMapper.visitedReport(format.format(fromDay), format.format(toDay));
                List<SiteVisitedCountVO> siteVisitedVOs = Lists.newArrayList();
                Calendar endCal = Calendar.getInstance();
                endCal.setTime(toDay);
                Calendar fromCal = Calendar.getInstance();
                fromCal.setTime(fromDay);
                while (!fromCal.after(endCal)){
                    boolean isExist = false;
                    for(HashMap map :maps){
                        if(map.get("time").equals(format.format(fromCal.getTime()))){
                            isExist = true;
                            siteVisitedVOs.add(map2VO(map));
                        }
                    }
                    if(!isExist){
                        siteVisitedVOs.add(new SiteVisitedCountVO(format.format(fromCal.getTime()),0));
                    }
                    fromCal.add(Calendar.DAY_OF_MONTH,1);

                }
                return siteVisitedVOs;

            }
        });
    }
    private SiteVisitedCountVO map2VO(Map map){
        SiteVisitedCountVO vo = new SiteVisitedCountVO();
        vo.setTime((String) map.get("time"));
        vo.setVisited((Long) map.get("visited"));
        return vo;
    }
}
