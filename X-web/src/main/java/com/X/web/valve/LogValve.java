package com.X.web.valve;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.Valve;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.alibaba.citrus.turbine.util.TurbineUtil.getTurbineRunData;

/**
 * Created by dezhao.ldz on 4/26/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class LogValve implements Valve {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Override
    public void invoke(PipelineContext pipelineContext) throws Exception {
        try {
            TurbineRunData rundata = getTurbineRunData(request);
            pipelineContext.invokeNext();
        } finally {

        }

    }
}
