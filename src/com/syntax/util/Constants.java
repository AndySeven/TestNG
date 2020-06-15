package com.syntax.util;

public class Constants {
	static String userDir = System.getProperty("user.dir");
	public static final String CHROME_DRIVER_PATH = userDir+"/drivers/chromedriver";
	public static final String FIREFOX_DRIVER_PATH = userDir+"/drivers/firefoxdriver";
	public static final String PROPERTIES_FILE_PATH = userDir+"/configs/configuration.properties";
	public static final int IMPLICIT_WAIT_TIME = 30;
	public static final int EXPLICIT_WAIT_TIME = 20;
}
