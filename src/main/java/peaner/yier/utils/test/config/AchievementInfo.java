package peaner.yier.utils.test.config;

import lombok.Data;

/**
 * @author: Peaner
 * @time: 2020/9/1
 * @description: 成就类信息
 */
@Data
public class AchievementInfo {

    /**
     * 成就id
     */
    private Integer id;

    /**
     * 成就名称
     */
    private String name;

    /**
     * 成就获取条件描述
     */
    private String condition;

    /**
     * 成就奖励点数
     */
    private Integer awardDot;

}
