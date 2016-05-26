package com.X.web.module.admin.screen.toolkit;

import com.X.dal.domain.PreviewDO;
import com.X.dal.mapper.PreviewMapper;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.PrintWriter;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-26 AM10:01
 **/
public class Preview {
    @Autowired
    private PreviewMapper previewMapper;

    public void execute(Context context, TurbineRunData runData) throws Exception {
        long id = runData.getParameters().getLong("id", 0);
        if (id > 0) {
            PreviewDO previewDO = previewMapper.queryPreviewByID(id);
            String content = previewDO.getContent();
            PrintWriter printWriter = runData.getResponse().getWriter();
            printWriter.print(content);
            printWriter.flush();
            printWriter.close();
        }

    }
}
