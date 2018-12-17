/**
 * 
 */
package com;

/**
 * @author fandong
 * @date 2018年11月21日 上午9:53:00 
 * @desc 交行公众号推送消息类型 q3575yi095et
 */
public enum EnumTest {

    iTWorkPending("iTWorkPendingMsg", "01"),text("textMsg", "00"),unknown("unknown", "");
    
    private String msgType;
    private String msgId;
    
    
    
    private EnumTest(String msgType, String msgId) {
        this.msgType = msgType;
        this.msgId = msgId;
    }

    

    public String getMsgType() {
        return msgType;
    }



    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }



    public String getMsgId() {
        return msgId;
    }



    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }



    /**
     * @author fandong
     * @date 2018年11月21日 上午9:53:00 
     * @desc
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String msgId2 = EnumTest.iTWorkPending.getMsgId();
        String msgType2 = EnumTest.iTWorkPending.getMsgType();
        System.out.println(msgId2+"---"+msgType2);
        EnumTest.text.getMsgType();
    }

}
