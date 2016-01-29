package com.mtsmda.souvenir.model;

import java.util.Date;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
public class SouvenirsAudit {

    private Souvenir souvenir;
    private Date createdDatetime;
    private Date lastUpdateDatetime;

    public SouvenirsAudit() {

    }

    public Souvenir getSouvenir() {
        return souvenir;
    }

    public void setSouvenir(Souvenir souvenir) {
        this.souvenir = souvenir;
    }

    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public Date getLastUpdateDatetime() {
        return lastUpdateDatetime;
    }

    public void setLastUpdateDatetime(Date lastUpdateDatetime) {
        this.lastUpdateDatetime = lastUpdateDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SouvenirsAudit that = (SouvenirsAudit) o;

        if (!souvenir.equals(that.souvenir)) return false;
        if (!createdDatetime.equals(that.createdDatetime)) return false;
        return lastUpdateDatetime.equals(that.lastUpdateDatetime);

    }

    @Override
    public int hashCode() {
        int result = souvenir.hashCode();
        result = 31 * result + createdDatetime.hashCode();
        result = 31 * result + lastUpdateDatetime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SouvenirsAudit{" +
                "souvenir=" + souvenir +
                ", createdDatetime=" + createdDatetime +
                ", lastUpdateDatetime=" + lastUpdateDatetime +
                '}';
    }
}