package peaner.yier.utils.common.util;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * create by songning 2018/11/08
 * public methods about date
 */
public class DateUtil {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String MM_DD = "MM月dd日";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String YYYYMM = "yyyyMM";
    public static final String YYYYMMDD = "yyyyMMdd";

    public static String getBeforeAfterDateStr(int days){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,days);
        Date time=cal.getTime();
        return(new SimpleDateFormat(YYYY_MM_DD).format(time));
    }

    public static String getMonthDay(int days){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,days);
        Date time=cal.getTime();
        return(new SimpleDateFormat(MM_DD).format(time));
    }

    public static String getNowStr(){
        return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).format(new Date());
    }

    public static String getNowDateStr(){
        return new SimpleDateFormat(YYYY_MM_DD).format(new Date());
    }

    public static String getDateStr(long time) {
        return new SimpleDateFormat(YYYY_MM_DD).format(new Date(time));
    }

    public String getBeforeAfterMin(int mins){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MINUTE,mins);
        Date time=cal.getTime();
        return(new SimpleDateFormat(HH_MM_SS).format(time));
    }

    public static int getLeftSecondInCurrDay() {
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return (int) ((calendar.getTime().getTime() - nowDate.getTime()) / 1000);
    }

    public static String getYearMonthDay(Date date){
        return(new SimpleDateFormat(YYYYMMDD).format(date));
    }

    /**
     *  获取当天指定时间 时间戳
     */
    public static long getTime(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static Date getDateDay(String timeStr) throws ParseException {
        Date date = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(timeStr);
        return date;
    }

    public static Date getDateTime(String timeStr) throws ParseException {
        Date date = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(timeStr);
        return date;
    }

    public static String getYearMonth(Date date){
        return(new SimpleDateFormat(YYYYMM).format(date.getTime()));
    }

    /**
     * 获取当地时间所在周
     * 针对跨年周做处理
     * 2020-12-31 -- 202052
     * 2021-01-01 -- 202052
     * @return 例 202052
     */
    public static String getYearWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(7 );
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        if (week >= 52 && day < 7) {
            year -= 1;
        }
        return year + "" + week;
    }

    public static int getLeftSecondInCurrMonth() {
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return (int) ((calendar.getTime().getTime() - nowDate.getTime()) / 1000);
    }

    public static Date getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    public static Date getPrevMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    public static int getLeftSecondInCurrWeek() {
        DateTime dateTime = new DateTime();
        long weekEndTime = dateTime
                .withDayOfWeek(7).plusDays(1)
                .withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0)
                .toDate().getTime();

        return (int) ((weekEndTime - System.currentTimeMillis()) / 1000);
    }

    /**
     * 获取指定时间当周第一天的日期字符
     */
    public static String getWeekFirstDayStr(Date date) {
        DateTime dateTime = new DateTime(date);
        return getYearMonthDay(dateTime.withDayOfWeek(1).toDate());
    }

    /**
     * 获取指定时间前一周周第一天的日期
     */
    public static String getBeforeWeekFirstDayStr(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return getYearMonthDay(dateTime.minusWeeks(weeks).withDayOfWeek(1).toDate());
    }

    public static Date getBeforeWeekFirstDay(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.minusWeeks(weeks).withDayOfWeek(1).toDate();
    }

    public static String getBeforeDayStr(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return getYearMonthDay(dateTime.minusDays(days).toDate());
    }

    public static String getBeforeYearMonth(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return getYearMonth(dateTime.minusMonths(months).toDate());
    }



    public static void main(String[] args) {

        /*DateTime dateTime = DateTime.parse("2020-08-02");
        System.out.println(dateTime.withDayOfWeek(1).toDate());*/

        Date startDate = DateTime.parse("2021-05-13").toDate();
        Date endDate = DateTime.parse("2021-05-26").toDate();
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println("-------------");
        List<String> date = statisticsDate(startDate, endDate);

        System.out.println(date);

        System.out.println("-------------");

        for (int i = 0; i < date.size(); i += 2) {
            // int betweenDay = Days.daysBetween(new DateTime(date.get(i)).withMillisOfDay(0).toDateTime(), new DateTime(date.get(i + 1)).plusDays(1).withMillisOfDay(0).toDateTime()).getDays();
            String startTime = date.get(i);
            String endTime = date.get(i + 1);

            /*if (betweenDay < 7 && i < 1) {
                // System.out.println("aaaa1 [" + date.get(i) + "], [" + date.get(i + 1) + "]");
                startTime = date.get(i);
                // System.out.println("after1 [" + getDateStr(new DateTime(date.get(i)).plusDays(betweenDay-7).toDate().getTime()) + "], [" + date.get(i + 1) + "]");
            } else if (betweenDay < 7 && i >= date.size() - 2) {
                startTime = date.get(i);
                //System.out.println("bbbb2:[" + date.get(i) + "], [" + date.get(i + 1) + "]");
                continue;
            } else {
                // continue;
            }*/

            System.out.println("[" + startTime + "], [" + endTime + "]");
        }

    }

    public static List<String> statisticsDate(Date sDate, Date eDate) {
        List<String> listWeekOrMonth = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        sCalendar.setTime(sDate);

        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        eCalendar.setTime(eDate);

        boolean bool =true;
        while(sCalendar.getTime().getTime() < eCalendar.getTime().getTime()){
            if(bool || sCalendar.get(Calendar.DAY_OF_WEEK) == 2 || sCalendar.get(Calendar.DAY_OF_WEEK) == 1){
                listWeekOrMonth.add(dateFormat.format(sCalendar.getTime()));
                bool = false;
            }
            sCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
        if(listWeekOrMonth.size()%2!=0){
            listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
        }
        return listWeekOrMonth;
    }
}

