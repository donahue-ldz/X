package com.X.biz.admin.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.CreditReportDO;

import java.util.Date;
import java.util.List;

/**
 * Created by donahue on 16/6/4.
 */
public interface ICreditReportManager {
    List<CreditReportDO> yearReport(String studentID) throws XException;
    List<CreditReportDO> monthReport(String studentID,Date fromMonth,Date toMonth) throws XException;
    List<CreditReportDO> dayReport(String studentID,Date fromDay,Date toDay) throws XException;
}
