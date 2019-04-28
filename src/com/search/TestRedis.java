package com.search;

import com.allstar.JedisUtil;
import com.allstar.cintransaction.cinmessage.CinMessage;
import com.allstar.cintransaction.cinmessage.CinMessageReader;

public class TestRedis {

    public static void main(String[] args) {
        byte[] profile = JedisUtil.getProfile(772335045l);
        CinMessage userprofile = CinMessageReader.parse(profile);
        // String portraitUrl =
        // userprofile.getHeader(CinUserProfile.portraitUrl).getString();
        // System.err.println(portraitUrl);
        System.out.println(userprofile.toString());
    }
}
