//package com.baoanh.selfpasswordmanagement.config;
//
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.json.jackson.JacksonJsonpMapper;
//import co.elastic.clients.transport.ElasticsearchTransport;
//import co.elastic.clients.transport.rest_client.RestClientTransport;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.apache.http.ssl.SSLContexts;
//import org.elasticsearch.client.RestClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.net.ssl.SSLContext;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.security.KeyManagementException;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.Certificate;
//import java.security.cert.CertificateException;
//import java.security.cert.CertificateFactory;
//
//@Configuration
//public class ElasticConfig {
//
//    private static final String ELASTIC_USERNAME = System.getenv("ELASTIC_USERNAME") == null ? "elastic" : System.getenv("ELASTIC_USERNAME");
//    private static final String ELASTIC_PASSWORD = System.getenv("ELASTIC_PASSWORD") == null ? "elastic" : System.getenv("ELASTIC_PASSWORD");
//    private static final String ELASTIC_HOST = System.getenv("ELASTIC_HOST") == null ? "localhost" : System.getenv("ELASTIC_HOST");
//    @Bean
//    public ElasticsearchClient esClient() throws CertificateException
//            , KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException {
//        final CredentialsProvider credentialsProvider =
//                new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials(ELASTIC_USERNAME, ELASTIC_PASSWORD));
//        Path caCertificatePath = Paths.get("/home/baoanh/custom_http_ca.crt");
//        CertificateFactory factory =
//                CertificateFactory.getInstance("X.509");
//        Certificate trustedCa;
//        try (InputStream is = Files.newInputStream(caCertificatePath)) {
//            trustedCa = factory.generateCertificate(is);
//        } catch (CertificateException | IOException e) {
//            throw new RuntimeException(e);
//        }
//        KeyStore trustStore = KeyStore.getInstance("pkcs12");
//        trustStore.load(null, null);
//        trustStore.setCertificateEntry("ca", trustedCa);
//        SSLContextBuilder sslContextBuilder = SSLContexts.custom()
//                .loadTrustMaterial(trustStore, null);
//        final SSLContext sslContext = sslContextBuilder.build();
//        RestClient restClient = RestClient.builder(
//                        new HttpHost(ELASTIC_HOST, 9200, "https")).setHttpClientConfigCallback(
//                        httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider).setSSLContext(sslContext))
//                .build();
//        ElasticsearchTransport transport = new RestClientTransport(
//                restClient,
//                new JacksonJsonpMapper()
//        );
//        return new ElasticsearchClient(transport);
//    }
//
//}
