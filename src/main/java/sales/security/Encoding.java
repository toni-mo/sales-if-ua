package sales.security;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * Created by taras on 28.07.15.
 */
public class Encoding {
    final static Logger logger = LoggerFactory.getLogger(Encoding.class);

    public static String getMd5(String original) throws Exception {
        logger.debug("Converting string to hash using md5");
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digets = md.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b: digets) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
    }

    public static String getEncoded(String data) {
        logger.info("Encoding \"" + data +"\"");
        byte[] encodedBytes = Base64.encodeBase64(data.getBytes());
        String encoded = new String(encodedBytes);
        logger.info("encodedBytes: " + encoded);
        return encoded;
    }

    public static String getDecoded(String data) {
        logger.info("Decoding \"" + data +"\"");
        byte[] decodedBytes = Base64.decodeBase64(data.getBytes());
        String decoded = new String(decodedBytes);
        logger.info("decodedBytes: " + decoded);
        return decoded;
    }
}
