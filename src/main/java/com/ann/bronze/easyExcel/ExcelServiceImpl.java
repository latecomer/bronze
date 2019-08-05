package com.ann.bronze.easyExcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

import static org.apache.tomcat.util.file.ConfigFileLoader.getInputStream;

/**
 * @Description //TODO
 * @Author latecomer
 * @Date 22:54 2019-07-28
 **/
@Service
@Slf4j
public class ExcelServiceImpl implements ExcelService {

    private static final String fileName = "/Users/dasouche/temp/book.xlsx";

    @Override
    public List<BookModel> readExcel() throws IOException {
        InputStream inputStream = getInputStream("/Users/dasouche/temp/book.xlsx");
        try {
            // 解析每行结果在listener中处理
            AnalysisEventListener listener = new ExcelListener();

            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);

            //sheetNo:从第几个sheet读取，headLineMun：从第几行读取
            excelReader.read(new Sheet(1, 1, BookModel.class));

            List<Object> dataObjs = ((ExcelListener) listener).getDataList();
            List<BookModel> books = Lists.newArrayList();
            dataObjs.stream().forEach(obj -> books.add((BookModel)obj));
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void writeExcel() throws FileNotFoundException {
        OutputStream out = new FileOutputStream("/Users/dasouche/temp/book.xlsx");
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1
            Sheet sheet1 = new Sheet(1, 0, BookModel.class);
            writer.write(getModels(), sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<BookModel> readExcelByFactory() throws IOException {
        try {
            //创建输入流
            InputStream inputStream = new FileInputStream(fileName);
            //构建要添加Student类
            Sheet sheet = new Sheet(1,0, BookModel.class);
            //读sheet表中的内容
            List<Object> bookList = EasyExcelFactory.read(inputStream, sheet);
            List<BookModel> books = Lists.newArrayList();
            bookList.stream().forEach(obj -> books.add((BookModel)obj));
            return books;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeExcelByFactory() throws FileNotFoundException {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName);
            ExcelWriter writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(2, 0, BookModel.class);
            writer.write(getModels(), sheet);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 模拟数据，待写入excel
     * @return
     */
    private List<BookModel> getModels() {
        BookModel model1 = new BookModel();
        model1.setCode("0001");
        model1.setName("java编程");
        model1.setAuthor("张三");
        model1.setYear("2019-06-01");
        model1.setPrice("98.00");

        BookModel model2 = new BookModel();
        model2.setCode("0002");
        model2.setName("python编程");
        model2.setAuthor("刘永");
        model2.setYear("2019-07-01");
        model2.setPrice("78.00");

        List<BookModel> list = Lists.newArrayList(model1, model2);
        return list;
    }
}
