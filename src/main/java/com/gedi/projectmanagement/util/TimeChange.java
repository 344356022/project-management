package com.gedi.projectmanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: renpu
 * @Date: 2019/6/30 19:02
 * @Description:
 */
public class TimeChange {

    public static String getTime(String praTime){
        Date date = new Date(praTime);
        String c=null;
        try{
            c = new SimpleDateFormat("yyyy-MM-dd").format(date);
            System.out.println(c);
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }
}
