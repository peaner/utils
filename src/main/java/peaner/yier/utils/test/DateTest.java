package peaner.yier.utils.test;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Minutes;
import peaner.yier.utils.common.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Peaner
 * @time: 2020/9/24
 * @description:
 */
public class DateTest {

    public static void main(String[] args) {

        // function002();
        function003();

    }

    public static void function002() {
        try {

            String dateStr1 = "20200924";
            String dateStr2 = "20200922";

            // String dateStr1 = "2020-09-22 10:00:00";
            // String dateStr2 = "2020-09-25 10:00:00";
            Date start = DateUtil.getDateTime(dateStr1);
            Date end = DateUtil.getDateTime(dateStr2);

            System.out.println(start);
            System.out.println(end);


            Date startTime = new DateTime(start).withMillisOfDay(0).toDate();
            Date endTime = new DateTime(startTime).plusDays(1).withMillisOfDay(0).toDate();
            System.out.println("startTime:" + startTime +", endTime:" + endTime);

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void function001() {
        try {
            String dateStr1 = "2020-09-22 10:00:00";
            String dateStr2 = "2020-09-25 10:00:00";
            Date start = DateUtil.getDateTime(dateStr1);
            Date end = DateUtil.getDateTime(dateStr2);

            DateTime startBeginTime = new DateTime(start).withMillisOfDay(0).toDateTime();
            DateTime endBeginTime = new DateTime(end).plusDays(1).withMillisOfDay(0).toDateTime();
            System.out.println("startBeginTime:" + startBeginTime + ", endBeginTime:" + endBeginTime);

            int betweenDays = Days.daysBetween(startBeginTime, endBeginTime).getDays();
            System.out.println("betweenDays:" + betweenDays);



            Map<String, Integer> map = new HashMap<>();
            String key = DateUtil.getYearMonthDay(start);
            int minute = Minutes.minutesBetween(new DateTime(start).toDateTime(), new DateTime(start).plusDays(1).withMillisOfDay(0).toDateTime()).getMinutes();
            map.put(key, minute);

            for (int i = 1; i < betweenDays; i++) {
                DateTime pre = new DateTime(start).plusDays(i).withMillisOfDay(0).toDateTime();
                String dateKey = DateUtil.getYearMonthDay(pre.toDate());
                map.put(dateKey, 60 * 24);
            }

            String key2 = DateUtil.getYearMonthDay(end);
            int minute2 = Minutes.minutesBetween(new DateTime(end).withMillisOfDay(0).toDateTime(), new DateTime(end).toDateTime()).getMinutes();
            map.put(key2, minute2);

            for (Map.Entry entry : map.entrySet()) {
                System.out.println("dateKey:" + entry.getKey() + ", minutes:" + entry.getValue());
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void function003() {
        try {
            String dateStr1 = "2020-09-22 00:00:00";
            String dateStr2 = "2020-09-25 00:00:00";
            Date start = DateUtil.getDateTime(dateStr1);
            Date end = DateUtil.getDateTime(dateStr2);

            System.out.println("start:" + start + ", end:" + end);

            DateTime startBeginTime = new DateTime(start).withMillisOfDay(0).toDateTime();
            DateTime endBeginTime = new DateTime(end).plusDays(1).withMillisOfDay(0).toDateTime();
            System.out.println("startBeginTime:" + startBeginTime.toDate() + ", endBeginTime:" + endBeginTime.toDate());
        } catch (Exception e) {

        }

    }

}
