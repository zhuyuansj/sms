package com.paic.loancloud.sms.model.entity;

import org.springframework.stereotype.Component;

/**
 * Created by sunjian on 2017/4/4.
 */
@Component
public class Test<T1,T2> {
    private T1 name;
    private T2 password;

    public T1 getName() {
        return name;
    }

    public void setName(T1 name) {
        this.name = name;
    }

    public T2 getPassword() {
        return password;
    }

    public void setPassword(T2 password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name=" + name +
                ", password=" + password +
                '}';
    }
}
