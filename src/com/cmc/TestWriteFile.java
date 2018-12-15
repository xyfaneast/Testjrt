package com.cmc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestWriteFile {

	public static void main(String[] args) {
		File file = new File("e:/BankCustomer.del");
//		File file = new File("e:/aaa/20180531/BMOS_CUSMANAGER_GUPMESSAGE_20180531.del");
		// BufferedReader:从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
		BufferedWriter bufWriter = null;
		try {
			// FileReader:用来读取字符文件的便捷类。
			char c = 0x0f;
			bufWriter = new BufferedWriter(new FileWriter(file));
			for (int i = 3000000; i < 6000000; i++) {
				bufWriter.write("99999999" + i + c + "小马云" + i);
				bufWriter.newLine();
				bufWriter.flush();
			}
			/*for (int i = 110; i < 500; i++) {
				bufWriter.write("99999999" + i + c + "小马云" + i);
				bufWriter.newLine();
				bufWriter.flush();
			}*/
			/*for (int i = 0; i < 200000; i++) {
				bufWriter.write("2018051425000428433431054810131099999901156471182474382018-05-14 09无效联系无效联系hahghahgf哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈可以吗ahgkaghaslgk哈哈嘎哈噶嘎哈个啊嘎哈嘎哈个啊嘎哈噶个啊个嘎哈个按时噶搜狗啊搜狗啊个哈很高啊个发[{\"prdName\":\"嘉实研究阿尔法股票卡很感慨傻瓜； 嘎斯；嘎哈都是老歌； 敖德萨\",\"prdType\":\"基金\",\"prdCode\":\"000082\"},{\"prdName\":\"嘉实研究阿尔当时的噶老师看过了；矮冬瓜个是个法股票\",\"prdType\":\"基金\",\"prdCode\":\"000082\"},{\"prdName\":\"嘉实研究阿尔啊垃圾高楼大厦各级领导发生过关键时刻独具风格法股票\",\"prdType\":\"基金\",\"prdCode\":\"000082\"}]");
				bufWriter.newLine();
				bufWriter.flush();
			}*/
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (bufWriter != null) {
				try {
					bufWriter.close();
				} catch (IOException e) {
					e.getStackTrace();
				}
			}
		}
	}
}
