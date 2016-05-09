package com.X.web.common;

import com.alibaba.citrus.service.requestcontext.parser.ParserRequestContext;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 定义算法的骨架
 * 针对权限管理
 */
public abstract class BaseScreen {
    protected static final Logger log = LoggerFactory.getLogger(BaseScreen.class);
    @Resource
    protected ParserRequestContext reqContext;
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;
    @Resource
    protected HttpSession session;
    private ThreadLocal<TurbineRunData> runData = new ThreadLocal<TurbineRunData>();

    protected TurbineRunData getRunData() {
        return runData.get();
    }

//    public void execute(Context context, TurbineRunData runData) {
//        this.runData.set(runData);
//        Profiler.start(request.getServletPath());
//        WebResult webResult = new WebResult();
//        try {
//            // 判断有没有权限访问页面
//            if (!validateAuth()) {
//                String url = request.getRequestURL().toString();
//                List<String> permissions = getPermissionList();
//                /**最小访问权限**/
//                String miniPermission = permissions.get(permissions.size() - 1);
//                Map<String, Object> otherData = new HashMap<String, Object>();
//
//                otherData.put("permission", miniPermission);
//                if (url.indexOf(OpsConstant.AMSOPS_ONLINE_SUFFIX)!=-1) {
//                    otherData.put("online", true);
//                } else {
//                    otherData.put("online", false);
//                }
//                webResult.setOtherData(otherData);
//
//                String authPage = "/error/noPermission.vm";
//
//                runData.setRedirectTarget(authPage);
//            } else {
//                webResult = handleRequest(context);
//            }
//        } catch (CookieNullException ex) {
//            String url = request.getRequestURL().toString();
//            Map<String, Object> otherData = new HashMap<String, Object>();
//            if (url.indexOf(OpsConstant.AMSOPS_ONLINE_SUFFIX)!=-1) {
//                otherData.put("online", true);
//            } else {
//                otherData.put("online", false);
//            }
//            webResult.setOtherData(otherData);
//
//        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
//            webResult.setErrorMsg(ex.getMessage());
//            String errorPage = "/error/error.vm";
//            runData.setRedirectTarget(errorPage);
//            return ;
//        }
//        context.put("webResult", webResult);
//    }
//
//    /**
//     * 页面授权验证
//     *
//     * @return
//     */
//    protected boolean validateAuth() {
//        try {
//            return BucAclValidateAuth.validateAuthScreen(request, this.getPermissionList());
//        } catch (Exception e) {
//            log.error("get ssouer or check user permisson error.", e);
//        }
//        return false;
//    }
//
//    /**
//     * 执行请求
//     *
//     * @return
//     */
//    protected abstract WebResult handleRequest(Context context) throws Exception;
//
//    /**
//     * 获得访问页面所需的权限列表
//     *
//     * @return
//     */
//    protected abstract List<String> getPermissionList() throws AmsOpsBizException;
//
//    protected String getCurrentAppName() throws AmsOpsBizException {
//        String empId = null;
//        try {
//            empId = getCurrentUserEmpId();
//        } catch (Exception e) {
//            throw new AmsOpsBizException("buc query user empId error: " + e.getMessage(), e);
//        }
//        SystemAdminDO systemAdmin = systemAdminManager.getSystemAdminByEmpId(empId).getObj();
//        if (systemAdmin != null) {
//            return AmswebConstant.ADMIN_DEFAULT_APP;
//        }
//        String token = EnvCookiesUtils.getToken(request);
//        ProjectDO project = null;
//        project = projectManager.getSimpleProjectByToken(token).getObj();
//
//        Assert.notNull(project, "can not find project associate with token: " + token);
//        String appName = project.getName();
//        return appName;
//    }
//
//    /**
//     * 检查cookie 是否有效
//     * 没有效将直接不能访问页面，避免一部分cookie失效提示不友好
//     *
//     * @return
//     */
//    protected boolean validateEnvCookies() {
//        try {
//            String ns = CookiesUtils.getNS(request);
//            return true;
//        } catch (CookieNullException e) {
//            return true;
//        }
//    }
//
//	///////////////////////// 用户名统一 ////////////////////////////////////////
//	protected String getLoginId() {
//		return BucAclValidateAuth.getUserLoginId(request).replaceAll("@.+\\..+", "");
//	}
//	protected String getCurrentUserNickNameCn() throws IOException, ServletException {
//		return getLoginId();
//	}
//	protected String getCurrentUserEmpId() throws IOException, ServletException {
//		return getLoginId();
//	}
//    ///////////////////////// 需要用戶ID ////////////////////////////////////////
//    protected String getCurrentUserId() throws IOException,ServletException{
//        BucSSOUser user = SimpleUserUtil.getBucSSOUser(request);
//        String currentUserUserId = null;
//        if (user != null) {
//            currentUserUserId = String.valueOf(user.getId());
//        }
//        return currentUserUserId;
//
//    }
//	/////////////////////////////////////////////////////////////////
//    protected UserWrapper getUserWrapper() throws Exception{
//        BucSSOUser user = SimpleUserUtil.getBucSSOUser(request);
//        Preconditions.checkNotNull(user,"用户登陆信息不能获取,请退出并重新登陆...");
//        UserWrapper wrapper = new UserWrapper();
//        wrapper.setEmpId(user.getEmpId());
//        wrapper.setLoginId(user.getAccount().replaceAll("@.+\\..+", ""));
//        wrapper.setNickNameCn(user.getNickNameCn() == null ? user.getLastName() : user.getNickNameCn());
//        return wrapper;
//    }
}