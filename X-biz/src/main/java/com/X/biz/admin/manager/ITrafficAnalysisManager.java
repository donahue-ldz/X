package com.X.biz.admin.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.TrafficAnalysisDO;

/**
 * Created by donahue on 5/22/16.
 */
public interface ITrafficAnalysisManager {
    long save(TrafficAnalysisDO trafficAnalysis) throws XException;

    long countAll() throws XException;
}
