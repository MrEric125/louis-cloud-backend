package com.louis;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
public class IpTest {


    @Test
    public void testGetIp() {

        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostAddress = localHost.getHostAddress();
            String property = System.getProperty("os.name");
            String version = System.getProperty("os.version");
            System.out.println(version);

            System.out.println(property);
            System.out.println(hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
