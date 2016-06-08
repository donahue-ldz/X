package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.ICreditReportManager;
import com.X.biz.exception.XException;
import com.X.common.utils.DateUtils;
import com.X.dal.domain.CreditReportDO;
import com.X.dal.mapper.GrantCreditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    @Override
    public List<CreditReportDO> yearReport(final String studentID) throws XException {
        return RunWrapper.run(new Callable<List<CreditReportDO>>() {
            @Override
            public List<CreditReportDO> call() throws Exception {
                return grantCreditMapper.yearReport(studentID);
            }
        });
    }

    @Override
    public List<CreditReportDO> monthReport(final String studentID, final Date fromMonth, final Date toMonth) throws XException {
        return RunWrapper.run(new Callable<List<CreditReportDO>>() {
            @Override
            public List<CreditReportDO> call() throws Exception {
                SimpleDateFormat format  = new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM");
                    }
                }.get();
                return grantCreditMapper.monthReport(studentID,format.format(fromMonth),format.format(toMonth));
            }
        });
    }

    @Override
    public List<CreditReportDO> dayReport(final String studentID, final Date fromDay, final Date toDay) throws XException {
        return RunWrapper.run(new Callable<List<CreditReportDO>>() {
            @Override
            public List<CreditReportDO> call() throws Exception {
                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd");
                    }
                }.get();
                return grantCreditMapper.dayReport(studentID,format.format(fromDay),format.format(toDay));
            }
        });
    }
}
