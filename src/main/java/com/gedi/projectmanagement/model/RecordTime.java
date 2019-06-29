package com.gedi.projectmanagement.model;



/**
 * @Author: renpu
 * @Date: 2019/6/10 8:54
 * @Description:
 */
public class RecordTime {

    private String timeId;

    private String name;

    private String wId;

    private String isSelect;

    private Integer nums;

    private Integer sorts;

    public RecordTime() {
    }



    public RecordTime(String timeId, String name, String wId, String isSelect, Integer nums, Integer sorts) {
        this.timeId = timeId;
        this.name = name;
        this.wId = wId;
        this.isSelect = isSelect;
        this.nums = nums;
        this.sorts = sorts;
    }

    public RecordTime(String timeId, String name, String wId) {
        this.timeId = timeId;
        this.name = name;
        this.wId = wId;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public String getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(String isSelect) {
        this.isSelect = isSelect;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", wId='" + wId + '\'' +
                ", isSelect='" + isSelect + '\'' +
                ", nums=" + nums +
                ", sorts=" + sorts +
                '}';
    }
}
