package peaner.yier.utils.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Peaner
 * @time: 2021/3/31
 * @description:
 */
public class DTest {

    public static void main(String[] args) {
        List<String> signInDateStrs = new ArrayList<>();
        signInDateStrs.add("2020-03-01");
        signInDateStrs.add("2020-03-03");
        signInDateStrs.add("2020-03-02");
        List<Date> signInDates = new ArrayList<>();

        try {
            for (String dateStr : signInDateStrs) {
                Calendar calendarTo = Calendar.getInstance();
                calendarTo.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(0);
                c.set(calendarTo.get(Calendar.YEAR), calendarTo.get(Calendar.MONTH),
                        calendarTo.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                signInDates.add(c.getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int count = persistentDay(signInDates);
        System.out.println("已连续签到 " + count + "天");

    }


    private static int persistentDay(List<Date> signInDates) {
        //定义一个变量表示连续签到天数，从1开始
        int continuousDays = 1;

        /**
         * 如果手动签到的话需要考虑
         * 把排序之后的签到记录时间中最大的那个时间拿出来与 昨天 进行比较，如果相等证明还是连续签到的，如果不等则连续签到变成0
         */
        /*Calendar yesterday = Calendar.getInstance();
        yesterday.setTime(new Date());
        yesterday.add(Calendar.DAY_OF_MONTH, -1);

        Calendar lastDay = Calendar.getInstance();
        lastDay.setTime(signInDates.get(signInDates.size() - 1));
        if (yesterday.get(Calendar.YEAR) != lastDay.get(Calendar.YEAR)
                || yesterday.get(Calendar.MONTH) != lastDay.get(Calendar.MONTH)
                || yesterday.get(Calendar.DAY_OF_YEAR) != lastDay.get(Calendar.DAY_OF_YEAR)) {
            //昨天没有签到
            continuousDays = 0;
            return continuousDays;
        }*/

        /**
         * 2. 从最大的时间开始往前比较，因为我们是要拿连续签到的时间，这样才有意义，减少无谓的比较
         */
        Calendar later = Calendar.getInstance();
        Calendar before = Calendar.getInstance();
        for (int i = signInDates.size() - 1; i > 0; i--) {
            later.setTime(signInDates.get(i));
            before.setTime(signInDates.get(i - 1));
            //前一天 + 1天 = 后一天，则视为连续签到
            before.add(Calendar.DAY_OF_MONTH, 1);
            if (later.get(Calendar.YEAR) == before.get(Calendar.YEAR)
                    && later.get(Calendar.MONTH) == before.get(Calendar.MONTH)
                    && later.get(Calendar.DAY_OF_YEAR) == before.get(Calendar.DAY_OF_YEAR)) {
                continuousDays++;
            } else {
                //只要遇到不连续的就不用再往前比较了
                break;
            }
        }
        return continuousDays;
    }

}
