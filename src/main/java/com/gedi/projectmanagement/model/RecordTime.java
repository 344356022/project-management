package com.gedi.projectmanagement.model;

import java.util.Date;

/**
 * @Author: renpu
 * @Date: 2019/6/10 8:54
 * @Description:
 */
public class RecordTime {

    private String timeId;

    private String detialDayDate;

    private String wId;

    public RecordTime() {
    }

    public RecordTime(String timeId, String detialDayDate, String wId) {
        this.timeId = timeId;
        this.detialDayDate = detialDayDate;
        this.wId = wId;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }

    public String getDetialDayDate() {
        return detialDayDate;
    }

    public void setDetialDayDate(String detialDayDate) {
        this.detialDayDate = detialDayDate;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    @Override
    public String toString() {
        return "RecordTime{" +
                "timeId='" + timeId + '\'' +
                ", detialDayDate='" + detialDayDate + '\'' +
                ", wId='" + wId + '\'' +
                '}';
    }
}
