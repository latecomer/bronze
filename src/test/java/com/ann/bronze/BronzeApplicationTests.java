package com.ann.bronze;

import com.ann.bronze.easyexcel.ExcelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BronzeApplicationTests {
	@Autowired
	ExcelService excelService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testExcelRead() throws IOException {
		excelService.readExcel();
	}

	@Test
	public void testExcelWrite() throws FileNotFoundException {
		excelService.writeExcel();
	}
}
