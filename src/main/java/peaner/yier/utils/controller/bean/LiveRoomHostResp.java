package peaner.yier.utils.controller.bean;

import lombok.Data;

@Data
public class LiveRoomHostResp {

    /**
     * 主播uid
     */
    private String uid;

    /**
     * 主播昵称
     */
    private String nickName;

    /**
     * 主播真实姓名
     */
    private String userName;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 银行账号
     */
    private String bank;

    /**
     * 开户银行
     */
    private String bankAccount;

    /**
     * 主播性别
     */
    private String sex;

    /**
     * 主播房间号
     */
    private String roomId;

    private Integer typeId;

    private String typeName;

    /**
     * 主播评级id
     */
    private Integer gradeId;

    /**
     * 主播评级名称
     */
    private String gradeName;

    /**
     * 主播隶属工会Id
     */
    private Integer subUnionId;

    /**
     * 主播隶属工会名称
     */
    private String subUnionName;

    /**
     * 首播时间
     */
    private String firstStartTime;

    /**
     * 主播签约时间
     */
    private String signTime;

    /**
     * 负责人id
     */
    private Integer principalId;

    /**
     * 负责人名称
     */
    private String principalName;

}
