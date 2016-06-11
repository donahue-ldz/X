package com.X.web.module.admin.screen.list;

import com.X.biz.admin.manager.IGrantCreditManager;
import com.X.biz.admin.vo.StudentCreditItemVO;
import com.X.biz.admin.vo.StudentCreditVO;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.dal.domain.GrantCreditDO;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.X.common.utils.Tool.safeList;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-11 AM10:18
 **/
public class StudentCreditItems extends BaseScreen {
    @Autowired
    private IGrantCreditManager grantCreditManager;
    @Autowired
    private IStudentDBManager studentDBManager;


    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setCreditItems(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setCreditItems(Context context) throws XException {
        String studentID = reqContext.getParameters().getString("studentID");
        String studentName = reqContext.getParameters().getString("studentName");
        if (Strings.isNullOrEmpty(studentName)) {
            studentName = studentDBManager.queryStudentByStuID(studentID).getStudentName();
        }
        //积分来源一:手动授权
        List<GrantCreditDO> grantCreditDOs = safeList(grantCreditManager.queryGrantsByStudentID(studentID));
        //积分来源二:大数据分析

        //积分汇总
        List<StudentCreditItemVO> studentCreditItemVOs = Lists.newArrayList();
        for (GrantCreditDO grantCreditDO : grantCreditDOs) {
            studentCreditItemVOs.add(StudentCreditItemVO.convert(grantCreditDO));
        }
        context.put("creditItems", studentCreditItemVOs);
        context.put("studentName", studentName);
    }
}
