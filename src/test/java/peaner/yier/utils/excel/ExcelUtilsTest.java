package peaner.yier.utils.excel;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;
import peaner.yier.utils.excel.core.Constants;
import peaner.yier.utils.excel.core.ExcelDataVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lilongzhou
 * @Description:
 * @Date: Created in 下午12:06 2018/10/19
 */
public class ExcelUtilsTest {

    @Test
    public void writeToExcel() {

        List<List<ExcelDataVO>> lists = ExcelUtils.readFromExcel( "/Users/lilongzhou/Desktop/liveroom.xlsx", Constants.NEW_VERSION);

        for (List<ExcelDataVO> list : lists) {
            for (ExcelDataVO excelDataVO : list) {
                System.out.println(JSON.toJSONString(excelDataVO));
            }
        }


        /*List<ExcelDataVO> datas = new ArrayList<ExcelDataVO>();

        //找到第2行第2列的company，用"XXX有限公司"替换掉company
        ExcelDataVO vo1 = new ExcelDataVO();
        vo1.setRow(1);
        vo1.setColumn(1);
        vo1.setKey("company");
        vo1.setValue("XXX有限公司");

        //找到第2行第3列的content，用"aa替换的内容aa"替换掉content
        ExcelDataVO vo2 = new ExcelDataVO();
        vo2.setRow(1);
        vo2.setColumn(2);
        vo2.setKey("content");
        vo2.setValue("aa替换的内容aa");

        datas.add(vo1);
        datas.add(vo2);

        ExcelUtils.writeToExcel(datas, "j:\\templates.xlsx", "j:\\test.xlsx", Constants.NEW_VERSION);
        ExcelUtils.writeToExcel(datas, "j:\\templates.xlsx", "j:\\test.xlsx", Constants.PRE_VERSION);

        ExcelUtils.readFromExcel( "j:\\test.xlsx", Constants.NEW_VERSION);
        ExcelUtils.excelToHtml("j:\\test.xls", Constants.PRE_VERSION);*/

    }

    @Test
    public void readFromExcel() {
    }

    @Test
    public void excelToHtml() {
    }

    public static void main(String[] args) {
        Map<String, Object> body = new HashMap<>();
        body.put("count", "3000000001");
        int count = MapUtils.getInteger(body, "count", 0);
        System.out.println(count);
    }


}
