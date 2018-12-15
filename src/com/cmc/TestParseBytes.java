package com.cmc;

import com.allstar.cintransaction.cinmessage.CinMessageReader;
import com.allstar.cinutil.CinConvert;
/**
 * 解析抓包数据的测试方法
 * @author FD1
 *
 */
public class TestParseBytes {

	public static void main(String[] args) {
		//抓到的数据字符串（二进制）
		String str = "02:01:04:d7:84:bb:29:02:04:7d:b2:b9:29:0d:01:01:12:01:01:05:10:2c:9e:68:40:05:8b:4d:05:bd:fe:ff:93:4b:af:76:5b:13:01:00:fb:01:02:1c:0f:38:36:36:36:39:36:30:32:31:30:31:37:30:31:35:20:04:32:30:30:30:07:01:00:15:06:30:af:f9:2d:62:01:06:06:32:af:f9:2d:62:01:03:01:3f:04:03:99:e6:06:ff:10:00:54:b5:be:d0:0b:fa:32:6d:22:2c:d4:bd:a5:10:a7:ab:00".replaceAll(":", "");
		//解析数据
		System.out.println(CinMessageReader.parse(CinConvert.hexToBytes(str)));
	}

}
