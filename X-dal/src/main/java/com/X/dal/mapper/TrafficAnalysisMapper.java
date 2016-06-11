package com.X.dal.mapper;

import com.X.dal.domain.TrafficAnalysisDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by donahue on 5/22/16.
 */
@Repository
public interface TrafficAnalysisMapper {
    void save(TrafficAnalysisDO trafficAnalysis);
    long countAll();
    List<HashMap> visitedReport(@Param("fromDay")String fromDays,@Param("toDay")String toDay);
}
