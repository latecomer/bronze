package com.ann.bronze.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description //TODO
 * @Author latecomer
 * @Date 23:03 2019-07-28
 **/

public class ExcelListener extends AnalysisEventListener {

    /**
     * 自定义用于暂时存储data。
     * 可以通过实例获取该值
     */
    private List<Object> dataList = new ArrayList<>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        System.out.println("当前行："+context.getCurrentRowNum());
        System.out.println(object);
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        dataList.add(object);
        //根据自己业务做处理
        doSomething(object);
    }
    private void doSomething(Object object) {
        //1、入库调用接口
        System.out.println("读入数据:" + object.toString());
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
    }
    public List<Object> getDataList() {
        return dataList;
    }
    public void setDatas(List<Object> dataList) {
        this.dataList = dataList;
    }
}
