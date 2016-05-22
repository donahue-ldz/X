package com.X.dal.mapper;

import com.X.dal.domain.TrafficAnalysisDO;
import org.springframework.stereotype.Repository;

/**
 * Created by donahue on 5/22/16.
 */
@Repository
public interface TrafficAnalysisMapper {
    void save(TrafficAnalysisDO trafficAnalysis);
    long countAll();
}
