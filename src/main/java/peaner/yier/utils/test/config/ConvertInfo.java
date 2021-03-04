package peaner.yier.utils.test.config;

import lombok.Data;

/**
 * @author: Peaner
 * @time: 2020/9/4
 * @description: 成就兑换列表
 */
@Data
public class ConvertInfo {

    /**
     * 兑换id
     */
    private Integer id;

    /**
     * 兑换需要的成就点数
     */
    private Integer awardDot;

    /**
     * 兑换物品描述
     */
    private String convertDesc;

}
