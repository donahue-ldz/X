package com.X.web.module.admin.screen.json;

import com.X.biz.RunWrapper;
import com.X.dal.domain.PreviewDO;
import com.X.dal.mapper.PreviewMapper;
import com.X.web.common.BaseAction;
import com.X.web.common.WebJsonResult;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-26 AM9:48
 **/
public class PreviewRequest extends BaseAction {
    @Autowired
    private PreviewMapper previewMapper;
    public WebJsonResult doUpload(@Param("fileName") final String fileName,
                                  @Param("content") final String content) {
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                Preconditions.checkArgument(!StringUtils.isEmpty(content));
                final PreviewDO previewDO = new PreviewDO();
                previewDO.setFileName(fileName);
                previewDO.setContent(content);
                previewDO.setGmtCreate(new Date());
                RunWrapper.runWithArgsCheck(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        previewMapper.save(previewDO);
                        return null;
                    }
                }, previewDO);
                return new WebJsonResult().setObj(previewDO.getId());
            }
        });

    }
}
