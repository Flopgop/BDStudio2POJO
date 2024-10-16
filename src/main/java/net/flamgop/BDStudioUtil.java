package net.flamgop;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class BDStudioUtil {
    public static BDStudio bdStudio2POJO(String input) {
        byte[] decoded = Base64.getDecoder().decode(input);
        String decompressed = new String(decompress(decoded));
        decompressed = decompressed.substring(1, decompressed.length()-1); // hacky way of removing the enclosing array which is a byproduct of javascript serialization

        Gson gson = new Gson();
        return gson.fromJson(decompressed, BDStudio.class);
    }

    private static byte[] decompress(byte[] bytes) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GZIPInputStream gzin = new GZIPInputStream(new ByteArrayInputStream(bytes))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzin.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }
}