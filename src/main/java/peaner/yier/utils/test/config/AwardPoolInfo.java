package peaner.yier.utils.test.config;

import lombok.Data;

/**
 * @author: Peaner
 * @time: 2020/9/3
 * @description: 奖池礼物信息
 */
@Data
public class AwardPoolInfo {

    /**
     * 位置ID
     **/
    private Integer id;

    /** 奖励ID */
    private Integer rewardId;

    /**
     * 奖励名称
     **/
    private String name;

    /**
     * 奖励图片 奖品列表展示图
     **/
    private String rewardImg;

    /**
     * 奖励窗口图片 夺取奖品弹窗图
     */
    private String rewardWindowImg;

    /**
     * 奖励数量
     */
    private Integer count;

    /**
     * 奖励道具id
     */
    private Integer propId;

    /**
     * 奖励类型 钻石 逗豆 金币
     */
    private Integer propType;

    /**
     * 奖励抽奖概率
     */
    private Double probability;

    /**
     * 折算钻石|逗豆|金币价值
     */
    private Long awardCost;

    /**
     * 中奖成本
     */
    private Double cost;

    /**
     * 一次获取数量
     */
    private Integer sendNumber;

    /**
     * 备份奖励
     */
    private Integer backUpRewardId;

    /**
     * 是否是大奖
     */
    private Boolean specialGift;

    /**
     * 是否发送中奖弹幕
     */
    private Boolean danMu;

    /**
     * 是否全服公告
     */
    private Boolean allNotice;

    /**
     * 是否底部公告
     */
    private Boolean bottomNotice;


}
