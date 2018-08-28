package peaner.yier.utils.excel.core;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lilongzhou
 * @Description: 处理excel写
 * @Date: Created in 18:08 2018/8/15
 */
public class ExcelTemplates {

    // 初始行
    private int initRowIndex;

    // 初始列
    private int initColIndex;

    // 当前行
    private int curRowIndex;

    // 当前列
    private int curColIndex;

    // 最后一行
    private int lastRowIndex;

    // 默认行高
    private float defaultHeight;

    // 序号行
    private int serColIndex;
    private Workbook workbook = null;
    private Sheet sheet = null;

    // 当前行
    private Row curRow = null;

    // 样式
    private Map<Integer, CellStyle> styles = null;

    // 默认样式
    private CellStyle defaultStyle = null;

    // 使用单例
    private static ExcelTemplates excel = new ExcelTemplates();

    private ExcelTemplates() {
    }

    public static ExcelTemplates getInstance() {
        return excel;
    }

    /**
     * 读取模板(从classpath中)
     *
     * @param calsspath 模板路径
     *
     * @return ExcelTemplate
     *
     */
    public ExcelTemplates readTemplateClassPath(String calsspath) {
        try {
            workbook = WorkbookFactory.create(ExcelTemplates.class
                    .getResourceAsStream(calsspath));
            initTemplate();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("读取模板格式有错!请检查.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("读取模板文件不存在!请检查.");
        }
        return this;
    }

    /**
     * 读取模板(从指定路径)
     *
     * @param path 模板路径
     *
     * @return ExcelTemplate
     */
    public ExcelTemplates readTemplatePath(String path) {
        try {
            workbook = WorkbookFactory.create(new File(path));
            initTemplate();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("读取模板格式有错!请检查.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("读取模板文件不存在!请检查.");
        }
        return this;
    }

    /**
     * 创建新的一行
     */
    public void creatNewRow() {
        // curRowIndex != initRowIndxe : 当前行本身是存在的,所以下移多余.
        if (lastRowIndex > curRowIndex && curRowIndex != initRowIndex) {
            // 有的模板最后可能是日期或者姓名之类的非数据.所以要移动行
            sheet.shiftRows(curRowIndex, lastRowIndex, 1, true, true);
            lastRowIndex++;
        }
        curRow = sheet.createRow(curRowIndex);
        curRow.setHeightInPoints(defaultHeight);
        curRowIndex++;
        curColIndex = initColIndex;
    }

    /**
     * 创建新的一列
     * @param value 字符串类型数据
     */
    public void createNewCol(String value) {
        Cell cell = curRow.createCell(curColIndex);
        setStyle(cell);
        cell.setCellValue(value);
        curColIndex++;
    }

    /**
     * 创建新的一列
     * @param value double类型数据
     */
    public void createNewCol(double value) {
        Cell cell = curRow.createCell(curColIndex);
        setStyle(cell);
        cell.setCellValue(value);
        curColIndex++;
    }

    /**
     * 创建新的一列
     * @param value boolean类型数据
     */
    public void createNewCol(boolean value) {
        Cell cell = curRow.createCell(curColIndex);
        setStyle(cell);
        cell.setCellValue(value);
        curColIndex++;
    }

    /**
     * 创建新的一列
     * @param value 时间类型数据
     */
    public void createNewCol(Date value) {
        Cell cell = curRow.createCell(curColIndex);
        setStyle(cell);
        cell.setCellValue(value);
        curColIndex++;
    }

    /**
     * 创建新的一列
     * @param value 日历类型数据
     */
    public void createNewCol(Calendar value) {
        Cell cell = curRow.createCell(curColIndex);
        setStyle(cell);
        cell.setCellValue(value);
        curColIndex++;
    }

    /**
     * 创建新的一列
     * @param value 大文本类型数据
     */
    public void createNewCol(RichTextString value) {
        Cell cell = curRow.createCell(curColIndex);
        setStyle(cell);
        cell.setCellValue(value);
        curColIndex++;
    }

    /**
     * 根据#xxx替换模板中的其它样式.
     *
     * @param datas 要替换的数据
     *
     */
    public void replaceFind(Map<String, String> datas) {
        if (datas == null)
            return;
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() != Cell.CELL_TYPE_STRING)
                    continue;
                String value = cell.getStringCellValue().trim();
                if (value.startsWith("#")) {
                    if (datas.containsKey(value.substring(1))) {
                        cell.setCellValue(datas.get(value.substring(1)));
                    }
                }
            }
        }
    }

    /**
     * 插入序号
     */
    public void insertSer() {
        int index = 1;
        Row row = null;
        Cell cell = null;
        for (int i = initRowIndex; i < curRowIndex; i++) {
            row = sheet.getRow(i);
            cell = row.createCell(serColIndex);
            setStyle(cell);
            cell.setCellValue(index++);
        }
    }

    /**
     * 输出文件,根据路径
     *
     * @param path 路径
     *
     */
    public void writeToFile(String path) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("找不到文件!请检查.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件输出异常!请检查.");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 输出文件,根据流输出
     *
     * @param stream OutputStream
     *
     */
    public void writeToStream(OutputStream stream) {
        try {
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件输出异常!请检查.");
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                    stream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化模板
     */
    private void initTemplate() {
        sheet = workbook.getSheetAt(0);
        styles = new HashMap<Integer, CellStyle>();
        initConfigData();
        lastRowIndex = sheet.getLastRowNum();
    }

    /**
     * defaultStyles:获得默认样式(如果默认样式没有则使用开始样式) styles:获取自定义样式
     *
     */
    private void initConfigData() {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() != Cell.CELL_TYPE_STRING)
                    continue;
                String value = cell.getStringCellValue().trim();
                // 获取开始位置,初始化数据
                if (Constants.TEMPLATE_NAME.equals(value)) {
                    initRowIndex = cell.getRowIndex();
                    initColIndex = cell.getColumnIndex();
                    curRowIndex = initRowIndex;
                    curColIndex = initColIndex;
                    defaultHeight = row.getHeightInPoints();
                    if (defaultStyle == null)
                        defaultStyle = cell.getCellStyle();
                }
                // 获取defaultStyles,无论如何,当有设置defaultStyles都设置为defaultStyles
                if (Constants.DEFALULT_STYLE.equals(value))
                    defaultStyle = cell.getCellStyle();
                // 获取自定义样式的列
                if (Constants.STYLE.equals(value)) {
                    styles.put(cell.getColumnIndex(), cell.getCellStyle());
                }
                // 获取样式所在的列
                if (Constants.SERNUMS.equals(value))
                    serColIndex = cell.getColumnIndex();
            }
        }
    }

    /**
     * 设置样式
     *
     * @param cell Cell
     *
     */
    private void setStyle(Cell cell) {
        // 当前列存在自定义样式时使用自定义样式,否则使用默认样式.
        if (styles.containsKey(curColIndex)) {
            cell.setCellStyle(styles.get(curColIndex));
        } else {
            cell.setCellStyle(defaultStyle);
        }
    }

}
