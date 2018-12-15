package com.cmc;

import java.net.InetSocketAddress;

import com.allstar.cinconnection.CinStack;
import com.allstar.cintransaction.CinTransaction;
import com.allstar.cintransaction.CinTransactionEvent;
import com.allstar.cintransaction.cinmessage.CinHeader;
import com.allstar.cintransaction.cinmessage.CinHeaderType;
import com.allstar.cintransaction.cinmessage.CinMessage;
import com.allstar.cintransaction.cinmessage.CinRequest;
import com.allstar.cintransaction.cinmessage.CinRequestMethod;
import com.allstar.cintransaction.cinmessage.CinResponse;
import com.allstar.event.CinServiceEvent;

public class GeneralSettingsSortHandler {

	public static void main(String[] args) throws Exception {
		CinRequest req = new CinRequest(CinRequestMethod.Service);
		req.addHeader(new CinHeader(CinHeaderType.Event, CinServiceEvent.GeneralSettingsSort));
		req.addHeader(new CinHeader(CinHeaderType.From, 100000000l));
		req.addHeader(new CinHeader(CinHeaderType.Type, 0));
		
		CinMessage msg = new CinMessage((byte)0x01);
		CinHeader header10 = new CinHeader((byte)0x01, 1);
		msg.addHeader(header10);
		CinHeader header11 = new CinHeader((byte)0x02, 2);
		msg.addHeader(header11);
		req.addBody(msg.toBytes());
		
		CinMessage msg2 = new CinMessage((byte)0x01);
		CinHeader header20 = new CinHeader((byte)0x01, 2);
		msg2.addHeader(header20);
		CinHeader header21 = new CinHeader((byte)0x02, 3);
		msg2.addHeader(header21);
		req.addBody(msg2.toBytes());
		
		CinMessage msg3 = new CinMessage((byte)0x01);
		CinHeader header30 = new CinHeader((byte)0x01, 3);
		msg3.addHeader(header30);
		CinHeader header31 = new CinHeader((byte)0x02, 1);
		msg3.addHeader(header31);
		req.addBody(msg3.toBytes());
		
		
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",6005);
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
				System.out.println(response.toString());
				System.exit(0);
			}
		};
		trans.SendRequest();
		Thread.sleep(5 * 60 * 1000);
	}

}
