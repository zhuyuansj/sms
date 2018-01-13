package com.paic.loancloud.sms.model.entity;

import java.security.Timestamp;

/**
 * Created by sunjian on 2017/3/27.
 */
public class SmsDemoDao {
    private int id;
    private String name;
    private Timestamp updateTime;
    private Timestamp update_time;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SmsDemoDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updateTime=" + updateTime +
                ", update_time=" + update_time +
                ", password='" + password + '\'' +
                '}';
    }
}
