package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.ICreditReportManager;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.impl.StudentDBManager;
import com.X.common.utils.DateUtils;
import com.X.dal.domain.CreditReportDO;
import com.X.dal.domain.StudentDO;
import com.X.dal.mapper.GrantCreditMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-04 PM2:43
 **/
@Service("creditReportManager")
public class CreditReportManager implements ICreditReportManager {
    @Autowired
    private GrantCreditMapper grantCreditMapper;
    @Autowired
    private StudentDBManager studentDBManager;


    @Override
    public List<CreditReportDO> yearReport(final String studentID) throws XException {
        return RunWrapper.run(new Callable<List<CreditReportDO>>() {
            @Override
            public List<CreditReportDO> call() throws Exception {
                List<CreditReportDO> creditReportDOs =  grantCreditMapper.yearReport(studentID);
                List<CreditReportDO> allCredits = Lists.newArrayList();
                allCredits.addAll(creditReportDOs);
                StudentDO studentDO = studentDBManager.queryStudentByStuID(studentID);
                Date createTime = studentDO.getGmtCreate();
                Calendar endCal = Calendar.getInstance();
                Calendar fromCal = Calendar.getInstance();
                fromCal.setTime(createTime);
                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    protected synchronized SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy");
                        }
                    }.get();
                while (!fromCal.after(endCal)){
                    boolean isExist = false;
                    for(CreditReportDO creditReport:creditReportDOs){
                        if(creditReport.getTime().equals(String.valueOf(fromCal.get(Calendar.YEAR)))){
                            isExist = true;
                        }
                    }
                    if(!isExist){
                        allCredits.add(new CreditReportDO(format.format(fromCal.getTime()),0));
                    }
                    fromCal.add(Calendar.YEAR,1);
                }
                return allCredits;
            }
        });
    }

    @Override
    public List<CreditReportDO> monthReport(final String studentID, final Date fromMonth, final Date toMonth) throws XException {
        return RunWrapper.run(new Callable<List<CreditReportDO>>() {
            @Override
            public List<CreditReportDO> call() throws Exception {
                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd");
                    }
                }.get();

                SimpleDateFormat format2 = new ThreadLocal<SimpleDateFormat>() {
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM");
                    }
                }.get();
                Calendar toCal = Calendar.getInstance();
                toCal.setTime(toMonth);
                toCal.add(Calendar.MONTH,1);

                List<CreditReportDO> creditReportDOs = grantCreditMapper.monthReport(studentID, format.format(fromMonth), format.format(toCal.getTime()));
                List<CreditReportDO> allCredits = Lists.newArrayList();
                Calendar endCal = Calendar.getInstance();
                endCal.setTime(toMonth);
                Calendar fromCal = Calendar.getInstance();
                fromCal.setTime(fromMonth);
                while (!fromCal.after(endCal)){
                    boolean isExist = false;
                    for(CreditReportDO creditReport:creditReportDOs){
                        if(creditReport.getTime().equals(format2.format(fromCal.getTime()))){
                            isExist = true;
                            allCredits.add(creditReport);
                        }
                    }
                    if(!isExist){
                       allCredits.add(new CreditReportDO(format2.format(fromCal.getTime()),0));
                    }
                    fromCal.add(Calendar.MONTH,1);

                }
                return allCredits;
            }
        });
    }

    @Override
    public String getYearFrom(String studentID) throws XException {
        StudentDO studentDO = studentDBManager.queryStudentByStuID(studentID);
        SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
            @Override
            synchronized protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy");
            }
        }.get();
        return format.format(studentDO.getGmtCreate());
    }

    @Override
    public String getYearTo(String studentID) {
        return new ThreadLocal<SimpleDateFormat>() {
            @Override
            synchronized protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy");
            }
        }.get().format(new Date());
    }

    @Override
    public List<CreditReportDO> dayReport(final String studentID, final Date fromDay, final Date toDay) throws XException {
        return RunWrapper.run(new Callable<List<CreditReportDO>>() {
            @Override
            public List<CreditReportDO> call() throws Exception {
                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd");
                    }
                }.get();
                List<CreditReportDO> creditReportDOs =  grantCreditMapper.dayReport(studentID, format.format(fromDay), format.format(toDay));
                List<CreditReportDO> allCredits = Lists.newArrayList();
                Calendar endCal = Calendar.getInstance();
                endCal.setTime(toDay);
                Calendar fromCal = Calendar.getInstance();
                fromCal.setTime(fromDay);
                while (!fromCal.after(endCal)){
                    boolean isExist = false;
                    for(CreditReportDO creditReport:creditReportDOs){
                        if(creditReport.getTime().equals(format.format(fromCal.getTime()))){
                            isExist = true;
                            allCredits.add(creditReport);
                        }
                    }
                    if(!isExist){
                        allCredits.add(new CreditReportDO(format.format(fromCal.getTime()),0));
                    }
                    fromCal.add(Calendar.DAY_OF_MONTH,1);

                }
                return allCredits;

            }
        });
    }

    @Override
    public String getDayFrom() {
        SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
            @Override
            synchronized protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM");
            }
        }.get();
        String month = format.format(new Date());
        String day = "-01";
        return month.concat(day);
    }

    @Override
    public String getDayTo() {
        SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
            @Override
            synchronized protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd");
            }
        }.get();
        return format.format(new Date());
    }

    @Override
    public String getMonthForm() {
        SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
            @Override
            synchronized protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy");
            }
        }.get();
        String year = format.format(new Date());
        String month = "-01";
        return year.concat(month);
    }

    @Override
    public String getMonthTo() {
        SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
            @Override
            synchronized protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM");
            }
        }.get();
        return format.format(new Date());
    }
}
