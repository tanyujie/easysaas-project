package org.easymis.easyicc.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@SuppressWarnings("deprecation")
@Slf4j
public class HttpsUtils {

    public static String doPost(String url, String contextXml,
                                String charset) {
        SSLContextBuilder builder = new SSLContextBuilder();

        HttpClient httpclient = null;
        String result = null;
        HttpPost post = null;
        HttpResponse httpResponse = null;
        //加载信任材料
        try {
            //信任自签名策略
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            //创建 ssl connection socket
            SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(builder.build());
            //自动关闭连接 CloseableHttpClient
            httpclient = HttpClients.custom().setSSLSocketFactory(sslFactory).build();
            post = new HttpPost(url);
            post.addHeader("charset", charset);
            post.addHeader("Content-Type", "application/xml");
               /*  HttpMethodParams httpMethodParams =new HttpMethodParams();
                 httpMethodParams.setContentCharset(charset);*/
            StringEntity entity = new StringEntity(contextXml, "application/xml", charset);
            post.setEntity(entity);
            httpResponse = httpclient.execute(post);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            log.info("http client execute statusCode  -->{}", statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity, charset);
                log.info("http client execute result ->{}", result);
            }


        } catch (NoSuchAlgorithmException e) {
            log.error("创建ssl httpclient 异常 ->", e);
        } catch (KeyStoreException e) {
            log.error("创建ssl httpclient 异常 ->", e);
        } catch (KeyManagementException e) {
            log.error("创建ssl httpclient 异常 ->", e);
        } catch (UnsupportedEncodingException e) {
            log.error("设定 requestbody charset 异常 ->", e);
        } catch (ClientProtocolException e) {
            log.error("http client execute 异常 -> ", e);
        } catch (IOException e) {
            log.error("http client execute 异常 -> ", e);
        } finally {

        }


        return result;
    }

    public static void main(String[] args) {
        doPost("https://api.mch.weixin.qq.com/pay/unifiedorder", "", HTTP.UTF_8);
    }

}
