package com.cmc;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestTime {

    public static void main(String[] args) throws ParseException {
        // Calendar c = Calendar.getInstance();
        /*
         * c.add(Calendar.DAY_OF_MONTH, -1); SimpleDateFormat format = new
         * SimpleDateFormat("yyyyMMdd"); SimpleDateFormat dateTimeFormat = new
         * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); c.set(Calendar.HOUR_OF_DAY,
         * 0); c.set(Calendar.MINUTE, 0); c.set(Calendar.SECOND, 0);
         */
        /*
         * SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
         * "yyyy-MM-dd HH:mm:ss"); long starttime = System.currentTimeMillis();
         * Date date = new Date(21529030952040L); String format =
         * dateTimeFormat.format(date);
         */

        // System.out.println(starttime);
        /*
         * String uuid = UUID.randomUUID().toString().replace("-",
         * "").toLowerCase(); System.out.println(uuid);
         */

        // 设置查询的表
        /*
         * Calendar cTable = Calendar.getInstance();//设置查询的表使用
         * cTable.add(Calendar.MONTH, -6); cTable.add(Calendar.DAY_OF_MONTH,
         * -1); String tableIndexEnd = "" + cTable.get(Calendar.YEAR); int
         * monthEnd = (cTable.get(Calendar.MONTH) + 1); if (monthEnd < 10) {
         * tableIndexEnd = tableIndexEnd + "0" + monthEnd; }else{ tableIndexEnd
         * = tableIndexEnd + monthEnd; }
         * 
         * cTable.add(Calendar.DAY_OF_MONTH, -30); String tableIndexBegin = "" +
         * cTable.get(Calendar.YEAR); int monthBegin =
         * (cTable.get(Calendar.MONTH) + 1); if (monthBegin < 10) {
         * tableIndexBegin = tableIndexBegin + "0" + monthBegin; }else{
         * tableIndexBegin = tableIndexBegin + monthBegin; }
         */
        /*
         * String beginTimeStr = format.format(beginTime);
         * c.set(Calendar.HOUR_OF_DAY, 23); c.set(Calendar.MINUTE, 59);
         * c.set(Calendar.SECOND, 59); Date endTime = c.getTime(); String
         * endTimeStr = dateTimeFormat.format(endTime); // String day =
         * format.format(c.getTime()); System.out.println(beginTimeStr);
         * System.out.println(endTimeStr);
         */
        /*
         * long millis = System.currentTimeMillis(); System.out.println(millis);
         * System.out.println(String.valueOf(millis).substring(5)); Date date =
         * new Date(); date.setTime(1515499179l); SimpleDateFormat format = new
         * SimpleDateFormat("yyyyMMddHHmmss"); String sendDate =
         * format.format(date); System.out.println(sendDate);
         */
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        String format2 = format.format(new Date());
        System.out.println(format2);
        long millis = System.currentTimeMillis();
        System.out.println(millis);
    }

    /*
     * public static void main(String[] args) { // String str = "zhang"; //
     * String base64=getBase64(str); // System.out.println(base64); // String
     * res = getFromBase64(base64); // System.out.println(res); String[] split1
     * ={"1"}; String path = "银行/外协/测试/管理"; String[] split = path.split("/");
     * split1[0] = split[split.length - 1]; System.out.println(split1[0]); int i
     * = 4; System.out.println("导入数据部门测试管理部，UAT环境不导入,数据为第%s条 " + i); }
     */

    // 加密
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    // 解密
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
