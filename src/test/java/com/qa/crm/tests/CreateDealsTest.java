package com.qa.crm.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import com.qa.crm.base.Base;
import com.qa.crm.pages.DealsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.UtilData;

public class CreateDealsTest extends Base{

	public XSSFWorkbook _workbook=null;
	public XSSFSheet _sheet=null;
	public XSSFCell _cell=null;
	public XSSFRow _row=null;
	
	File _file=new File(prop.getProperty("dealsDataFile"));
	FileInputStream _fip=null;
	
	DealsPage dp;
	HomePage hp;
	
	public CreateDealsTest(){
		super();
		
	}
	
	@BeforeTest
	public void setup(){
		initalization();
		LoginPage lp=new LoginPage();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		UtilData.switchToFrame(prop.getProperty("homePage_frame"));
		dp=hp.clickOnDealsLink();
		dp.navigateToDeals();
	}
	
	@Test
	public void createNewDealsTest() throws IOException, InterruptedException{
		
		_fip=new FileInputStream(_file);
		_workbook=new XSSFWorkbook(_fip);
		_sheet=_workbook.getSheet(prop.getProperty("dealsDataFileSheet"));
		for(int i=_sheet.getFirstRowNum();i<_sheet.getLastRowNum();i++){
			_row=_sheet.getRow(i);
			for(int j=_row.getFirstCellNum();j<_row.getLastCellNum();j++){
				_cell=_row.getCell(j);
				dp.createDeals(_cell.toString());
				Thread.sleep(2000);
				dp.navigateToDeals();
			}//for J
		}//for I
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}

}
