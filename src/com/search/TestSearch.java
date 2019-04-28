package com.search;

import java.net.URL;

import com.allstar.cintransaction.cinmessage.CinMessage;
import com.allstar.cintransaction.cinmessage.CinMessageReader;
import com.allstar.crypto.CinBase64;
import com.allstar.http.HttpClient;
import com.allstar.http.common.HttpResponseReceived;
import com.allstar.http.message.HttpMethod;
import com.allstar.http.message.HttpRequest;
import com.allstar.http.message.HttpResponse;

public class TestSearch {

    public static void main(String[] args) throws Exception {
        HttpRequest req = new HttpRequest(HttpMethod.GET, new URL(
                "http://localhost:8889/queryEmployeeForSearch?userid=1158781&eid=2000&searcheName=shayi&gzip=1&token=queryEmployeeForSearch"));

        HttpClient.getInstance().sendRequest(req, new HttpResponseReceived() {

            @Override
            public void onResponseReceived(HttpResponse response) {
                // TODO Auto-generated method stub
                System.out.println("response.getBody():" + response.getBody());
                try {
                    String content = new String(response.getBody().array(), "UTF-8");

                    if (content.contains(";")) {
                        content = content.substring(0, content.lastIndexOf(";") + 1);
                    }
                    CinMessage msg = CinMessageReader.parse(CinBase64.decode(content.trim()));

                    System.out.println("Resp Ok:" + msg.toString());

                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            @Override
            public void onTimeout(HttpRequest request) {
                // TODO Auto-generated method stub
                System.out.println("BaseRegisterHandler:Time out");

            }

        });

    }

}
