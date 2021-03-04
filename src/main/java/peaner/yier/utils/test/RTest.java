package peaner.yier.utils.test;

import com.alibaba.fastjson.JSON;
import peaner.yier.utils.common.util.DateUtil;
import peaner.yier.utils.controller.bean.LiveRoomHostResp;
import peaner.yier.utils.test.config.AchievementInfo;
import peaner.yier.utils.test.config.AchievementTagInfo;
import peaner.yier.utils.test.config.AwardPoolInfo;
import peaner.yier.utils.test.config.AwardPoolTagInfo;
import peaner.yier.utils.test.config.ConvertInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RTest {

    public static void main(String[] args) {

        // 奖池类
        List<AwardPoolTagInfo> twAwardPoolTagInfos = new ArrayList<>();

        List<AwardPoolInfo> tw = twBuild();
        AwardPoolTagInfo twAwardPoolTagInfo = new AwardPoolTagInfo();
        twAwardPoolTagInfo.setTagId(1);
        twAwardPoolTagInfo.setLotteryType(1);
        twAwardPoolTagInfo.setTabName("鑽石奪寶");
        twAwardPoolTagInfo.setExtTypeName("");
        twAwardPoolTagInfo.setConsumeCoin1(20);
        twAwardPoolTagInfo.setConsumeCoin5(99);
        twAwardPoolTagInfo.setConsumeCoin10(190);
        twAwardPoolTagInfo.setAutoCoin(20);
        twAwardPoolTagInfo.setAwardPoolInfos(tw);
        twAwardPoolTagInfos.add(twAwardPoolTagInfo);

        List<AwardPoolInfo> twDou = twDouBuild();
        AwardPoolTagInfo douAwardPool = new AwardPoolTagInfo();
        douAwardPool.setTagId(2);
        douAwardPool.setLotteryType(2);
        douAwardPool.setTabName("逗豆奪寶");
        douAwardPool.setExtTypeName("");
        douAwardPool.setConsumeCoin1(1000);
        douAwardPool.setConsumeCoin5(5000);
        douAwardPool.setConsumeCoin10(9900);
        douAwardPool.setAutoCoin(1000);
        douAwardPool.setAwardPoolInfos(twDou);
        twAwardPoolTagInfos.add(douAwardPool);
        System.out.println(JSON.toJSONString(twAwardPoolTagInfos));


        System.out.println("------sp--------");
        // 奖池类
        List<AwardPoolTagInfo> spAwardPoolTagInfos = new ArrayList<>();

        List<AwardPoolInfo> sp = spBuild();
        AwardPoolTagInfo spAwardPoolTagInfo = new AwardPoolTagInfo();
        spAwardPoolTagInfo.setTagId(1);
        spAwardPoolTagInfo.setLotteryType(1);
        spAwardPoolTagInfo.setTabName("钻石夺宝");
        spAwardPoolTagInfo.setExtTypeName("");
        spAwardPoolTagInfo.setConsumeCoin1(20);
        spAwardPoolTagInfo.setConsumeCoin5(99);
        spAwardPoolTagInfo.setConsumeCoin10(190);
        spAwardPoolTagInfo.setAutoCoin(20);
        spAwardPoolTagInfo.setAwardPoolInfos(sp);
        spAwardPoolTagInfos.add(spAwardPoolTagInfo);

        List<AwardPoolInfo> spDou = spDouBuild();
        AwardPoolTagInfo spDouAwardPool = new AwardPoolTagInfo();
        spDouAwardPool.setTagId(2);
        spDouAwardPool.setLotteryType(2);
        spDouAwardPool.setTabName("逗豆夺宝");
        spDouAwardPool.setExtTypeName("");
        spDouAwardPool.setConsumeCoin1(1000);
        spDouAwardPool.setConsumeCoin5(5000);
        spDouAwardPool.setConsumeCoin10(9900);
        spDouAwardPool.setAutoCoin(1000);
        spDouAwardPool.setAwardPoolInfos(spDou);
        spAwardPoolTagInfos.add(spDouAwardPool);
        System.out.println(JSON.toJSONString(spAwardPoolTagInfos));





        System.out.println("--------------");
        // 成就类
        List<AchievementTagInfo> achievementTagInfos = twBuildAchievement();
        System.out.println(JSON.toJSONString(achievementTagInfos));

        System.out.println("--------------");

        // 成就兑换列表
        List<ConvertInfo> convertInfos = buildConvertList();
        System.out.println(JSON.toJSONString(convertInfos));



        List<AwardPoolInfo> list = tw.stream().filter(AwardPoolInfo::getSpecialGift).collect(Collectors.toList());
        System.out.println("size: " + list.size());



        System.out.println("-------bigWinner--one-----");
        System.out.println(JSON.toJSONString(twBigWinnerOneBuild()));

        System.out.println("-------bigWinner----two---");
        System.out.println(JSON.toJSONString(twBigWinnerTwoBuild()));

        System.out.println("-------bigWinner----three---");
        System.out.println(JSON.toJSONString(twBigWinnerThreeBuild()));


    }

    private static LiveRoomHostResp build() {
        LiveRoomHostResp liveRoomHostResp = new LiveRoomHostResp();

        liveRoomHostResp.setUid("10001");
        liveRoomHostResp.setUserName("10001");
        liveRoomHostResp.setRoomId("10001");

        liveRoomHostResp.setIdNumber("1001010101010");
        liveRoomHostResp.setBank("111");
        liveRoomHostResp.setBankAccount("1111");

        liveRoomHostResp.setSex("男");

        liveRoomHostResp.setTypeId(1);
        liveRoomHostResp.setTypeName("厅房间");

        liveRoomHostResp.setGradeId(1);
        liveRoomHostResp.setGradeName("银牌主播");

        liveRoomHostResp.setSubUnionName("隶属工会名称");

        liveRoomHostResp.setPrincipalId(1);
        liveRoomHostResp.setPrincipalName("admin");

        liveRoomHostResp.setFirstStartTime(DateUtil.getNowDateStr());
        liveRoomHostResp.setSignTime(DateUtil.getNowDateStr());
        return liveRoomHostResp;
    }


    /*---------------------------------------分割线------------------------------------------ */


    // 新马钻石奖池配置构建
    private static List<AwardPoolInfo> spBuild() {
        List<AwardPoolInfo> spList = new ArrayList<>();

        List<String> nameList = Stream.of("梦游仙境", "星动一下", "甜蜜糖果", "鼓掌", "跑车", "口红", "星动一下", "迷境灵狐头像框1日", "萤光棒", "鼓掌", "元气甜橙炫彩昵称1日", "会员体验卡7日").collect(Collectors.toList());
        List<String> rewardImgList = Stream.of("https://static.7b6ae.com/spliwu1.png", "https://static.7b6ae.com/spliwu10.png", "https://static.7b6ae.com/spliwu2.png", "https://qiniustatic.wodidashi.com/lottery/jp_gz.png", "https://static.7b6ae.com/spliwu3.png", "https://static.7b6ae.com/spliwu4.png", "https://static.7b6ae.com/spliwu10.png", "https://static.7b6ae.com/spliwu5.png","https://static.7b6ae.com/spliwu6.png", "https://qiniustatic.wodidashi.com/lottery/jp_gz.png", "https://static.7b6ae.com/spliwu9.png", "https://static.7b6ae.com/spliwu8.png").collect(Collectors.toList());
        List<String> rewardWindowImgList = Stream.of("https://static.7b6ae.com/mengyoutw11.png", "https://static.7b6ae.com/xingdongyixia111.png", "https://static.7b6ae.com/tianmitangguo111.png", "https://static.7b6ae.com/gozhang111.png", "https://static.7b6ae.com/paoche1.png", "https://static.7b6ae.com/kohong111.png", "https://static.7b6ae.com/xingdongyixia111.png", "https://static.7b6ae.com/toxiangkuang111.png","https://static.7b6ae.com/yingguangbang111.png", "https://static.7b6ae.com/gozhang111.png", "https://static.7b6ae.com/suancainicheng111.png", "https://static.7b6ae.com/vipkapian111.png").collect(Collectors.toList());
        List<Integer> propIdList = Stream.of(330, 354, 297, 221, 238, 230, 354, 1350, 236, 221, 5005, 5060).collect(Collectors.toList());
        List<Double> probabilityList = Stream.of(0.010, 12.000, 16.250, 16.500, 0.100, 6.000, 18.610, 3.000, 7.130, 13.400, 2.000, 5.000).collect(Collectors.toList());
        List<Long> awardCostList = Stream.of(19999L, 2L, 10L, 1L, 2983L, 99L, 2L, 100L, 3L, 1L, 30L, 35L).collect(Collectors.toList());
        List<Double> costList = Stream.of(1.9999, 0.24, 1.625, 0.165, 2.983, 5.94, 0.3722, 3.00, 0.2139, 0.134,  0.060, 1.75).collect(Collectors.toList());
        List<Boolean> specialGiftList = Stream.of(true, false, false, false, true, false, false, false, false, false, true, false).collect(Collectors.toList());
        List<Boolean> danMuList = Stream.of(true, false, false, false, true, false, false, true, false, false, true, false).collect(Collectors.toList());
        List<Boolean> allNoticeList = Stream.of(false, false, false, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());
        List<Boolean> bottomNoticeList = Stream.of(true, false, false, false, true, true, false, true, true, false, true, true).collect(Collectors.toList());

        for (int i = 0; i < 12; i++) {
            AwardPoolInfo awardPoolInfo = new AwardPoolInfo();
            awardPoolInfo.setId(i + 1);
            awardPoolInfo.setRewardId(i + 1);
            awardPoolInfo.setName(nameList.get(i));
            awardPoolInfo.setRewardImg(rewardImgList.get(i));
            awardPoolInfo.setRewardWindowImg(rewardWindowImgList.get(i));
            awardPoolInfo.setCount(1);
            awardPoolInfo.setPropType(1);
            awardPoolInfo.setPropId(propIdList.get(i));
            awardPoolInfo.setProbability(probabilityList.get(i));
            awardPoolInfo.setAwardCost(awardCostList.get(i));
            awardPoolInfo.setCost(costList.get(i));
            awardPoolInfo.setSpecialGift(specialGiftList.get(i));
            awardPoolInfo.setDanMu(danMuList.get(i));
            awardPoolInfo.setAllNotice(allNoticeList.get(i));
            awardPoolInfo.setBottomNotice(bottomNoticeList.get(i));
            spList.add(awardPoolInfo);
        }
        return spList;
    }

    // 台湾钻石奖池配置构建
    private static List<AwardPoolInfo> twBuild() {

        List<AwardPoolInfo> twList = new ArrayList<>();
        List<String> nameList = Stream.of("夢遊仙境", "星動一下", "甜蜜糖果", "鼓掌", "跑車", "口紅", "星動一下", "秘境靈狐頭像框1日", "螢光棒", "鼓掌", "童話輕舟座駕1日", "會員體驗卡7日").collect(Collectors.toList());
        List<String> rewardImgList = Stream.of("https://static.7b6ae.com/twliwu1.png", "https://static.7b6ae.com/twliwu10.png", "https://static.7b6ae.com/twliwu2.png", "https://qiniustatic.wodidashi.com/lottery/jp_gz.png", "https://static.7b6ae.com/twliwu3.png", "https://static.7b6ae.com/twliwu4.png", "https://static.7b6ae.com/twliwu10.png", "https://static.7b6ae.com/twliwu5.png", "https://static.7b6ae.com/twliwu6.png", "https://qiniustatic.wodidashi.com/lottery/jp_gz.png", "https://static.7b6ae.com/twliwu7.png", "https://static.7b6ae.com/twliwu8.png").collect(Collectors.toList());
        List<String> rewardWindowImgList = Stream.of("https://static.7b6ae.com/mengyoutw11.png", "https://static.7b6ae.com/xingdongyixia111.png", "https://static.7b6ae.com/tianmitangguo111.png", "https://static.7b6ae.com/gozhang111.png", "https://static.7b6ae.com/paoche1.png", "https://static.7b6ae.com/kohong111.png", "https://static.7b6ae.com/xingdongyixia111.png", "https://static.7b6ae.com/toxiangkuang111.png","https://static.7b6ae.com/yingguangbang111.png", "https://static.7b6ae.com/gozhang111.png", "https://static.7b6ae.com/zuojiaaa111.png", "https://static.7b6ae.com/vipkapian111.png").collect(Collectors.toList());
        List<Integer> propIdList = Stream.of(330, 354, 297, 221, 238, 230, 354, 1350, 236, 221, 6006, 5060).collect(Collectors.toList());
        List<Double> probabilityList = Stream.of(0.010, 12.000, 16.250, 16.500, 0.100, 6.000, 18.610, 3.000, 7.130, 13.400, 2.000, 5.000).collect(Collectors.toList());
        List<Long> awardCostList = Stream.of(19999L, 1L, 10L, 2L, 2983L, 99L, 1L, 100L, 20L, 2L, 500L, 35L).collect(Collectors.toList());
        List<Double> costList = Stream.of(1.9999, 0.12, 1.625, 0.33, 2.983, 5.94, 0.1861, 3.00, 1.426, 0.286,  10.00, 1.75).collect(Collectors.toList());

        List<Boolean> specialGiftList = Stream.of(true, false, false, false, true, false, false, false, false, false, true, false).collect(Collectors.toList());
        List<Boolean> danMuList = Stream.of(true, false, false, false, true, false, false, true, false, false, true, false).collect(Collectors.toList());
        List<Boolean> allNoticeList = Stream.of(false, false, false, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());
        List<Boolean> bottomNoticeList = Stream.of(true, false, false, false, true, true, false, true, true, false, true, true).collect(Collectors.toList());

        for (int i = 0; i < 12; i++) {
            AwardPoolInfo awardPoolInfo = new AwardPoolInfo();
            awardPoolInfo.setId(i + 1);
            awardPoolInfo.setRewardId(i + 1);
            awardPoolInfo.setName(nameList.get(i));
            awardPoolInfo.setRewardImg(rewardImgList.get(i));
            awardPoolInfo.setRewardWindowImg(rewardWindowImgList.get(i));
            awardPoolInfo.setCount(1);
            awardPoolInfo.setPropType(1);
            awardPoolInfo.setPropId(propIdList.get(i));
            awardPoolInfo.setProbability(probabilityList.get(i));
            awardPoolInfo.setAwardCost(awardCostList.get(i));
            awardPoolInfo.setCost(costList.get(i));
            awardPoolInfo.setSpecialGift(specialGiftList.get(i));
            awardPoolInfo.setDanMu(danMuList.get(i));
            awardPoolInfo.setAllNotice(allNoticeList.get(i));
            awardPoolInfo.setBottomNotice(bottomNoticeList.get(i));
            twList.add(awardPoolInfo);
        }

        return twList;
    }

    /**
     * 逗豆奖励构建
     * @return 逗豆奖励构建
     */
    private static List<AwardPoolInfo> twDouBuild() {
        List<AwardPoolInfo> twDouList = new ArrayList<>();

        List<String> nameList = Stream.of("環遊世界", "美妝套裝", "遊戲機", "桃花運", "加油鴨", "情書", "星光閃閃", "小星星", "星光閃閃", "星光閃閃", "小星星", "小星星").collect(Collectors.toList());

        List<String> rewardImgList = Stream.of("https://static.7b6ae.com/duobao_huanyou.svga", "https://static.7b6ae.com/duobao_meizhuang.png", "https://static.7b6ae.com/dd/yxjdd.png", "https://static.7b6ae.com/dd/thydd.png", "https://static.7b6ae.com/duobao_jiayouya.png", "https://static.7b6ae.com/duobao_qingshu.png", "https://static.7b6ae.com/dd_xgss.png", "https://static.7b6ae.com/duobao_star.png", "https://static.7b6ae.com/dd_xgss.png", "https://static.7b6ae.com/dd_xgss.png", "https://static.7b6ae.com/duobao_star.png", "https://static.7b6ae.com/duobao_star.png").collect(Collectors.toList());
        List<String> rewardWindowImgList = Stream.of("https://qiniustatic.wodidashi.com/lottery/zj_hysj.png", "https://static.7b6ae.com/duobao_bottom_meizhuang.png", "https://static.7b6ae.com/lwq/yxj.png", "https://static.7b6ae.com/lwq/thy.png", "https://static.7b6ae.com/duobao_bottom_jiayouya.png", "https://qiniustatic.wodidashi.com/lottery/zj_qs.png", "https://static.7b6ae.com/lwq/xgss.png", "https://static.7b6ae.com/duobao_bottom_star.png", "https://static.7b6ae.com/lwq/xgss.png", "https://static.7b6ae.com/lwq/xgss.png", "https://static.7b6ae.com/duobao_bottom_star.png", "https://static.7b6ae.com/duobao_bottom_star.png").collect(Collectors.toList());
        List<Integer> propIdList = Stream.of(234, 282, 284, 214, 332, 215, 339, 331, 339, 339, 331, 331).collect(Collectors.toList());
        List<Double> probabilityList = Stream.of(0.010, 0.020, 0.220, 4.220, 4.430, 8.840, 12.850, 14.570, 12.850, 12.850, 14.570, 14.570).collect(Collectors.toList());
        List<Long> awardCostList = Stream.of(9999L, 1999L, 26666L, 1200L, 2000L, 1000L, 200L, 500L, 200L, 200L, 500L, 500L).collect(Collectors.toList());
        List<Double> costList = Stream.of(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00).collect(Collectors.toList());
        List<Boolean> specialGiftList = Stream.of(true, true, false, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());
        List<Boolean> danMuList = Stream.of(false, false, false, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());
        List<Boolean> allNoticeList = Stream.of(false, false, false, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());
        List<Boolean> bottomNoticeList = Stream.of(true, true, true, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());

        for (int i = 0; i < 12; i++) {
            AwardPoolInfo awardPoolInfo = new AwardPoolInfo();
            awardPoolInfo.setId(i + 1);
            awardPoolInfo.setRewardId(i + 1);
            awardPoolInfo.setName(nameList.get(i));
            awardPoolInfo.setRewardImg(rewardImgList.get(i));
            awardPoolInfo.setRewardWindowImg(rewardWindowImgList.get(i));
            awardPoolInfo.setCount(1);
            awardPoolInfo.setPropType(2);
            awardPoolInfo.setPropId(propIdList.get(i));
            awardPoolInfo.setProbability(probabilityList.get(i));
            awardPoolInfo.setAwardCost(awardCostList.get(i));
            awardPoolInfo.setCost(costList.get(i));
            awardPoolInfo.setSpecialGift(specialGiftList.get(i));
            awardPoolInfo.setDanMu(danMuList.get(i));
            awardPoolInfo.setAllNotice(allNoticeList.get(i));
            awardPoolInfo.setBottomNotice(bottomNoticeList.get(i));
            twDouList.add(awardPoolInfo);
        }

        return twDouList;
    }

    /**
     * 逗豆奖励构建
     * @return 逗豆奖励构建
     */
    private static List<AwardPoolInfo> spDouBuild() {
        List<AwardPoolInfo> twDouList = new ArrayList<>();

        List<String> nameList = Stream.of("环游世界", "幸运金鲤", "么么哒", "小玩", "金麦克", "情书", "鼓掌", "鼓掌", "鼓掌", "桃花运", "桃花运", "桃花运").collect(Collectors.toList());

        List<String> rewardImgList = Stream.of("https://qiniustatic.wodidashi.com/lottery/jp_hysy.svga", "https://qiniustatic.wodidashi.com/lottery/jp_xyjl.svga", "https://qiniustatic.wodidashi.com/lottery/jp_mmd.png", "https://qiniustatic.wodidashi.com/lottery/jp_xw.png", "https://qiniustatic.wodidashi.com/lottery/jp_jmk.png", "https://qiniustatic.wodidashi.com/lottery/jp_qs.png", "https://qiniustatic.wodidashi.com/lottery/jp_gz.png", "https://qiniustatic.wodidashi.com/lottery/jp_gz.png","https://qiniustatic.wodidashi.com/lottery/jp_gz.png", "https://qiniustatic.wodidashi.com/lottery/jp_thy.png", "https://qiniustatic.wodidashi.com/lottery/jp_thy.png", "https://qiniustatic.wodidashi.com/lottery/jp_thy.png").collect(Collectors.toList());
        List<String> rewardWindowImgList = Stream.of("https://qiniustatic.wodidashi.com/lottery/zj_hysj.png", "https://qiniustatic.wodidashi.com/lottery/zj_xyjl.png", "https://qiniustatic.wodidashi.com/lottery/zj_mmd.png", "https://qiniustatic.wodidashi.com/lottery/zj_xw.png", "https://qiniustatic.wodidashi.com/lottery/zj_jmk.png", "https://qiniustatic.wodidashi.com/lottery/zj_qs.png", "https://qiniustatic.wodidashi.com/lottery/zj_gz.png", "https://qiniustatic.wodidashi.com/lottery/zj_gz.png","https://qiniustatic.wodidashi.com/lottery/zj_gz.png", "https://qiniustatic.wodidashi.com/lottery/zj_thy.png", "https://qiniustatic.wodidashi.com/lottery/zj_thy.png", "https://qiniustatic.wodidashi.com/lottery/zj_thy.png").collect(Collectors.toList());
        List<Integer> propIdList = Stream.of(234, 241, 231, 227, 235, 215, 221, 221, 221, 214, 214, 214).collect(Collectors.toList());

        List<Double> probabilityList = Stream.of(0.010, 0.010, 0.110, 2.160, 4.530, 9.040, 13.150, 13.150, 13.150, 14.900, 14.900, 14.900).collect(Collectors.toList());

        List<Long> awardCostList = Stream.of(9999L, 1888L, 199L, 10L, 2000L, 1000L, 1L, 1L, 1L, 200L, 200L, 200L).collect(Collectors.toList());
        List<Double> costList = Stream.of(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00).collect(Collectors.toList());
        List<Boolean> specialGiftList = Stream.of(true, true, false, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());
        List<Boolean> danMuList = Stream.of(false, false, false, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());
        List<Boolean> allNoticeList = Stream.of(false, false, false, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());
        List<Boolean> bottomNoticeList = Stream.of(true, true, true, false, false, false, false, false, false, false, false, false).collect(Collectors.toList());

        for (int i = 0; i < 12; i++) {
            AwardPoolInfo awardPoolInfo = new AwardPoolInfo();
            awardPoolInfo.setId(i + 1);
            awardPoolInfo.setRewardId(i + 1);
            awardPoolInfo.setName(nameList.get(i));
            awardPoolInfo.setRewardImg(rewardImgList.get(i));
            awardPoolInfo.setRewardWindowImg(rewardWindowImgList.get(i));
            awardPoolInfo.setCount(1);
            awardPoolInfo.setPropType(2);
            awardPoolInfo.setPropId(propIdList.get(i));
            awardPoolInfo.setProbability(probabilityList.get(i));
            awardPoolInfo.setAwardCost(awardCostList.get(i));
            awardPoolInfo.setCost(costList.get(i));
            awardPoolInfo.setSpecialGift(specialGiftList.get(i));
            awardPoolInfo.setDanMu(danMuList.get(i));
            awardPoolInfo.setAllNotice(allNoticeList.get(i));
            awardPoolInfo.setBottomNotice(bottomNoticeList.get(i));
            twDouList.add(awardPoolInfo);
        }

        return twDouList;
    }

    // 成就表配置
    private static List<AchievementTagInfo> twBuildAchievement() {
        List<AchievementTagInfo> achievementTagInfoList = new ArrayList<>();

        AchievementTagInfo achievementTagInfo1 = new AchievementTagInfo();
        achievementTagInfo1.setTagId(1);
        achievementTagInfo1.setTabName("一般成就");
        achievementTagInfo1.setExtTypeName("");
        List<AchievementInfo> commonInfos = new ArrayList<>();
        AchievementInfo commonInfo1 = new AchievementInfo();
        commonInfo1.setId(1);
        commonInfo1.setName("奪寶初心者");
        commonInfo1.setCondition("奪寶1次");
        commonInfo1.setAwardDot(5);
        AchievementInfo commonInfo2 = new AchievementInfo();
        commonInfo2.setId(2);
        commonInfo2.setName("奪寶入門");
        commonInfo2.setCondition("累計奪寶100次");
        commonInfo2.setAwardDot(10);
        AchievementInfo commonInfo3 = new AchievementInfo();
        commonInfo3.setId(3);
        commonInfo3.setName("奪寶贏家");
        commonInfo3.setCondition("累計鑽石奪寶100次");
        commonInfo3.setAwardDot(30);
        AchievementInfo commonInfo4 = new AchievementInfo();
        commonInfo4.setId(4);
        commonInfo4.setName("奪寶大神");
        commonInfo4.setCondition("累計奪寶1000次");
        commonInfo4.setAwardDot(50);
        commonInfos.add(commonInfo1);
        commonInfos.add(commonInfo2);
        commonInfos.add(commonInfo3);
        commonInfos.add(commonInfo4);
        achievementTagInfo1.setAchievementInfos(commonInfos);


        AchievementTagInfo achievementTagInfo2 = new AchievementTagInfo();
        achievementTagInfo2.setTagId(2);
        achievementTagInfo2.setTabName("一周成就");
        achievementTagInfo2.setExtTypeName("");
        List<AchievementInfo> weekInfos = new ArrayList<>();
        AchievementInfo weekInfo1 = new AchievementInfo();
        weekInfo1.setId(1);
        weekInfo1.setName("金銀珠寶");
        weekInfo1.setCondition("本週奪寶獲得5000逗豆或金幣價值禮物");
        weekInfo1.setAwardDot(20);
        AchievementInfo weekInfo2 = new AchievementInfo();
        weekInfo2.setId(2);
        weekInfo2.setName("我就是週星");
        weekInfo2.setCondition("本週奪寶獲得1000鑽價值禮物");
        weekInfo2.setAwardDot(50);
        AchievementInfo weekInfo3 = new AchievementInfo();
        weekInfo3.setId(3);
        weekInfo3.setName("運氣爆棚");
        weekInfo3.setCondition("本週奪寶獲得夢遊仙境");
        weekInfo3.setAwardDot(100);
        AchievementInfo weekInfo4 = new AchievementInfo();
        weekInfo4.setId(4);
        weekInfo4.setName("奪上天了");
        weekInfo4.setCondition("本週奪寶獲得頭像框");
        weekInfo4.setAwardDot(100);
        AchievementInfo weekInfo5 = new AchievementInfo();
        weekInfo5.setId(5);
        weekInfo5.setName("跑車達人");
        weekInfo5.setCondition("本週奪寶獲得跑車");
        weekInfo5.setAwardDot(100);
        weekInfos.add(weekInfo1);
        weekInfos.add(weekInfo2);
        weekInfos.add(weekInfo3);
        weekInfos.add(weekInfo4);
        weekInfos.add(weekInfo5);
        achievementTagInfo2.setAchievementInfos(weekInfos);


        AchievementTagInfo achievementTagInfo3 = new AchievementTagInfo();
        achievementTagInfo3.setTagId(3);
        achievementTagInfo3.setTabName("特殊成就");
        achievementTagInfo3.setExtTypeName("");
        List<AchievementInfo> specialInfos = new ArrayList<>();
        AchievementInfo specialInfo1 = new AchievementInfo();
        specialInfo1.setId(1);
        specialInfo1.setName("鑽石滿貫王");
        specialInfo1.setCondition("奪得以下所有禮物:夢遊仙境、口紅、熒光棒、甜蜜糖果、鼓掌、星動一下");
        specialInfo1.setAwardDot(500);

        AchievementInfo specialInfo2 = new AchievementInfo();
        specialInfo2.setId(2);
        specialInfo2.setName("這就是人生");
        specialInfo2.setCondition("10次十連奪都沒有奪中大獎");
        specialInfo2.setAwardDot(50);

        AchievementInfo specialInfo3 = new AchievementInfo();
        specialInfo3.setId(3);
        specialInfo3.setName("像極了愛情");
        specialInfo3.setCondition("50次奪寶沒有奪中大獎（連續或者累計）");
        specialInfo3.setAwardDot(100);

        AchievementInfo specialInfo4 = new AchievementInfo();
        specialInfo4.setId(4);
        specialInfo4.setName("下一站幸福");
        specialInfo4.setCondition("鑽石奪寶十連奪同時獲得會員體驗卡、口紅");
        specialInfo4.setAwardDot(80);

        AchievementInfo specialInfo5 = new AchievementInfo();
        specialInfo5.setId(5);
        specialInfo5.setName("什麼狗屎運");
        specialInfo5.setCondition("鑽石十連奪同時獲得頭像框、口紅");
        specialInfo5.setAwardDot(80);

        AchievementInfo specialInfo6 = new AchievementInfo();
        specialInfo6.setId(6);
        specialInfo6.setName("都給你玩");
        specialInfo6.setCondition("一次性(不管是奪一次、五連奪、十連奪)奪中大獎");
        specialInfo6.setAwardDot(100);
        specialInfos.add(specialInfo1);
        specialInfos.add(specialInfo2);
        specialInfos.add(specialInfo3);
        specialInfos.add(specialInfo4);
        specialInfos.add(specialInfo5);
        specialInfos.add(specialInfo6);
        achievementTagInfo3.setAchievementInfos(specialInfos);


        achievementTagInfoList.add(achievementTagInfo1);
        achievementTagInfoList.add(achievementTagInfo2);
        achievementTagInfoList.add(achievementTagInfo3);

        return achievementTagInfoList;
    }

    private static List<ConvertInfo> buildConvertList() {
        List<ConvertInfo> convertInfoList = new ArrayList<>();
        ConvertInfo convertInfo1 = new ConvertInfo();
        convertInfo1.setId(1);
        convertInfo1.setAwardDot(50);
        convertInfo1.setConvertDesc("聊天動效*1、3級稱號7日");

        ConvertInfo convertInfo2 = new ConvertInfo();
        convertInfo2.setId(2);
        convertInfo2.setAwardDot(100);
        convertInfo2.setConvertDesc("喊話卡*2、4級稱號7日");

        ConvertInfo convertInfo3 = new ConvertInfo();
        convertInfo3.setId(3);
        convertInfo3.setAwardDot(500);
        convertInfo3.setConvertDesc("B級頭像框*1 7日");

        ConvertInfo convertInfo4 = new ConvertInfo();
        convertInfo4.setId(4);
        convertInfo4.setAwardDot(1000);
        convertInfo4.setConvertDesc("C級座駕*1 7日");

        convertInfoList.add(convertInfo1);
        convertInfoList.add(convertInfo2);
        convertInfoList.add(convertInfo3);
        convertInfoList.add(convertInfo4);

        return convertInfoList;
    }


    // ------------------------------------------------------------------------------------


    private static List<AwardPoolInfo> twBigWinnerOneBuild() {
        List<AwardPoolInfo> twDouList = new ArrayList<>();

        List<String> nameList = Stream.of("星動一下", "鼓掌", "櫻花", "鼓掌", "平安喜樂", "櫻花", "尖叫雞", "櫻花", "櫻花", "平安喜樂", "千紙鶴", "尖叫雞").collect(Collectors.toList());

        List<String> rewardImgList = Stream.of("https://static.7b6ae.com/dayingjiaxingdongyixia.png", "https://static.7b6ae.com/dayingjiagozhang.png", "https://static.7b6ae.com/dayingjiayinghua.png", "https://static.7b6ae.com/dayingjiagozhang.png", "https://static.7b6ae.com/duobao_jiayouya.png", "https://static.7b6ae.com/dayingjiapinganxile.png", "https://static.7b6ae.com/dayingjiayinghua.png", "https://static.7b6ae.com/dayingjiayinghua.png", "https://static.7b6ae.com/dayingjiayinghua.png", "https://static.7b6ae.com/dayingjiapinganxile.png", "https://static.7b6ae.com/dayingjiaqianzhihe.png", "https://static.7b6ae.com/dayingjiajianjiaoji.png").collect(Collectors.toList());
        List<String> rewardWindowImgList = Stream.of("https://static.7b6ae.com/dayingjiaxingdongyixia.png", "https://static.7b6ae.com/dayingjiagozhang.png", "https://static.7b6ae.com/dayingjiayinghua.png", "https://static.7b6ae.com/dayingjiagozhang.png", "https://static.7b6ae.com/duobao_jiayouya.png", "https://static.7b6ae.com/dayingjiapinganxile.png", "https://static.7b6ae.com/dayingjiayinghua.png", "https://static.7b6ae.com/dayingjiayinghua.png", "https://static.7b6ae.com/dayingjiayinghua.png", "https://static.7b6ae.com/dayingjiapinganxile.png", "https://static.7b6ae.com/dayingjiaqianzhihe.png", "https://static.7b6ae.com/dayingjiajianjiaoji.png").collect(Collectors.toList());

        List<Integer> propIdList = Stream.of(354, 221, 257, 221, 277, 257, 279, 257, 257, 277, 297, 279).collect(Collectors.toList());
        List<Double> probabilityList = Stream.of(2.00, 4.00, 7.00, 10.00, 12.00, 15.00, 20.00, 10.00, 8.00, 5.00, 4.00, 3.00).collect(Collectors.toList());
        List<Long> awardCostList = Stream.of(1L, 2L, 3L, 6L, 8L, 9L, 10L, 12L, 15L, 16L, 18L, 20L).collect(Collectors.toList());

        List<Double> costList = Stream.of(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00).collect(Collectors.toList());

        List<Integer> countList= Stream.of(1, 1, 1, 3, 1, 3, 1, 4, 5, 2, 3, 2).collect(Collectors.toList());

        for (int i = 0; i < 12; i++) {
            AwardPoolInfo awardPoolInfo = new AwardPoolInfo();
            awardPoolInfo.setId(i + 1);
            awardPoolInfo.setRewardId(i + 1);
            awardPoolInfo.setName(nameList.get(i));
            awardPoolInfo.setRewardImg(rewardImgList.get(i));
            awardPoolInfo.setRewardWindowImg(rewardWindowImgList.get(i));
            awardPoolInfo.setCount(countList.get(i));
            awardPoolInfo.setPropType(1);
            awardPoolInfo.setPropId(propIdList.get(i));
            awardPoolInfo.setProbability(probabilityList.get(i));
            awardPoolInfo.setAwardCost(awardCostList.get(i));
            awardPoolInfo.setCost(costList.get(i));
            awardPoolInfo.setSpecialGift(false);
            awardPoolInfo.setDanMu(false);
            awardPoolInfo.setAllNotice(false);
            awardPoolInfo.setBottomNotice(false);
            twDouList.add(awardPoolInfo);
        }

        return twDouList;
    }

    private static List<AwardPoolInfo> twBigWinnerTwoBuild() {
        List<AwardPoolInfo> twDouList = new ArrayList<>();

        List<String> nameList = Stream.of("尖叫雞", "千紙鶴", "掌上明豬", "千紙鶴", "鯨魚", "平安喜樂", "掌上明豬", "初始守護", "平安喜樂", "鯨魚", "夏日刨冰", "初始守護").collect(Collectors.toList());

        List<String> rewardImgList = Stream.of("https://static.7b6ae.com/dayingjiajianjiaoji.png", "https://static.7b6ae.com/dayingjiaqianzhihe.png", "https://static.7b6ae.com/dayingjiazhangshangmingzhu.png", "https://static.7b6ae.com/dayingjiaqianzhihe.png", "https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiapinganxile.png", "https://static.7b6ae.com/dayingjiazhangshangmingzhu.png", "https://static.7b6ae.com/dayingjiachushishohu.png", "https://static.7b6ae.com/dayingjiapinganxile.png", "https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiabaobing.png", "https://static.7b6ae.com/dayingjiachushishohu.png").collect(Collectors.toList());
        List<String> rewardWindowImgList = Stream.of("https://static.7b6ae.com/dayingjiajianjiaoji.png", "https://static.7b6ae.com/dayingjiaqianzhihe.png", "https://static.7b6ae.com/dayingjiazhangshangmingzhu.png", "https://static.7b6ae.com/dayingjiaqianzhihe.png", "https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiapinganxile.png", "https://static.7b6ae.com/dayingjiazhangshangmingzhu.png", "https://static.7b6ae.com/dayingjiachushishohu.png", "https://static.7b6ae.com/dayingjiapinganxile.png", "https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiabaobing.png", "https://static.7b6ae.com/dayingjiachushishohu.png").collect(Collectors.toList());

        List<Integer> propIdList = Stream.of(279, 297, 347, 297, 349, 277, 347, 346, 277, 349, 239, 346).collect(Collectors.toList());
        List<Double> probabilityList = Stream.of(2.00, 2.00, 4.00, 6.00, 8.00, 12.00, 16.00, 20.00, 12.00, 10.00, 5.00, 3.00).collect(Collectors.toList());
        List<Long> awardCostList = Stream.of(10L, 12L, 15L, 18L, 20L, 24L, 30L, 33L, 36L, 40L, 45L, 66L).collect(Collectors.toList());

        List<Double> costList = Stream.of(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00).collect(Collectors.toList());
        List<Integer> countList= Stream.of(1, 2, 1, 3, 1, 3, 2, 1, 4, 2, 1, 2).collect(Collectors.toList());

        for (int i = 0; i < 12; i++) {
            AwardPoolInfo awardPoolInfo = new AwardPoolInfo();
            awardPoolInfo.setId(i + 1);
            awardPoolInfo.setRewardId(i + 1);
            awardPoolInfo.setName(nameList.get(i));
            awardPoolInfo.setRewardImg(rewardImgList.get(i));
            awardPoolInfo.setRewardWindowImg(rewardWindowImgList.get(i));
            awardPoolInfo.setCount(countList.get(i));
            awardPoolInfo.setPropType(1);
            awardPoolInfo.setPropId(propIdList.get(i));
            awardPoolInfo.setProbability(probabilityList.get(i));
            awardPoolInfo.setAwardCost(awardCostList.get(i));
            awardPoolInfo.setCost(costList.get(i));
            awardPoolInfo.setSpecialGift(false);
            awardPoolInfo.setDanMu(false);
            awardPoolInfo.setAllNotice(false);
            awardPoolInfo.setBottomNotice(false);
            twDouList.add(awardPoolInfo);
        }

        return twDouList;
    }

    private static List<AwardPoolInfo> twBigWinnerThreeBuild() {
        List<AwardPoolInfo> twDouList = new ArrayList<>();

        List<String> nameList = Stream.of("鯨魚", "神燈", "鯨魚", "一鹿有你", "燒烤串", "鯨魚", "神燈", "水晶鞋", "一鹿有你", "燒烤串", "海灘帳篷", "水晶鞋").collect(Collectors.toList());

        List<String> rewardImgList = Stream.of("https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiashendeng.png", "https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiayiluyoini.png", "https://static.7b6ae.com/dayingjiakaorou.png", "https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiashendeng.png", "https://static.7b6ae.com/dayingjiashuijingxie.png", "https://static.7b6ae.com/dayingjiayiluyoini.png", "https://static.7b6ae.com/dayingjiakaorou.png", "https://static.7b6ae.com/dayingjiahaitanzhangpeng.png", "https://static.7b6ae.com/dayingjiashuijingxie.png").collect(Collectors.toList());
        List<String> rewardWindowImgList = Stream.of("https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiashendeng.png", "https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiayiluyoini.png", "https://static.7b6ae.com/dayingjiakaorou.png", "https://static.7b6ae.com/dayingjiajingyu.png", "https://static.7b6ae.com/dayingjiashendeng.png", "https://static.7b6ae.com/dayingjiashuijingxie.png", "https://static.7b6ae.com/dayingjiayiluyoini.png", "https://static.7b6ae.com/dayingjiakaorou.png", "https://static.7b6ae.com/dayingjiahaitanzhangpeng.png", "https://static.7b6ae.com/dayingjiashuijingxie.png").collect(Collectors.toList());

        List<Integer> propIdList = Stream.of(349, 240, 349, 300, 328, 349, 240, 353, 300, 328, 271, 353).collect(Collectors.toList());
        List<Double> probabilityList = Stream.of(1.00, 2.00, 3.00, 5.00, 6.00, 10.00, 18.00, 20.00, 12.00, 12.00, 8.00, 3.00).collect(Collectors.toList());
        List<Long> awardCostList = Stream.of(20L, 30L, 40L, 52L, 60L, 80L, 90L, 99L, 104L, 120L, 180L, 198L).collect(Collectors.toList());
        List<Double> costList = Stream.of(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00).collect(Collectors.toList());
        List<Integer> countList= Stream.of(1, 1, 2, 1, 1, 4, 3, 1, 2, 2, 1, 2).collect(Collectors.toList());

        for (int i = 0; i < 12; i++) {
            AwardPoolInfo awardPoolInfo = new AwardPoolInfo();
            awardPoolInfo.setId(i + 1);
            awardPoolInfo.setRewardId(i + 1);
            awardPoolInfo.setName(nameList.get(i));
            awardPoolInfo.setRewardImg(rewardImgList.get(i));
            awardPoolInfo.setRewardWindowImg(rewardWindowImgList.get(i));
            awardPoolInfo.setCount(countList.get(i));
            awardPoolInfo.setPropType(1);
            awardPoolInfo.setPropId(propIdList.get(i));
            awardPoolInfo.setProbability(probabilityList.get(i));
            awardPoolInfo.setAwardCost(awardCostList.get(i));
            awardPoolInfo.setCost(costList.get(i));
            awardPoolInfo.setSpecialGift(false);
            awardPoolInfo.setDanMu(false);
            awardPoolInfo.setAllNotice(false);
            awardPoolInfo.setBottomNotice(false);
            twDouList.add(awardPoolInfo);
        }

        return twDouList;
    }







}
