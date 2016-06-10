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

    /**
     * 开始年,注册年
     * @return
     */
    String getYearFrom(String studentID) throws XException;

    /**
     * 当前年
     * @return
     */
    String getYearTo(String studentID) throws XException;
    /**
     * 获取报表展示的默认起始天
     * 当前月的第一天
     * @return
     */
    String getDayFrom();


    /**
     * 获取报表展示的默认结束天
     * 当前天
     * @return
     */
    String getDayTo();

    /**
     * 获取报表展示的默认起始月
     * 当年的第一个月
     * @return
     */
    String getMonthForm();

    /**
     * 获取报表展示的默认结束月
     * 当月
     * @return
     */
    String getMonthTo();

}
