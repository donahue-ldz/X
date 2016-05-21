package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.IGrantCreditManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.GrantCreditDO;
import com.X.dal.mapper.GrantCreditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.Callable;

import static com.X.common.utils.Tool.safeList;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-21 8:41 PM
 **/
@Service("grantCreditManager")
@Transactional(rollbackFor = Exception.class)
public class GrantCreditManager implements IGrantCreditManager {
    @Autowired
    private GrantCreditMapper grantCreditMapper;

    @Override
    public long save(final GrantCreditDO grantCredit) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                grantCreditMapper.save(grantCredit);
                return grantCredit.getId();
            }
        }, grantCredit);
    }

    @Override
    public void saveList(List<GrantCreditDO> grantCredits) throws XException {
        for (GrantCreditDO grantCredit : safeList(grantCredits)) {
            save(grantCredit);
        }
    }

    @Override
    public List<GrantCreditDO> queryGrantsByStudentID(@NotNull final Long studentID) throws XException {
        return RunWrapper.run(new Callable<List<GrantCreditDO>>() {
            @Override
            public List<GrantCreditDO> call() throws Exception {
                return grantCreditMapper.queryGrantsByStudentID(studentID);
            }
        });
    }

    @Override
    public List<GrantCreditDO> queryAllGrants() throws XException {
        return RunWrapper.run(new Callable<List<GrantCreditDO>>() {
            @Override
            public List<GrantCreditDO> call() throws Exception {
                return grantCreditMapper.queryAllGrants();
            }
        });
    }

    @Override
    public GrantCreditDO queryGrantByID(@NotNull final Long id) throws XException {
        return RunWrapper.run(new Callable<GrantCreditDO>() {
            @Override
            public GrantCreditDO call() throws Exception {
                return grantCreditMapper.queryGrantByID(id);
            }
        });
    }
}
