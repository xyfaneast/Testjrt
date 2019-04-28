package com.cmc;

import java.net.InetSocketAddress;

import com.allstar.cinconnection.CinStack;
import com.allstar.cintransaction.CinTransaction;
import com.allstar.cintransaction.CinTransactionEvent;
import com.allstar.cintransaction.cinmessage.CinBody;
import com.allstar.cintransaction.cinmessage.CinHeader;
import com.allstar.cintransaction.cinmessage.CinHeaderType;
import com.allstar.cintransaction.cinmessage.CinRequest;
import com.allstar.cintransaction.cinmessage.CinRequestMethod;
import com.allstar.cintransaction.cinmessage.CinResponse;

public class TestMUOP {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        CinRequest req = new CinRequest(CinRequestMethod.Message);
        req.addHeader(new CinHeader(CinHeaderType.Event, 0x01));
        req.addHeader(new CinHeader(CinHeaderType.From, 100000217l));
        req.addHeader(new CinHeader(CinHeaderType.To, 100000218l));
        req.addHeader(new CinHeader(CinHeaderType.MessageID, 0X386596));
        // req.addHeader(new CinHeader(CinHeaderType.Encrypt, 0X0));
        req.addHeader(new CinHeader(CinHeaderType.Type, 14));
        // req.addHeader(new CinHeader(CinHeaderType.CallId, 5689));
        req.addHeader(new CinHeader((byte) 0x22, 1026));
        req.addHeader(new CinHeader((byte) 0x23, "1026"));
        req.addHeader(new CinHeader((byte) 0x08, "1026"));
        req.addHeader(new CinHeader((byte) 0x09, "1026"));
        req.addHeader(new CinHeader((byte) 0x0C, "1026"));
        req.addHeader(new CinHeader((byte) 0x10, "1026"));
        req.addHeader(new CinHeader((byte) 0x14, "1026"));
        req.addHeader(new CinHeader((byte) 0x18, "1026"));
        req.addHeader(new CinHeader((byte) 0xE1, "1026"));
        req.addHeader(new CinHeader((byte) 0xE2, "1026"));
        req.addHeader(new CinHeader((byte) 0x1D, "1026"));
        req.addHeader(new CinHeader((byte) 0x21, "1026"));
        req.addHeader(new CinHeader((byte) 0x46, "1026"));
        // req.addHeader(new CinHeader(CinHeaderType.Fpid, "972737"));
        // req.addHeader(new CinHeader(CinHeaderType.Index, "972738"));
        req.addBody(new CinBody("111111"));
        req.addBody(new CinBody("211111"));
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8081);
        /*
         * CinRequest req = new CinRequest(CinRequestMethod.Group);
         * req.addHeader(new CinHeader(CinHeaderType.Event, 4));
         * req.addHeader(new CinHeader(CinHeaderType.From, 100000218l));
         * req.addHeader(new CinHeader(CinHeaderType.To, 900000001418l)); //
         * req.addHeader(new CinHeader(CinHeaderType.Key, 100000218l));
         * req.addHeader(new CinHeader(CinHeaderType.Version, 1)); //
         * req.addHeader(new CinHeader(CinHeaderType.Index, "972738"));
         * InetSocketAddress address = new InetSocketAddress("127.0.0.1",8888);
         */
        CinStack.initialize();
        CinTransaction trans = CinStack.instance().createTransaction(address, req);
        System.out.println(req.toString());
        trans.TransactionEvent = new CinTransactionEvent() {

            @Override
            public void onTimeout(CinTransaction trans) {
                System.out.println("timeout");
                System.exit(0);
            }

            @Override
            public void onSendFailed(CinTransaction trans) {
                System.out.println("Error");
                System.out.println(trans.toString());
                System.exit(0);
            }

            @Override
            public void onResponseReceived(CinTransaction trans, CinResponse response) {
                System.out.println(response.toString());
                System.exit(0);
            }
        };
        trans.SendRequest();
        Thread.sleep(5 * 60 * 1000);
    }

}
