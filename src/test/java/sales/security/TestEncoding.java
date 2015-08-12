package sales.security;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by taras on 12.08.15.
 */
public class TestEncoding {

    @Test
    public void testEncode() {
        Assert.assertEquals(Encoding.getDecoded(Encoding.getEncoded("lol")), "lol");
    }
}
