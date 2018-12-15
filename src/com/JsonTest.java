/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author fandong
 * @date 2018年11月21日 上午9:53:00 
 * @desc 测试json
 */
public class JsonTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*String msgId2 = '{"RSP_HEAD":{"TRACE_NO":"1227000420181127JP6246055173","TRAN_SUCCESS":"1"},"RSP_BODY":{"REMOTE_IP":"182.119.113.85","loginName":"zhang_wf","typeName":"MOB_PRD_InitBatchService","URL_ACTION":"mobRequsetCommonService","params":{"taskId":"4AC0CBABB677513E23781CTA3OQS00GQ"},"resultObject":"{\"modifyUser\":0,\"btns\":[\"submitBtn\",\"followBtn\",\"approveBtn\",\"fileBtn\"],\"version\":0,\"prdBatchServiceBo\":{\"eiNum\":\"BYY0000000631\",\"serviceTitle\":\"全表单测试20181127\",\"fileKey\":\"1543306472152267\",\"reason\":\"全表单测试20181127全表单测试20181127全表单测试20181127全表单测试20181127\",\"modifyUser\":0,\"endDate\":\"2018-11-30 16:12:47\",\"createTime\":1543308509620,\"vld\":\"1\",\"eiName\":\"IT工作平台\",\"startDate\":\"2018-11-30 16:12:46\",\"updateTime\":1543308509620,\"serviceNo\":\"BA2018112700003\",\"batchServiceId\":124,\"version\":0,\"eiId\":\"0D86299EFF000083011AB7980458FD38\"},\"processBo\":{\"taskId\":\"4AC0CBABB677513E23781CTA3OQS00GQ\",\"applyUserName\":\"涂文斌\",\"subProcessId\":\"16CB8401B677513E23781CTA3OPP80GC\",\"processId\":\"16CB8401B677513E23781CTA3OPP80GC\",\"fillingTime\":\"2018-11-27 16:48:29.602842\",\"nodeName\":\"申请人\",\"deptName\":\"软件开发中心（上海）\",\"updateTime\":1543308509602,\"userName\":\"涂文斌\",\"version\":0,\"nodeId\":\"BatNode1\"}]}"}}';
        String msgType2 = msgId2.replaceAll("\"", "'");
        System.out.println(msgType2);*/
        Gson gson = new Gson();
        
        String json1 = json1(gson);
        System.out.println(json1);
        /*ArrayList<NodeBean> list = new ArrayList<>();
        list.add(new NodeBean("1", "1", "1", "1", "1", "1", "1"));
        list.add(new NodeBean("2", "1", "1", "1", "1", "1", "1"));
        list.add(new NodeBean("3", "1", "1", "1", "1", "1", "1"));
        list.add(new NodeBean("4", "1", "1", "1", "1", "1", "1"));
        String json = gson.toJson(list);
        ArrayList<NodeBean> list1 = gson.fromJson(json, new TypeToken<ArrayList<NodeBean>>() {}.getType());
        for (NodeBean nodeBean : list1) {
            System.out.println(nodeBean.getNodeId());
        }*/
    }

    public static String json1(Gson gson){
        Map<String,Object> map = new HashMap<String,Object>();
        PendingTaskMsgBean pendingTaskMsg = new PendingTaskMsgBean("11", "2222", "sfgdh");
        pendingTaskMsg.setTypeName("qqqq");
        map.put("type", 1);
        map.put("data", pendingTaskMsg);
        String content = gson.toJson(map);
        return content;
    }
}
