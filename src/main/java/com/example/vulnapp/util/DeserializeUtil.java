
package com.example.vulnapp.util;

import java.io.*;

public class DeserializeUtil {
    public static Object deserialize(byte[] data) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));

        # the code fixes below assume that serialization is absolutely required. Ideally, we would avoid it entirely

        ObjectInputFilter filter = ObjectInputFilter.Config.createFilter(
            "com.example.vulnapp.model.*;java.base/*;!*"
        );

        ois.setObjectInputFilter(filter);
        
        return ois.readObject();
    }
}
