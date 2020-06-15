package com.practice;

import com.syntax.util.ExcelUtility;

public class TestExcel {
	public static void main(String[] args) {
		printExcelData();
		
	}
	
	public static void printExcelData() {
		Object[][] data = ExcelUtility.getExcelData(System.getProperty("user.dir")+"/data/Test.xlsx", "Sheet1");
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.println("Length of data --> "+data.length);
				System.out.println("Height of data[i] --> "+data[i].length);
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
