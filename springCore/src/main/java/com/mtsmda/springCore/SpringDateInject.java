package com.mtsmda.springCore;

import java.util.Date;

/**
 * Created by MTSMDA on 25.05.2015.
 */
public class SpringDateInject {
    private Date date;

    public SpringDateInject() {

    }

    public SpringDateInject(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}