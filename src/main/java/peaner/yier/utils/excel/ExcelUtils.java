package peaner.yier.utils.excel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import peaner.yier.utils.excel.core.Constants;
import peaner.yier.utils.excel.core.ExcelDataVO;
import peaner.yier.utils.excel.core.ExcelException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lilongzhou
 * @Description:
 * @Date: Created in 17:59 2018/8/15
 */
public class ExcelUtils {

    /**
     * 将内容写入excel(区分excel版本)
     * @param dataVOS 待写数据
     * @param sourceFilePath Excel模板文件路径
     * @param targetFilePath Excel生成文件路径
     * @param type excel版本类型  2007年以前的  preVersion  2007年以后的 newVersion
     * @return
     */
    public static boolean writeToExcel(List<ExcelDataVO> dataVOS,
                                       String sourceFilePath, String targetFilePath, String type) {
        boolean flag = true;

        if (Constants.PRE_VERSION.equalsIgnoreCase(type)) {
            flag = writeToExcelOld(sourceFilePath, dataVOS, targetFilePath);
        }

        if (Constants.NEW_VERSION.equalsIgnoreCase(type)) {
            flag = writeToExcelNew(sourceFilePath, dataVOS, targetFilePath);
        }

        return flag;
    }

    /**
     * 从excel读取数据(区分excel版本)
     * @param sourceFilePath Excel文件路径
     * @param type excel版本类型  2007年以前的  preVersion  2007年以后的 newVersion
     * @return
     */
    public static List<List<ExcelDataVO>> readFromExcel(String sourceFilePath, String type) {
        List<List<ExcelDataVO>> excelDataList = new ArrayList<>();
        if (Constants.PRE_VERSION.equalsIgnoreCase(type)) {
            excelDataList = readFromExcelOld(sourceFilePath);
        }
        if (Constants.NEW_VERSION.equalsIgnoreCase(type)) {
            excelDataList = readFromExcelNew(sourceFilePath);
        }
        return excelDataList;
    }

    /**
     * 将excel表转换成html(区分excel版本)
     * @param sourceFilePath Excel文件路径
     * @param type excel版本类型  2007年以前的  preVersion  2007年以后的 newVersion
     * @return
     */
    public static String excelToHtml(String sourceFilePath, String type) {
        String path = null;
        if (Constants.PRE_VERSION.equalsIgnoreCase(type)) {
            path = excelToHtmlOld(sourceFilePath);
        }
        if (Constants.NEW_VERSION.equalsIgnoreCase(type)) {
            path = excelToHtmlNew(sourceFilePath);
        }
        return path;
    }

    /**
     * 写入老版本的excel
     * @param sourceFilePath Excel模板文件路径
     * @param dataVOS 待写数据
     * @param targetFilePath Excel生成文件路径
     * @return
     */
    private static boolean writeToExcelOld (String sourceFilePath, List<ExcelDataVO> dataVOS, String targetFilePath) {

        boolean flag = true;
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
                    sourceFilePath));
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fs);
            HSSFSheet sheet = hssfWorkbook.getSheetAt(0);

            for (ExcelDataVO data : dataVOS) {
                // 获取单元格内容
                HSSFRow row = sheet.getRow(data.getRow());
                HSSFCell cell = row.getCell(data.getColumn());
                String str = cell.getStringCellValue();
                if (StringUtils.isEmpty(str)) {
                    str = data.getValue();
                } else {
                    // 替换单元格内容
                    str = str.replace(data.getKey(), data.getValue());
                }
                // 写入单元格内容
                cell.setCellType(CellType.STRING);
                // cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                cell.setCellValue(str);
            }
            // 输出文件
            FileOutputStream fileOut = new FileOutputStream(targetFilePath);
            hssfWorkbook.write(fileOut);
            fileOut.close();

        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 写入新版本的excel
     * @param sourceFilePath Excel模板文件路径
     * @param dataVOS 待写数据
     * @param targetFilePath Excel生成文件路径
     * @return
     */
    private static boolean writeToExcelNew(String sourceFilePath, List<ExcelDataVO> dataVOS, String targetFilePath) {
        boolean flag = true;
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(sourceFilePath));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(dataInputStream);
            Sheet sheet = xssfWorkbook.getSheetAt(0);
            for (ExcelDataVO dataVO : dataVOS) {
                XSSFRow xssfRow = ((XSSFSheet) sheet).getRow(dataVO.getRow());
                XSSFCell xssfCell = xssfRow.getCell(dataVO.getColumn());
                String str = xssfCell.getStringCellValue();
                if (StringUtils.isEmpty(str)) {
                    str = dataVO.getValue();
                } else {
                    // 替换单元格内容
                    str = str.replace(dataVO.getKey(), dataVO.getValue());
                }
                // 写入单元格内容
                xssfCell.setCellType(CellType.STRING);
                // cell.setEncoding(HSSFCell.ENCODING_UTF_16); 可以添加编码格式
                xssfCell.setCellValue(str);
                // 输出文件
                FileOutputStream fileOut = new FileOutputStream(targetFilePath);
                xssfWorkbook.write(fileOut);
                fileOut.close();
            }

        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 从老版本文件读取数据
     * @param sourceFilePath Excel文件路径
     * @return
     */
    private static List<List<ExcelDataVO>> readFromExcelOld(String sourceFilePath) {
        List<List<ExcelDataVO>> excelDataList = new ArrayList<>();
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
                    sourceFilePath));
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fs);
            int size = hssfWorkbook.getNumberOfSheets();
            HSSFSheet sheet;
            // 每一页数据
            for (int i = 0; i < size; i++) {
                sheet = hssfWorkbook.getSheetAt(i);
                if (sheet == null) {
                    continue;
                }
                List<ExcelDataVO> excelData = new ArrayList<>();
                // 每一行数据
                for (int rowNumber = 1; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
                    HSSFRow row = sheet.getRow(rowNumber);
                    int minColIx = row.getFirstCellNum();
                    int maxColIx = row.getLastCellNum();
                    // 每一个单元格数据
                    for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                        HSSFCell cell = row.getCell(colIx);
                        ExcelDataVO excelDataVO = new ExcelDataVO();
                        excelDataVO.setColumn(colIx);
                        excelDataVO.setRow(rowNumber);
                        excelDataVO.setValue(cell.getStringCellValue());
                        excelDataVO.setKey(sheet.getRow(0).getCell(colIx).getStringCellValue());
                        excelData.add(excelDataVO);
                    }
                }
                excelDataList.add(excelData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelDataList;
    }

    /**
     * 从新版本文件读取数据
     * @param sourceFilePath Excel文件路径
     * @return
     */
    private static List<List<ExcelDataVO>> readFromExcelNew(String sourceFilePath) {
        List<List<ExcelDataVO>> excelDataList = new ArrayList<>();
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(sourceFilePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelDataList;
    }

    private static void readFromExcelNew001(String sourceFilePath) {

        LinkedHashMap<String, String> filedMap = new LinkedHashMap<String, String>() {
            {
                put("UID", "uid");
            }};

        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(sourceFilePath));
            // excelToList(sourceFilePath, "Sheet1", filedMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> excelToList(
            InputStream in,
            String sheetName,
            Class<T> entityClass,
            LinkedHashMap<String, String> fieldMap
    ) throws ExcelException {

        //定义要返回的list
        List<T> resultList = new ArrayList<T>();

        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
            XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);


            // 获取有效行数
            int realRows = 0;
            for (int rowNumber = 0; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
                int nullCols = 0;
                for (int j = 0; j < sheet.getLastRowNum(); j++) {
                    XSSFRow row = sheet.getRow(rowNumber);
                    XSSFCell cell = row.getCell(j);
                    if (cell == null || "".equals(cell.getCellComment().toString())) {
                        nullCols++;
                    }
                }
                if (nullCols == sheet.getLastRowNum()) {
                    break;
                } else {
                    realRows++;
                }
            }

            //如果Excel中没有数据则提示错误
            if (realRows <= 1) {
                throw new ExcelException("Excel文件中没有任何数据");
            }

            XSSFRow xssfRow = sheet.getRow(0);

            String[] excelFieldNames = new String[xssfRow.getLastCellNum()];

            //将列名和列号放入Map中,这样通过列名就可以拿到列号
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < excelFieldNames.length; i++) {
                colMap.put(excelFieldNames[i], xssfRow.getCell(i).getColumnIndex());
            }

            //判断需要的字段在Excel中是否都存在
            boolean isExist = true;
            List<String> excelFieldList = Arrays.asList(excelFieldNames);
            for (String cnName : fieldMap.keySet()) {
                if (!excelFieldList.contains(cnName)) {
                    isExist = false;
                    break;
                }
            }

            //如果有列名不存在，则抛出异常，提示错误
            if (!isExist) {
                throw new ExcelException("Excel中缺少必要的字段，或字段名称有误");
            }

            //将sheet转换为list
            for (int i = 1; i < realRows; i++) {

                XSSFRow row = sheet.getRow(i);

                //新建要转换的对象
                T entity = entityClass.newInstance();

                //给对象中的字段赋值
                for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                    //获取中文字段名
                    String cnNormalName = entry.getKey();
                    //获取英文字段名
                    String enNormalName = entry.getValue();
                    //根据中文字段名获取列号
                    int col = colMap.get(cnNormalName);

                    //获取当前单元格中的内容
                    String content = row.getCell(col).getCellComment().toString().trim();

                    //给对象赋值
                    setFieldValueByName(enNormalName, content, entity);
                }

                resultList.add(entity);
            }
        } catch (Exception e) {
            throw new ExcelException("导入Excel失败");
        }
        return resultList;
    }

    private static void setFieldValueByName(String fieldName, Object fieldValue, Object o) throws Exception {

        Field field = getFieldByName(fieldName, o.getClass());
        if (field != null) {
            field.setAccessible(true);
            //获取字段类型
            Class<?> fieldType = field.getType();

            //根据字段类型给字段赋值
            if (String.class == fieldType) {
                field.set(o, String.valueOf(fieldValue));
            } else if ((Integer.TYPE == fieldType)
                    || (Integer.class == fieldType)) {
                field.set(o, Integer.parseInt(fieldValue.toString()));
            } else if ((Long.TYPE == fieldType)
                    || (Long.class == fieldType)) {
                field.set(o, Long.valueOf(fieldValue.toString()));
            } else if ((Float.TYPE == fieldType)
                    || (Float.class == fieldType)) {
                field.set(o, Float.valueOf(fieldValue.toString()));
            } else if ((Short.TYPE == fieldType)
                    || (Short.class == fieldType)) {
                field.set(o, Short.valueOf(fieldValue.toString()));
            } else if ((Double.TYPE == fieldType)
                    || (Double.class == fieldType)) {
                field.set(o, Double.valueOf(fieldValue.toString()));
            } else if (Character.TYPE == fieldType) {
                if ((fieldValue != null) && (fieldValue.toString().length() > 0)) {
                    field.set(o, Character
                            .valueOf(fieldValue.toString().charAt(0)));
                }
            } else if (Date.class == fieldType) {
                field.set(o, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fieldValue.toString()));
            } else {
                field.set(o, fieldValue);
            }
        } else {
            throw new ExcelException(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
        }
    }

    private static Field getFieldByName(String fieldName, Class<?> clazz) {
        //拿到本类的所有字段
        Field[] selfFields = clazz.getDeclaredFields();

        //如果本类中存在该字段，则返回
        for (Field field : selfFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        //否则，查看父类中是否存在此字段，如果有则返回
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            return getFieldByName(fieldName, superClazz);
        }

        //如果本类和父类都没有，则返回空
        return null;
    }


    /**
     * 功能:获取单元格的值
     */
    private static String getCellValue(Cell cell) {
        Object result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    result = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    result = cell.getNumericCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    result = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    result = cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_ERROR:
                    result = cell.getErrorCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }


    /**
     * 将旧版本excel转换成html
     * @param sourceFilePath Excel文件路径
     * @return
     */
    private static String excelToHtmlOld(String sourceFilePath) {
        String path = null;
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(sourceFilePath));
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fs);
            ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
            excelToHtmlConverter.processWorkbook(hssfWorkbook);
            List pics = hssfWorkbook.getAllPictures();
            if (pics != null) {
                for (int i = 0; i < pics.size(); i++) {
                    Picture picture = (Picture) pics.get(i);
                    picture.writeImageContent(new FileOutputStream("j:\\" + picture.suggestFullFileName()));
                }
            }
            Document htmlDocument = excelToHtmlConverter.getDocument();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            DOMSource domSource = new DOMSource(htmlDocument);
            StreamResult streamResult = new StreamResult(outputStream);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            transformer.transform(domSource, streamResult);
            outputStream.close();

            String content = new String(outputStream.toByteArray());
            FileUtils.writeStringToFile(new File("j:\\", "exportExcel.html"), content, "utf-8");
            path = "j:\\exportExcel.html";
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 将新版本excel转换成html
     * @param sourceFilePath Excel文件路径
     * @return
     */
    private static String excelToHtmlNew(String sourceFilePath) {
        String path = null;
        /*DataInputStream dataInputStream = new DataInputStream(new FileInputStream(sourceFilePath));
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(dataInputStream);

        ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        excelToHtmlConverter.processWorkbook(xssfWorkbook);*/

        return path;
    }


}
