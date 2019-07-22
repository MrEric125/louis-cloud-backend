package com.louis;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;



/**
 * @author John·Louis
 * @date create in 2019/7/10
 * description:
 */
public class TransportClientInit {

    private static Settings settings = Settings.builder().build();

    public static final String INDEX = "create_by_ava";

    public static TransportClient init() {
        TransportClient client = null;

      /*  try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress
                            (InetAddress.getByName("129.28.189.234"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }*/
        return client;

    }
}
