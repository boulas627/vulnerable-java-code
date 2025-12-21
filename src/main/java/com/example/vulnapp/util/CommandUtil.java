
package com.example.vulnapp.util;

public class CommandUtil {
    public static String ping(String host) throws Exception {
        Process p = Runtime.getRuntime().exec("ping -c 1 " + host);
        return new String(p.getInputStream().readAllBytes());
    }
}
