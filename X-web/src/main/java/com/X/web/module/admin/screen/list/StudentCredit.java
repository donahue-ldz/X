package com.X.web.module.admin.screen.list;

import com.X.biz.admin.manager.IGrantCreditManager;
import com.X.biz.admin.vo.StudentCreditVO;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.dal.domain.GrantCreditDO;
import com.X.dal.domain.StudentDO;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.X.common.utils.Tool.safeList;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-11 AM9:41
 **/
public class StudentCredit extends BaseScreen {
    @Autowired
    private IGrantCreditManager grantCreditManager;
    @Autowired
    private IStudentDBManager studentDBManager;


    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setStudentCredit(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setStudentCredit(Context context) throws XException {
        List<StudentDO> studentDOs = studentDBManager.queryAllStudents();
        List<StudentCreditVO> studentCreditVOs = Lists.newArrayList();
        for (StudentDO studentDO : studentDOs) {
            StudentCreditVO studentCreditVO = new StudentCreditVO();
            studentCreditVO.setStudentID(studentDO.getStudentID());
            studentCreditVO.setStudentName(studentDO.getStudentName());
            List<GrantCreditDO> grantCreditDOs = safeList(grantCreditManager.queryGrantsByStudentID(studentDO.getStudentID()));
            long sumScores = 0;
            for (GrantCreditDO grantCredit : grantCreditDOs) {
                sumScores += grantCredit.getScores();
            }
            studentCreditVO.setSumScores(sumScores);
            studentCreditVOs.add(studentCreditVO);
        }
        context.put("studentCreditVOs",studentCreditVOs);
    }


}
