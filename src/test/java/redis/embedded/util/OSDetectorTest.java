package redis.embedded.util;

import org.junit.Assert;
import org.junit.Test;
import redis.embedded.exceptions.OsDetectionException;

public class OSDetectorTest {

    @Test
    public void getOS() {
        System.setProperty("os.name", "unix");
        Assert.assertEquals(OS.UNIX, OSDetector.getOS());

        System.setProperty("os.name", "win");
        Assert.assertEquals(OS.WINDOWS, OSDetector.getOS());

        System.setProperty("os.name", "Mac OS X");
        Assert.assertEquals(OS.MAC_OS_X, OSDetector.getOS());
    }

    @Test(expected = OsDetectionException.class)
    public void invalidOS() {
        System.setProperty("os.name", "bestOSInTheWorld");
        OSDetector.getOS();
    }
}
