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
import java.util.ArrayList;
import java.util.List;

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
     * @param sourceFilePath excel读取文件
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
     * 将excel表转换成html
     * @param sourceFilePath
     * @param type
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
     *
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
     * @param sourceFilePath
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
     * @param sourceFilePath
     * @return
     */
    private static List<List<ExcelDataVO>> readFromExcelNew(String sourceFilePath) {
        List<List<ExcelDataVO>> excelDataList = new ArrayList<>();
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(sourceFilePath));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(dataInputStream);
            int size = xssfWorkbook.getNumberOfSheets();
            XSSFSheet sheet;
            // 每一页数据
            for (int i = 0; i < size; i++) {
                sheet = xssfWorkbook.getSheetAt(i);
                if (sheet == null) {
                    continue;
                }
                List<ExcelDataVO> excelData = new ArrayList<>();
                // 每一行数据
                for (int rowNumber = 1; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
                    XSSFRow row = sheet.getRow(rowNumber);
                    int minColIx = row.getFirstCellNum();
                    int maxColIx = row.getLastCellNum();
                    for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                        XSSFCell cell = row.getCell(colIx);
                        ExcelDataVO excelDataVO = new ExcelDataVO();
                        excelDataVO.setRow(rowNumber);
                        excelDataVO.setColumn(colIx);
                        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                            excelDataVO.setValue(cell.getStringCellValue());
                        }
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            excelDataVO.setValue(String.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                            excelDataVO.setValue(String.valueOf(cell.getBooleanCellValue()));
                        }
                        if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                            excelDataVO.setValue(String.valueOf(cell.getRichStringCellValue()));
                        }
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
     *
     * @param sourceFilePath
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
     *
     * @param sourceFilePath
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
