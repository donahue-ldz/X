package com.X.web.valve;

import com.X.biz.admin.manager.IAdminDBManager;
import com.X.dal.domain.AdminDO;
import com.X.dal.domain.Role;
import com.X.dal.domain.User;
import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.support.AbstractValve;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.google.common.base.CharMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.alibaba.citrus.turbine.util.TurbineUtil.getTurbineRunData;

/**
 * Created by dezhao.ldz on 4/27/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class AdminRoleValve extends AbstractValve {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;

    @Override
    public void invoke(PipelineContext pipelineContext) throws Exception {
        String adminModule = "/admin";
        String loginURL = adminModule + "/form/login.htm";
        TurbineRunData runData = getTurbineRunData(request);
        String url = runData.getRequest().getRequestURI();
        if (url.indexOf(adminModule) != -1 && !loginURL.equals(url) && url.indexOf("login.json") == -1) {
            String pre = url.substring(0, url.indexOf(adminModule)).toLowerCase();
            if (!CharMatcher.JAVA_LOWER_CASE.matchesAnyOf(pre)) {
                Object o = session.getAttribute("user");
                if (o == null) {
                    runData.setRedirectLocation(loginURL);

                } else {
                    User user = (User) o;
                    if (!Role.ADMIN.SQLValue().equals(user.role().SQLValue())) {
                        runData.setRedirectLocation(loginURL);
                    }
                }
            }
        }
        pipelineContext.invokeNext();
    }
}
