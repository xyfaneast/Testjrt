package com.cmc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestString {
    public static void main(String[] args) {
        System.out.println("+8613911075015".hashCode());
        // String format = String.format("bodytext", "username");
        // System.out.println(format);
        // String depthname = "aaa/bbb/ccc";
        // getDepthnames(depthname);
        /*
         * List<Map<String, Object>> datas = new ArrayList<Map<String,
         * Object>>(); Map<String, Object> map1 = new HashMap<>();
         * map1.put("count", 2); map1.put("toid", 12345); Map<String, Object>
         * map2 = new HashMap<>(); map2.put("count", 3); map2.put("toid",
         * 123456); Map<String, Object> map3 = new HashMap<>();
         * map3.put("count", 4); map3.put("toid", 1234567); datas.add(map1);
         * datas.add(map2); datas.add(map3);
         * 
         * List<Map<String, Object>> datas1 = new ArrayList<Map<String,
         * Object>>(); Map<String, Object> map11 = new HashMap<>();
         * map11.put("count", 2); map11.put("toid", 123459); Map<String, Object>
         * map21 = new HashMap<>(); map21.put("count", 3); map21.put("toid",
         * 123456); Map<String, Object> map31 = new HashMap<>();
         * map31.put("count", 4); map31.put("toid", 1234567); datas1.add(map11);
         * datas1.add(map21); datas1.add(map31); for(int i =0 ;
         * i<datas.size();i++){ for (int j =0 ;j<datas1.size();j++){
         * System.out.println("1111111");
         * if(datas1.get(j).get("toid").toString().equals(datas.get(i).get(
         * "toid").toString())){ datas.get(i).put("count",
         * Long.valueOf(datas.get(i).get("count").toString()) +
         * Long.valueOf(datas1.get(j).get("count").toString()));
         * System.out.println(datas.get(i).get("toid").toString()+datas.get(i).
         * get("count").toString()); datas1.remove(j); break; } } }
         * datas.addAll(datas1); System.out.println("111");
         */
        /*
         * HashSet<String> depthnames = new HashSet<>();
         * depthnames.add("aaa/bbb/ccc"); depthnames.add("aaa/bbb");
         * depthnames.add("aaa"); String depthname = ""; int maxLength = 0; for
         * (String name : depthnames) { int length = name.length(); if(length >
         * maxLength){ maxLength = length; depthname = name; } }
         */
        /*
         * String encode = CinBase64.encode("ios_1.0.0004".getBytes());
         * System.out.println(encode);
         */
        // String s = "mali_901";

        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));

        String s = "100000217";
        int hashCode = s.hashCode();
//        System.out.println(s.hashCode());
        
        System.out.println(hashCode);
        System.out.println("+8613300133777".hashCode());
        System.out.println("+8613300133888".hashCode());
        /*
         * List<Map<String, Object>> openFileFlagList = null;13003215096
         * if(openFileFlagList == null || openFileFlagList.size()
         * <1){+8613300133666 System.out.println("该用户移动端已有打开文件权限");743747820 }
         */
        /*
         * String s = "/aaa/bbb&a1&a2"; char c = 0x5e; // String[] split =
         * s.split(String.valueOf(c)); String[] split = s.split("&"); String
         * managerPath = ""; String custumerPath = ""; if(split.length == 3){
         * managerPath = split[0] + "/" + split[1]; custumerPath = split[0] +
         * "/" + split[2]; }else{ System.out.println("参数传入错误，程序结束！----path" +
         * s); System.gc(); System.exit(0); } System.out.println(s.length());
         */
        System.out.println("13300133555".hashCode());
        List param = new ArrayList();
        param.add("aaa");
        List<Long> idsArray = new ArrayList<Long>();
        idsArray.add(1111L);
        idsArray.add(1121L);
        idsArray.add(1311L);
        Object[] array = idsArray.toArray();
        System.out.println(array);
        param.add(idsArray.toArray());
        Object[] array2 = param.toArray();
        System.out.println(array2);
    }

    public static List<String> getDepthnames(String depthname) {
        String[] names = depthname.split("/");
        List<String> depthnameList = new ArrayList<String>();
        String depth = depthname;
        String parentDepthname = "";
        for (int i = 0; i < names.length; i++) {
            int indexOf = depth.indexOf("/");
            if (indexOf != -1) {
                depth = depth.substring(indexOf + 1);
                parentDepthname = depthname.substring(0, depthname.lastIndexOf(depth) - 1);
                depthnameList.add(parentDepthname);
            }
        }
        depthnameList.add(depthname);
        return depthnameList;
    }
}
