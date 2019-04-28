package com.cmc;

import java.net.InetSocketAddress;
import java.util.ArrayList;

import com.allstar.cinconnection.CinStack;
import com.allstar.cintransaction.CinTransaction;
import com.allstar.cintransaction.CinTransactionEvent;
import com.allstar.cintransaction.cinmessage.CinBody;
import com.allstar.cintransaction.cinmessage.CinHeader;
import com.allstar.cintransaction.cinmessage.CinHeaderType;
import com.allstar.cintransaction.cinmessage.CinMessage;
import com.allstar.cintransaction.cinmessage.CinMessageReader;
import com.allstar.cintransaction.cinmessage.CinRequest;
import com.allstar.cintransaction.cinmessage.CinRequestMethod;
import com.allstar.cintransaction.cinmessage.CinResponse;
import com.allstar.event.CinServiceEvent;

/**
 * 通用设置获取列表测试
 * 
 * @author FD1
 *
 */
public class GeneralSettingsListHandler {

    public static void main(String[] args) throws Exception {
        CinRequest req = new CinRequest(CinRequestMethod.Service);
        req.addHeader(new CinHeader(CinHeaderType.Event, CinServiceEvent.GeneralSettingsList));
        req.addHeader(new CinHeader(CinHeaderType.From, 100000000l));
        req.addHeader(new CinHeader(CinHeaderType.Version, 4));
        req.addHeader(new CinHeader(CinHeaderType.Type, 0));

        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6005);
        CinStack.initialize();
        CinTransaction trans = CinStack.instance().createTransaction(address, req);

        trans.TransactionEvent = new CinTransactionEvent() {

            @Override
            public void onTimeout(CinTransaction trans) {
                System.out.println("timeout");
                System.exit(0);
            }

            @Override
            public void onSendFailed(CinTransaction trans) {
                System.out.println("Error");
                System.exit(0);
            }

            @Override
            public void onResponseReceived(CinTransaction trans, CinResponse response) {
                long version = response.getHeader(CinHeaderType.Version).getInt64();
                System.out.println(version);
                ArrayList<CinBody> bodys = response.getBodys();
                for (CinBody cinBody : bodys) {
                    byte[] values = cinBody.getValue();
                    CinMessage data = CinMessageReader.parse(values);
                    String fileid = data.getHeader((byte) 0x04).getString();
                    long fileSize = data.getHeader((byte) 0x05).getInt64();
                    String filepath = data.getHeader((byte) 0x06).getString();
                    int id = (int) data.getHeader((byte) 0x01).getInt64();
                    int sort = (int) data.getHeader((byte) 0x02).getInt64();
                    byte flag = (byte) data.getHeader((byte) 0x03).getInt64();
                    System.out.println("id:" + id + "   sort:" + sort + "flag:" + flag);
                }
                System.out.println(response.toString());
                System.exit(0);
            }
        };
        trans.SendRequest();
        Thread.sleep(5 * 60 * 1000);
    }

}
