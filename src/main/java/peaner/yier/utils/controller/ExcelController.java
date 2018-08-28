package peaner.yier.utils.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import peaner.yier.utils.controller.formBean.ExcelDataFormBean;

/**
 * @Author: lilongzhou
 * @Description:
 * @Date: Created in 14:47 2018/8/23
 */
@Controller
@Slf4j
public class ExcelController {

    @GetMapping("/data/excel/export")
    public String exportExcelFormData(ExcelDataFormBean excelDataFormBean) {
        /**
         * 1. 将选择的数据库数据
         */
        return null;
    }

    @PostMapping("/data/excel/import")
    public String importExcelToData() {
        /**
         * 1. 上传文件  ---> 在这之前会下载好模板
         * 2. 读取文件到ExcelDataVO
         * 3. 将excelDataVO导入到数据库
         */
        return null;
    }



}
