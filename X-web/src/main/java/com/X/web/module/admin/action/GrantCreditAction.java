package com.X.web.module.admin.action;

import com.X.biz.admin.manager.IGrantCreditManager;
import com.X.dal.domain.AdminDO;
import com.X.dal.domain.GrantCreditDO;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-21 8:45 PM
 **/
public class GrantCreditAction extends BaseAction {
    @Autowired
    private IGrantCreditManager grantCreditManager;

    public void execute(TurbineRunData runData,
                        @Param("rules") final String rules,
                        @Param("scores") final Long scores,
                        @Param("description") final String description,
                        @Param("students") final String students) throws Exception {
        List<String> studentIDs = Splitter.on(",").splitToList(students);
        List<GrantCreditDO> grantCreditDOs = Lists.newArrayList();
        for (String studentID : studentIDs) {
            AdminDO admin = (AdminDO) getUser();
            GrantCreditDO grantCredit = new GrantCreditDO();
            grantCredit.setCreator(admin.getAdminName());
            grantCredit.setGmtCreate(new Date());
            grantCredit.setRules(rules);
            grantCredit.setScores(scores);
            grantCredit.setStudentID(studentID);
            grantCredit.setDescription(description);
            grantCreditDOs.add(grantCredit);
        }
        grantCreditManager.saveList(grantCreditDOs);

    }
}
