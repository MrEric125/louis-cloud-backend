package com.louis.httpClient;

import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.config.*;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.impl.io.DefaultHttpResponseParserFactory;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.nio.charset.CodingErrorAction;

/**
 * @author louis
 * <p>
 * Date: 2019/7/23
 * Description:
 * to see
 * http://hc.apache.org/httpcomponents-client-4.5.x/httpclient/examples/org/apache/http/examples/client/ClientConfiguration.java
 */
public class ClientConfiguration {

    public static void main(String[] args) {
        HttpMessageParserFactory<HttpResponse> responseFactory = new DefaultHttpResponseParserFactory();
        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();
        ManagedHttpClientConnectionFactory connectionFactory = new ManagedHttpClientConnectionFactory(requestWriterFactory, responseFactory);
        SSLContext sslcontext = SSLContexts.createDefault();
        Registry<ConnectionSocketFactory> factoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();
        DnsResolver dnsResolver = new SystemDefaultDnsResolver();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(factoryRegistry, connectionFactory, dnsResolver);

        SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
        connectionManager.setDefaultSocketConfig(socketConfig);
        connectionManager.setSocketConfig(new HttpHost("somehost", 80), socketConfig);
        connectionManager.setValidateAfterInactivity(1000);
        MessageConstraints messageConstraints = MessageConstraints
                .custom()
                .setMaxHeaderCount(200)
                .setMaxLineLength(2000)
                .build();
        ConnectionConfig connectionConfig = ConnectionConfig
                .custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8)
                .setMessageConstraints(messageConstraints)
                .build();
        connectionManager.setDefaultConnectionConfig(connectionConfig);
        connectionManager.setConnectionConfig(new HttpHost("somehost", 80), ConnectionConfig.DEFAULT);


    }
}
