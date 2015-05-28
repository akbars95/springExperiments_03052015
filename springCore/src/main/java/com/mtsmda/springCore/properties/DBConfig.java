package com.mtsmda.springCore.properties;

/**
 * Created by MTSMDA on 28.05.2015.
 */
public class DBConfig {
    private String driverClassName;
    private String urlDB;
    private String username;
    private String password;

    public DBConfig() {

    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrlDB() {
        return urlDB;
    }

    public void setUrlDB(String urlDB) {
        this.urlDB = urlDB;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}