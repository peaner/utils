package peaner.yier.utils.test;

import peaner.yier.utils.excel.ExcelUtils;
import peaner.yier.utils.excel.core.Constants;

/**
 * @Author: lilongzhou
 * @Description:
 * @Date: Created in 15:19 2018/8/23
 */
public class Test {

    public static void main(String[] args) {

        /*ExcelDataVO ExcelDataVO = new ExcelDataVO();
        List<ExcelDataVO> datas = new ArrayList<ExcelDataVO>();

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

        //d:\\template.xls为Excel模板文件，d:\\test.xls为程序根据Excel模板文件生成的新文件
        //ExcelUtils.replaceModel(datas, "j:\\templates.xls", "j:\\test.xls");

        ExcelUtils.writeToExcel(datas, "j:\\templates.xlsx", "j:\\test.xlsx", "newVersion");*/

        //ExcelUtils.readFromExcel( "j:\\test.xlsx", Constants.NEW_VERSION);
        ExcelUtils.excelToHtml("j:\\test.xls", Constants.PRE_VERSION);
    }

}
