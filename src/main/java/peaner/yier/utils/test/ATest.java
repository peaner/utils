package peaner.yier.utils.test;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Peaner
 * @time: 2021/1/21
 * @description:
 */
public class ATest {

    public static void main(String[] args) {

        // String p = "{uid : 123456}";

//        Date date = new Date();
//        Date startTime = new DateTime(date).withMillisOfDay(0).toDate();
//        Date endTime = new DateTime(date).plusDays(1).withMillisOfDay(0).toDate();
//        System.out.println("startTime:" + startTime);
//        System.out.println("endTime:" + endTime);


        //Integer winnerCost = new BigDecimal(String.valueOf(100.45)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

        // System.out.println(winnerCost);
        ATest aTest = new ATest();
        List<AppInfo> list = aTest.buildInfo();
        // JSON.toJSONString(list);
        //list = list.stream().sorted(Comparator.comparing(AppInfo::getCreateTime).reversed()).sorted(Comparator.comparing(AppInfo::getFriendCount).reversed()).sorted(Comparator.comparing(AppInfo::getPlayGuess).reversed()).collect(Collectors.toList());
        list = list.stream().sorted(Comparator.comparing(AppInfo::getCreateTime)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));;
    }



    private List<AppInfo> buildInfo() {
        List<AppInfo> appInfoList = new ArrayList<>();
        AppInfo appInfo1 = new AppInfo("1", true, 1, 1L);
        AppInfo appInfo2 = new AppInfo("2", false, 2, 2L);
        AppInfo appInfo3 = new AppInfo("3", false, 3, 3L);
        AppInfo appInfo4 = new AppInfo("4", false, 4, 4L);
        AppInfo appInfo5 = new AppInfo("5", true, 5, 5L);
        AppInfo appInfo6 = new AppInfo("6", true, 6, 6L);
        appInfoList.add(appInfo1);
        appInfoList.add(appInfo2);
        appInfoList.add(appInfo3);
        appInfoList.add(appInfo4);
        appInfoList.add(appInfo5);
        appInfoList.add(appInfo6);
        return appInfoList;
    }

}

@Data
@AllArgsConstructor
class AppInfo {
    /**
     * 用户uid
     */
    private String uid;

    /**
     * 是否完过画猜 true玩过  false没有玩过
     */
    private Boolean playGuess;

    /**
     * 好友数量
     */
    private Integer friendCount;

    /**
     * 创建时间（注册时间）
     */
    private Long createTime;
}
