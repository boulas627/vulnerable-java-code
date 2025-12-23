
package com.example.vulnapp.util;

import java.io.*;

public class DeserializeUtil {
    public static Object deserialize(byte[] data) throws Exception {

        // The line of code down below shows potential command injection due to the data field being user controlled. Deserializing data without proper sanitization could be reckless here. 
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return ois.readObject();
    }
}
