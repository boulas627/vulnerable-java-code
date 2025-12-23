
package com.example.vulnapp.util;

public class CommandUtil {
    public static String ping(String host) throws Exception {

        // The code in the line below is a command injection vulnerability. The variable host is user controlled
        Process p = Runtime.getRuntime().exec("ping -c 1 " + host);
        return new String(p.getInputStream().readAllBytes());
    }
}
