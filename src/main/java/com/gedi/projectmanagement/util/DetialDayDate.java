package com.gedi.projectmanagement.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

/**
 * @Author: renpu
 * @Date: 2019/6/9 21:14
 * @Description:
 */
public class DetialDayDate {

    public static List<String> findDates(Date dBegin, Date dEnd){
        List<String> lDate = new ArrayList<String>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        lDate.add(sd.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }
        return lDate;
    }

    public static List<String> removeWeekEndDate(String startTime,String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = null;
        try {
            dBegin = sdf.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dEnd = null;
        try {
            dEnd = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> datas = findDates(dBegin, dEnd);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date;

        for(int i=0; i<datas.size();i++){
            try {
                date=sdf.parse(datas.get(i));
                cal.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;

            String weekDay = weekDays[w];
            if(w==0||w==6){
                datas.remove(i);
                i--;
            }
        }
        return datas;
    }


    public static Map<String, String> getNextWeek(String queryDate) throws ParseException{

        Map<String, String> dateMap = new HashMap<String,String>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal1 = Calendar.getInstance();

        Calendar cal2 =Calendar.getInstance();

        cal1.setTime(sdf.parse(queryDate));

        cal2.setTime(sdf.parse(queryDate));

        int dayWeek = cal1.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        if(dayWeek == 1){
            cal2.add(Calendar.DAY_OF_MONTH, 5);
        } else {
            cal2.add(Calendar.DAY_OF_MONTH, 1-dayWeek+15);
        }

        // 下周 周五日期

        String endDateNext  = sdf.format(cal2.getTime());

        dateMap.put("endDateNext", endDateNext);

        return dateMap;
    }


    //获取连续十二天每天所对应的具体日期；
    public static List<String> getBeforeOrAfterDate() {
//        Date date=new Date();
        Date myDate1=null;
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
             myDate1 = dateFormat1.parse("2009-06-04");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();//获取日历
        calendar.setTime(myDate1);//当date的值是当前时间，则可以不用写这段代码。
        calendar.add(Calendar.DATE, 12);
        Date d = calendar.getTime();//把日历转换为Date
       return findDates(myDate1,d);
    }

    //获取连续十二天每天所对应的具体日期；
    public static List<String> getTweleveDayDates(){
        Date date1=new Date();
        String date= new SimpleDateFormat("yyyy-MM-dd").format(date1);
        Date da=null;
        //获取当前日期所在的周的下周周五
        Map<String, String> dateMap = null;
        try {
            SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
            dateMap =getNextWeek(date);
            String s = dateMap.get("endDateNext");
            da= sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return findDates(date1, da);
    }


    /*public static List<Date> getTweleveDayDates(){

        List<Date> tweleveDayDates=new ArrayList<>();
        List<String> tweleveDayDate = getTweleveDayDate();
        for (String s : tweleveDayDate) {
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            try {
                Date parse = sdf.parse(s);
                tweleveDayDates.add(parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return tweleveDayDates;
    }*/


    //根据系统时间获取本周的周一所对应的具体日期，以及连续11天所对应的日期；
    public static List<String> getTweleveDayDate() {
        List<String> list = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        LocalDate reviewTime = localDate.with(DayOfWeek.MONDAY);
        for (int i = 0; i <= 11; i++) {
            list.add(reviewTime.plusDays(i).toString());
        }
        return list;
    }



}
