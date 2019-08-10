package com.ann.bronze.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description //TODO
 * @Author latecomer
 * @Date 23:41 2019-07-28
 **/
@Data
public class BookModel extends BaseRowModel {

    @ApiModelProperty("code")
    @ExcelProperty(value = "code", index = 0)
    private String code;

    @ApiModelProperty("名称")
    @ExcelProperty(value = "名称", index = 1)
    private String name;

    @ApiModelProperty("日期")
    @ExcelProperty(value = "日期", index = 2)
    private String year;

    @ApiModelProperty("作者")
    @ExcelProperty(value = "作者", index = 3)
    private String author;

    @ApiModelProperty("价格")
    @ExcelProperty(value = "价格", index = 4)
    private String price;
}
