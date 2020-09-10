package com.yanhuan.refactoring.cap07;

/**
 * 提炼类
 *
 * @author YanHuan
 * @date 2020-09-10 23:52
 */
public class TelephoneNumber {
    private String areaCode;
    private String officeNumber;

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTelephoneNumber() {
        return ("（" + areaCode + "）" + officeNumber);
    }
}
