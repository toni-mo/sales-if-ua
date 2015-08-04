package sales.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * Created by taras on 28.07.15.
 */
public class StringToMd5 {
    final static Logger logger = LoggerFactory.getLogger(StringToMd5.class);

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
}
