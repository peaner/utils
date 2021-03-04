package peaner.yier.utils.test.config;

import lombok.Data;

import java.util.List;

/**
 * @author: Peaner
 * @time: 2020/9/1
 * @description: 夺宝tab配置
 */
@Data
public class LotteryTabConfig {

    // 奖池类tag配置
    private List<AwardPoolTagInfo> awardPoolTagInfos;

    // 成就类tag配置
    private List<AchievementTagInfo> achievementTagInfos;

    // 成就兑换列表
    private List<ConvertInfo> convertInfos;

}
