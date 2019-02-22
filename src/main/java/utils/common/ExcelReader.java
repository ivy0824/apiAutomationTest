package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static void main(String args[]) {
        List<List<String>> lists = readExcel("/Users/ivy/IdeaProjects/mavenDemo1/dataXlsx/test1.xlsx");
//        for (int i = 1; i < lists.size(); i++) {
//            System.out.println(lists.get(i));
//        }
        Object[][] results = new Object[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            results[i] = lists.get(i).toArray();
        }

        for (int i = 1; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {
                System.out.print(results[i][j] + " | ");
                }
                System.out.println();
                }
    }


        /**
         * 读取excel文件并返回除去第一行的数据
         *
         * @param path
         * @param path
         * @throws IOException
         */
    public static List<List<String>> readExcel(String path) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        // return a list contains many list
        List<List<String>> lists = new ArrayList<List<String>>();
        //读取excel文件
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            //获取工作薄
            Workbook wb = null;
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            } else {
                return null;
            }

            //读取第一个工作页sheet
            Sheet sheet = wb.getSheetAt(0);
            //第一行为标题
            for (Row row : sheet) {
                ArrayList<String> list = new ArrayList<String>();
                for (Cell cell : row) {
                    //根据不同类型转化成字符串
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    list.add(cell.getStringCellValue());
                }

                lists.add(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<List<String>> lists1 = new ArrayList<List<String>>();
        for(int i=1;i<lists.size();i++){
            lists1.add(lists.get(i));
        }
        return lists1;
    }
}

