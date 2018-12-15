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

public class GeneralSettingsHandler {

	public static void main(String[] args) throws Exception {
		CinRequest req = new CinRequest(CinRequestMethod.Service);
		req.addHeader(new CinHeader(CinHeaderType.Event, CinServiceEvent.GeneralSettings));
		req.addHeader(new CinHeader(CinHeaderType.From, 100000000L));
		req.addHeader(new CinHeader(CinHeaderType.Type, 0));
		
		/*req.addHeader(new CinHeader(CinHeaderType.Status, 0));
		CinMessage msg = new CinMessage((byte)0x01);
		msg.addHeader(new CinHeader((byte)0x04,"haha"));
		msg.addHeader(new CinHeader((byte)0x05,12345667l));
		msg.addHeader(new CinHeader((byte)0x06,"hahaha"));
		req.addBody(msg.toBytes());*/
		
		req.addHeader(new CinHeader(CinHeaderType.Status, 1));
		req.addHeader(new CinHeader(CinHeaderType.Key, 4));
		
		
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
				long int64 = response.getHeader(CinHeaderType.Version).getInt64();
				System.exit(0);
			}
		};
		trans.SendRequest();
		Thread.sleep(5 * 60 * 1000);
	}


}
