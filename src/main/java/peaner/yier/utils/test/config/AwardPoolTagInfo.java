package peaner.yier.utils.test.config;

import lombok.Data;

import java.util.List;

/**
 * @author: Peaner
 * @time: 2020/9/2
 * @description: 奖池Tag信息
 */
@Data
public class AwardPoolTagInfo {

    /**
     * 夺宝奖池tagId
     */
    private Integer tagId;

    /**
     * 奖池类型
     */
    private Integer lotteryType;

    /**
     * 夺宝奖池tag名称
     */
    private String tabName;

    /**
     * 额外的参数名，用于埋点
     */
    private String extTypeName;

    // 夺宝1次消耗代币数
    private Integer consumeCoin1;

    // 夺宝5次消耗代币数
    private Integer consumeCoin5;

    // 夺宝10次消耗代币数
    private Integer consumeCoin10;

    // 自动夺宝消耗代币数
    private Integer autoCoin;

    /**
     * 夺宝奖池奖品列表(对应)
     */
    private List<AwardPoolInfo> awardPoolInfos;

}
