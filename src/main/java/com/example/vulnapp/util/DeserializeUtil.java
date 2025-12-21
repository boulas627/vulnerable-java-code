
package com.example.vulnapp.util;

import java.io.*;

public class DeserializeUtil {
    public static Object deserialize(byte[] data) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return ois.readObject();
    }
}
