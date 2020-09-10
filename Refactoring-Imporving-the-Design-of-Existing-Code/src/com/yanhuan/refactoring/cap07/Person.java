package com.yanhuan.refactoring.cap07;

/**
 * 提炼类
 *
 * @author YanHuan
 * @date 2020-09-10 23:47
 */
public class Person {
    private String name;

    private TelephoneNumber officeTelephone = new TelephoneNumber();

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return officeTelephone.getTelephoneNumber();
    }

    public TelephoneNumber getOfficeTelephone() {
        return officeTelephone;
    }

}
