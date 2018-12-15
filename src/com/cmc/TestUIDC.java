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
import com.allstar.event.CinSDKInterfaceServerEvent;

public class TestUIDC {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		CinRequest req = new CinRequest(CinRequestMethod.SdkInterfaceServer);
		req.addHeader(new CinHeader(CinHeaderType.Event, CinSDKInterfaceServerEvent.CheckAcountPassword));
		req.addHeader(new CinHeader(CinHeaderType.From, 700003669l));
		req.addHeader(new CinHeader(CinHeaderType.Password, "e1fdb83bc91abca6368c4afd36a8ce53"));
		req.addHeader(new CinHeader(CinHeaderType.Name, "13300133555"));
		req.addHeader(new CinHeader(CinHeaderType.Channel_ID, "2000"));
		req.addHeader(new CinHeader(CinHeaderType.Index, "972738"));
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",8666);
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
