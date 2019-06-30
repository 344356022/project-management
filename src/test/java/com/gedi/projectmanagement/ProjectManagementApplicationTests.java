package com.gedi.projectmanagement;


import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagementApplicationTests {

    @Autowired
    private WeekReportService weekReportService;

    @Test
    public void contextLoads() {
        String s = UUIDUtil.getUUID2();
        System.out.println(s);
    }

  /*  @Test
    public void test1(){

        Date date1=new Date();
        String date= new SimpleDateFormat("yyyy-MM-dd").format(date1);
        System.out.println(date);

        Date da=null;
        //获取当前日期所在的周的下周周五
        Map<String, String> dateMap = null;
        try {
            SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
            dateMap = TestTime.getNextWeek(date);
            String s = dateMap.get("endDateNext");
             da= sdf.parse(s);
            System.out.println(da+"-----------");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> dates = DetialDayDate.findDates(date1, da);

        for (String s : dates) {

            System.out.println(s);

        }
    }

    @Test
    public void test66(){

        List<Date> tweleveDayDates=new ArrayList<>();
        List<String> tweleveDayDate = DetialDayDate.getTweleveDayDate();

        for (String s : tweleveDayDate) {
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            try {
                Date parse = sdf.parse(s);
                tweleveDayDates.add(parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println(tweleveDayDates);
    }


    @Test
    public void test668899(){

        List<User> users = userMapper.selectUserBySign();

        for (User user : users) {

            System.out.println(
                    user
            );

        }


    }

    @Test
    public void test666777(){

        List<User> users = userMapper.selectUserByDepartment("117443437");

        for (User user : users) {

            System.out.println(user);

        }


    }


    @Test
    public void test56688(){

        List<String> beforeOrAfterDate = DetialDayDate.getBeforeOrAfterDate();
        for (String s : beforeOrAfterDate) {
            System.out.println(s);

        }

    }



    }*/

}
