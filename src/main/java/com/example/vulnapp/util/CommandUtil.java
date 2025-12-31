
package com.example.vulnapp.util;

public class CommandUtil {
    public static String ping(String host) throws Exception {

        if (!host.matches("^[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid host");
        }
        
        Process p = new ProcessBuilder(
            "ping", "-c", "1", host
            ).start(); 

        return new String(p.getInputStream().readAllBytes());
    }
}
