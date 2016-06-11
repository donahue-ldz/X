package com.X.biz.admin.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.GrantCreditDO;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by donahue on 5/21/16.
 */

public interface IGrantCreditManager {
    long save(GrantCreditDO grantCredit) throws XException;

    void saveList(List<GrantCreditDO> grantCredits) throws XException;

    List<GrantCreditDO> queryGrantsByStudentID(@NotNull String studentID) throws XException;


    List<GrantCreditDO> queryAllGrants() throws XException;

    GrantCreditDO queryGrantByID(@NotNull Long id) throws XException;
}

