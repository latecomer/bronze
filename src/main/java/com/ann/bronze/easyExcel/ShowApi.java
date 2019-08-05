package com.ann.bronze.easyExcel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description //TODO
 * @Author latecomer
 * @Date 15:39 2019-07-02
 **/

@RestController
@Api(tags = "ExcelController", description = "ExcelController")
@RequestMapping(value = "/excel")
public class ShowApi {

    @Autowired
    private ExcelService excelService;

    @ApiOperation(value="writeExcel", notes="写入excel")
    @RequestMapping(value="writeExcel", method= RequestMethod.GET)
    public String writeExcel() {
        try {
            excelService.writeExcel();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @ApiOperation(value="readExcel", notes="读取Excel")
    @RequestMapping(value="readExcel", method= RequestMethod.GET)
    public List<BookModel> readExcel() {
        try {
            return excelService.readExcel();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ApiOperation(value="writeExcelByFactory", notes="通过factory写入excel")
    @RequestMapping(value="writeExcelByFactory", method= RequestMethod.GET)
    public String writeExcelByFactory() {
        try {
            excelService.writeExcelByFactory();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @ApiOperation(value="readExcelByFactory", notes="通过factory读取Excel")
    @RequestMapping(value="readExcelByFactory", method= RequestMethod.GET)
    public List<BookModel> readExcelByFactory() {
        try {
            return excelService.readExcelByFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
