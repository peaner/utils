package peaner.yier.utils.excel.core;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: lilongzhou
 * @Description:
 * @Date: Created in 18:02 2018/8/15
 */
@Setter
@Getter
public class ExcelReplaceDataVO {

    // Excel单元格行
    private int row;

    // Excel单元格列
    private int column;

    // 替换的关键字
    private String key;

    // 替换的文本
    private String value;

}
