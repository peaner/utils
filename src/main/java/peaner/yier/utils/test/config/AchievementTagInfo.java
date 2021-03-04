package peaner.yier.utils.test.config;

import lombok.Data;

import java.util.List;

/**
 * @author: Peaner
 * @time: 2020/9/1
 * @description: 夺宝成就tag信息
 */
@Data
public class AchievementTagInfo {

    /**
     * 夺宝成就tagId
     */
    private Integer tagId;

    /**
     * 夺宝成就tag名称
     */
    private String tabName;

    /**
     * 额外的参数名，用于埋点
     */
    private String extTypeName;

    /**
     * 夺宝成就列表（成就 + 完成条件 + 完成奖励）
     */
    private List<AchievementInfo> achievementInfos;



}
