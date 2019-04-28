package com.cmc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestREG {

    public static final String REG_LOGINNAME = "^[a-zA-Z0-9-_.\\@]*$";
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z_]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean regLoginName(String str) {
        return Pattern.compile(REGEX_USERNAME).matcher(str).matches();
    }

    public static final String REGEX_USERNAME = "^[a-zA-Z0-9-_.\\@]*$";

    public static void main(String[] args) {
        String name = " sh_zhuyao_900";
        boolean regLoginName = TestREG.regLoginName(name);
        System.out.println(regLoginName + "");
        /*
         * String name = "z_hang_900"; boolean regLoginName =
         * TestREG.checkEmail(name); System.out.println(regLoginName + "");
         */

        // public static final String REGEX_USERNAME = "^[A-Za-z]+(_9)\\d{2}$";

    }

    public static boolean checkEmail(String email) {
        Pattern regex = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }
}
