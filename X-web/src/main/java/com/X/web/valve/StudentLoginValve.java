package com.X.web.valve;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.support.AbstractValve;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.alibaba.citrus.turbine.util.TurbineUtil.getTurbineRunData;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-01 PM4:14
 **/
public class StudentLoginValve extends AbstractValve {
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest request;


    @Override
    public void invoke(PipelineContext pipelineContext) throws Exception {
        TurbineRunData runData = getTurbineRunData(request);
        String url = runData.getRequest().getRequestURI();
        String studentLoginURL = "/form/loginAndRegister.htm";
        if(!url.contains("/admin")) {
            Object o = session.getAttribute("user");
            if (null == o) {
                runData.setRedirectLocation(studentLoginURL);
            }
        }
    }
}
