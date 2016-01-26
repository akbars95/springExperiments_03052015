package com.mtsmda.souvenir.model;

import java.io.Serializable;

/**
 * Created by MTSMDA on 16.11.2015.
 */
public class Souvenir implements Serializable{

    private Integer souvenirId;
    private String souvenirName;
    private String souvenirDescription;
    private Boolean souvenirShow;
    private String souvenirPath;

    public Souvenir() {

    }

    public Integer getSouvenirId() {
        return souvenirId;
    }

    public void setSouvenirId(Integer souvenirId) {
        this.souvenirId = souvenirId;
    }

    public String getSouvenirName() {
        return souvenirName;
    }

    public void setSouvenirName(String souvenirName) {
        this.souvenirName = souvenirName;
    }

    public String getSouvenirDescription() {
        return souvenirDescription;
    }

    public void setSouvenirDescription(String souvenirDescription) {
        this.souvenirDescription = souvenirDescription;
    }

    public Boolean getSouvenirShow() {
        return souvenirShow;
    }

    public void setSouvenirShow(Boolean souvenirShow) {
        this.souvenirShow = souvenirShow;
    }

    public String getSouvenirPath() {
        return souvenirPath;
    }

    public void setSouvenirPath(String souvenirPath) {
        this.souvenirPath = souvenirPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Souvenir souvenir = (Souvenir) o;

        if (!souvenirId.equals(souvenir.souvenirId)) return false;
        if (!souvenirName.equals(souvenir.souvenirName)) return false;
        if (!souvenirDescription.equals(souvenir.souvenirDescription)) return false;
        if (!souvenirShow.equals(souvenir.souvenirShow)) return false;
        return souvenirPath.equals(souvenir.souvenirPath);

    }

    @Override
    public int hashCode() {
        int result = souvenirId.hashCode();
        result = 31 * result + souvenirName.hashCode();
        result = 31 * result + souvenirDescription.hashCode();
        result = 31 * result + souvenirShow.hashCode();
        result = 31 * result + souvenirPath.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "souvenirId=" + souvenirId +
                ", souvenirName='" + souvenirName + '\'' +
                ", souvenirDescription='" + souvenirDescription + '\'' +
                ", souvenirShow=" + souvenirShow +
                ", souvenirPath='" + souvenirPath + '\'' +
                '}';
    }
}