package com.X.aop.logger;

import java.util.Date;

/**
 * Created by dezhao.ldz on 4/14/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
@Log(LogLevel.ERROR)
public class Bean {
    private String name;
    private Date date;

    public String getName() {
        return name;
    }

    @Log(LogLevel.ERROR)
    public Bean setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Bean setDate(Date date) {
        this.date = date;
        return this;
    }
}
