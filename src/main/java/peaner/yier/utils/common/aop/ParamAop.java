package peaner.yier.utils.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Component
@Aspect
public class ParamAop {

    private static final Logger logger = LoggerFactory.getLogger(ParamAop.class);
    static final String split = ",";

    //@Pointcut("@annotation(com.example.judgeparameter.aop.RequestRequire)")
    public void controllerInteceptor() {
    }

    public static void main(String[] args) {

        //Long time = DateTime.now().withMillisOfDay(0).plusDays(1).getMillis();
        /*DateTime dateTime = new DateTime(time);
        System.out.println("time: " + dateTime.toDate());*/

        /*System.out.println("startTime: " + DateTime.now().toDateTime());
        System.out.println("endTime: " + DateTime.now().plusDays(1).toDateTime());


        int betweenDays = Days.daysBetween(DateTime.now().plusHours(24).toDateTime(), DateTime.now().toDateTime()).getDays();
        System.out.println("betweenDays: " + betweenDays);*/

        /*Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);

        getSingleLiveRoomValidDay(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
        getSingleLiveRoomValidDay(map);*/
        //Long time = DateTime.now().withDayOfMonth(1).getMillis();
        //Period period = new Period();
        //Date start = DateTime.now().withDayOfMonth(1).withMillisOfDay(0).toDate();
        // Date end = DateTime.now().withDayOfMonth(31).plusDays(1).withMillisOfDay(0).toDate();

        /*Date start = DateTime.parse("2020-08-01").toDate();
        Date end = DateTime.parse("2020-08-31").plusDays(1).toDate()`;

        LocalDate startTime = new LocalDate(start);
        LocalDate endTime = new LocalDate(end);

        System.out.println("startTime: " + startTime + ", endTIme: " + endTime);
        Period period = new Period(startTime, endTime);
        System.out.println(period.getMonths());*/

        // DateTime start = new DateTime().dayOfMonth().get();
        Date start = DateTime.parse("2020-08-01").toDate();
        System.out.println(getDaysOfMonth(start));


    }

    public static Integer getSingleLiveRoomValidDay(Map<String, Integer> map) {
        if (!map.containsKey("2")) {
            map.put("2", 2);
        } else {
            System.out.println("存在");
        }
        return 1;
    }

    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }



}
