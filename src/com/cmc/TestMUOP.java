package com.cmc;

import java.net.InetSocketAddress;

import com.allstar.cinconnection.CinStack;
import com.allstar.cintransaction.CinTransaction;
import com.allstar.cintransaction.CinTransactionEvent;
import com.allstar.cintransaction.cinmessage.CinHeader;
import com.allstar.cintransaction.cinmessage.CinHeaderType;
import com.allstar.cintransaction.cinmessage.CinRequest;
import com.allstar.cintransaction.cinmessage.CinRequestMethod;
import com.allstar.cintransaction.cinmessage.CinResponse;
import com.allstar.event.CinGroupEvent;

public class TestMUOP {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		/*CinRequest req = new CinRequest(CinRequestMethod.Group);
		req.addHeader(new CinHeader(CinHeaderType.Event, CinGroupEvent.MUOPCreateGroup));
		req.addHeader(new CinHeader(CinHeaderType.From, 700003669l));
		req.addHeader(new CinHeader(CinHeaderType.Type, "test"));
		req.addHeader(new CinHeader(CinHeaderType.Name, "testgroup"));
		req.addHeader(new CinHeader(CinHeaderType.Index, "972737"));
		req.addHeader(new CinHeader(CinHeaderType.Index, "972738"));
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",6008);*/
		CinRequest req = new CinRequest(CinRequestMethod.Group);
		req.addHeader(new CinHeader(CinHeaderType.Event, 4));
		req.addHeader(new CinHeader(CinHeaderType.From, 100000218l));
		req.addHeader(new CinHeader(CinHeaderType.To, 900000001418l));
//		req.addHeader(new CinHeader(CinHeaderType.Key, 100000218l));
		req.addHeader(new CinHeader(CinHeaderType.Version, 1));
//		req.addHeader(new CinHeader(CinHeaderType.Index, "972738"));
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",8888);
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
