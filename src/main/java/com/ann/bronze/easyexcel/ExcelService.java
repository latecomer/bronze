package com.ann.bronze.easyexcel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Description //TODO
 * @Author latecomer
 * @Date 22:53 2019-07-28
 **/

public interface ExcelService {
    /**
     * 读取excel内容
     * @throws IOException
     * @return
     */
    List<BookModel> readExcel() throws IOException;

    /**
     * 写入excel
     * @throws FileNotFoundException
     */
    void writeExcel() throws FileNotFoundException;

    /**
     * 通过factory读取excel
     * @return
     * @throws IOException
     */
    List<BookModel> readExcelByFactory() throws IOException;

    /**
     * 通过factory写入excel
     * @throws FileNotFoundException
     */
    void writeExcelByFactory() throws FileNotFoundException;
}
