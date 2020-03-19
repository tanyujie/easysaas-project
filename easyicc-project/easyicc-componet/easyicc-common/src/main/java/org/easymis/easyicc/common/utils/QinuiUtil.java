package org.easymis.easyicc.common.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;
import com.qiniu.util.UrlSafeBase64;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * Created by leo on 2019/3/7.
 */
@Slf4j
public class QinuiUtil {

    // public static String WATERMARK = "imageView2/0/q/75|watermark/1/image/aHR0cDovL3hzYmltYWdlcy5zaGFyZXBhbnplci5jb20vL2NvbXBhbnlJbmZvV2F0ZXJtYXJrLnBuZw==/dissolve/100/gravity/Center/dx/10/dy/10";
    static String accessKey = "cXaPsRZIRyeZk_oBxq6Z3i-JiyxQEzXW_SXQ2Q-s";
    static String secretKey = "nwVmudzufv1YUbUKHS2c_S0nkOVuCBYO3vJ4BpHI";
    static String bucket = "excel1";

    //...生成上传凭证，然后准备上传
    public static String uploadFile(byte[] uploadBytes, String fileName) throws UnsupportedEncodingException {
        String file_url = "";
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.huabei());
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);


        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        //uploadBytes = "hello qiniu cloud".getBytes("utf-8");
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(uploadBytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            if (response.statusCode == 200) {
                MyPutRet myPutRet = response.jsonToObject(MyPutRet.class);
                file_url = myPutRet.key;
            }
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return file_url;
    }

    /**
     * 下载签名
     *
     * @param baseUrl 待签名文件url，如 http://img.domain.com/u/3.jpg 、
     *                http://img.domain.com/u/3.jpg?imageView2/1/w/120
     * @return
     */
    public static  String privateDownloadUrl(String baseUrl) {
        return privateDownloadUrl(baseUrl, 3600);
    }

    /**
     * 下载签名
     *
     * @param baseUrl 待签名文件url，如 http://img.domain.com/u/3.jpg 、
     *                http://img.domain.com/u/3.jpg?imageView2/1/w/120
     * @param expires 有效时长，单位秒。默认3600s
     * @return
     */
    public  static  String privateDownloadUrl(String baseUrl, long expires) {
        long deadline = System.currentTimeMillis() / 1000 + expires;
        return privateDownloadUrlWithDeadline(baseUrl, deadline);
    }

    public  static  String privateDownloadUrlWithDeadline(String baseUrl, long deadline) {
        StringBuilder b = new StringBuilder();
        b.append(baseUrl);
        int pos = baseUrl.indexOf("?");
        if (pos > 0) {
            b.append("&e=");
        } else {
            b.append("?e=");
        }
        b.append(deadline);
        String token = sign(StringUtils.utf8Bytes(b.toString()));
        b.append("&token=");
        b.append(token);
        return b.toString();
    }

    public static  String sign(byte[] data) {
        Mac mac = createMac();
        String encodedSign = UrlSafeBase64.encodeToString(mac.doFinal(data));
        return accessKey + ":" + encodedSign;
    }

    private static  Mac createMac() {
        Mac mac;
        try {
            byte[] sk = StringUtils.utf8Bytes(secretKey);
            SecretKeySpec secretKeySpec = new SecretKeySpec(sk, "HmacSHA1");
            mac = javax.crypto.Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
        return mac;
    }

    public static byte[] downloadFile(String qiniuAddress) throws IOException {
        byte[] bytes =null;
        String url = privateDownloadUrl(qiniuAddress);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient build = HttpClients.custom().build();
        CloseableHttpResponse httpResponse = build.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        log.info("http client execute statusCode  -->{}", statusCode);
        if (statusCode == 200) {
            HttpEntity httpEntity = httpResponse.getEntity();
            bytes = EntityUtils.toByteArray(httpEntity);
        }
        httpResponse.close();
        build.close();
        return bytes;

    }


    class MyPutRet {
        public String key;
        public String hash;
        public String bucket;
        public long fsize;
    }

    public static void main(String[] args) throws IOException {
      /*  FileInputStream inputStream = new FileInputStream("C:\\Users\\kyle\\Desktop\\Desktop\\云南省.xlsx");
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        uploadFile(buffer, "10001323.xlsx");*/
        byte[] bytes = downloadFile("http://file.gde.ink/10001323.xlsx");
        FileOutputStream outputStream = new FileOutputStream("D:\\云南省.xlsx");
        outputStream.write(bytes);


    }
}
