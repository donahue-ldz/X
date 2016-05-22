package com.X.web.valve;

import com.X.biz.admin.manager.ITrafficAnalysisManager;
import com.X.common.utils.Tool;
import com.X.dal.domain.TrafficAnalysisDO;
import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.PipelineException;
import com.alibaba.citrus.service.pipeline.Valve;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Calendar;
import java.util.Date;

import static com.alibaba.citrus.turbine.util.TurbineUtil.getTurbineRunData;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-22 9:21 AM
 **/
public class TrafficAnalysisValve implements Valve {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ITrafficAnalysisManager trafficAnalysisManager;

    public final static String COOKIE_NAME = "X_trafficAnalysis";

    @Override
    public void invoke(PipelineContext pipelineContext) throws Exception {
        try {
            Cookie[] cookies = request.getCookies();
            boolean isExist = false;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(COOKIE_NAME)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                TrafficAnalysisDO trafficAnalysis = new TrafficAnalysisDO();
                trafficAnalysis.setGmtCreate(new Date());
                trafficAnalysis.setIp(Tool.getRequestIp(request));
                trafficAnalysisManager.save(trafficAnalysis);

                Cookie cookie = new Cookie(COOKIE_NAME, "true");
                cookie.setPath("/");
                Calendar calendar = Calendar.getInstance();
                Date now = calendar.getTime();
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                Date end = calendar.getTime();
                int seconds = (int) ((end.getTime() - now.getTime()) / 1000);
                cookie.setMaxAge(seconds);

                response.addCookie(cookie);
            }
            pipelineContext.invokeNext();

        } catch (Exception e) {
            if (!(e instanceof PipelineException))
                pipelineContext.invokeNext();
        } finally {

        }

    }
}
