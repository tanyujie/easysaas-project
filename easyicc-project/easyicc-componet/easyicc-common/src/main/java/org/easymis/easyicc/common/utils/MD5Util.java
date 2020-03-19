package org.easymis.easyicc.common.utils;


import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class MD5Util {

    private static final String HEX_DIGITS[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
            return resultSb.toString();
        }

        private static String byteToHexString ( byte b){
            int n = b;
            if (n < 0) {
                n += 256;
            }
            int d1 = n / 16;
            int d2 = n % 16;
            return HEX_DIGITS[d1] + HEX_DIGITS[d2];
        }

        public static String MD5Encode (String origin, String charsetname){
            String resultString = null;
            try {
                resultString = new String(origin);
                MessageDigest md = MessageDigest.getInstance("MD5");
                if (charsetname == null || "".equals(charsetname)) {
                    resultString = byteArrayToHexString(md.digest(resultString
                            .getBytes()));
                }else {
                    resultString = byteArrayToHexString(md.digest(resultString
                            .getBytes(charsetname)));
                }
            } catch (Exception exception) {
            }
            return resultString;
        }

        /**
         * 请求参数签名验证
         *
         * @param appSecret
         * @param request
         * @return true 验证通过 false 验证失败
         * @throws Exception
         */
   /* public static boolean verifySign(String appSecret, HttpServletRequest request) throws Exception {
        TreeMap<String, String> params = new TreeMap<String, String>();

        String signStr = request.getParameter("sign");
        if (StringUtils.isBlank(signStr)) {
            throw new RuntimeException("There is no signature field in the request parameter!");
        }

        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paramName = enu.nextElement().trim();
            if (!paramName.equals("sign")) {
                params.put(paramName, request.getParameter(paramName));
//	                params.put(paramName, URLDecoder.decode(request.getParameter(paramName), "UTF-8"));
            }
        }

        log.info("前端加密结果：" + signStr);
        if (!sign(appSecret, params).equals(signStr)) {
            return false;
        }
        return true;
    }*/

        /**
         * md5签名
         * <p>
         * 按参数名称升序，将参数值进行连接 签名
         *
         * @param appSecret
         * @param params
         * @return
         */
        public static String sign (String appSecret, TreeMap < String, String > params) throws Exception {
            StringBuilder paramValues = new StringBuilder();
            params.put("appSecret", appSecret);

            for (Map.Entry<String, String> entry : params.entrySet()) {
                paramValues.append(entry.getKey() + "=" + entry.getValue() + "&");

            }
            log.info("加密前字符串：" + paramValues.toString());
            String paramValue = paramValues.toString() + "key=vu2ZZPmj";
            log.info("加密后字符串：" + md5(paramValue));
            log.info("处理后要加密的字符串：" + paramValue);
            return md5(paramValue);
        }

        public static void main (String[]args){
            TreeMap<String, String> params = new TreeMap<String, String>();
            params.put("appSecret", "md5");
            params.put("access_token", "bbed394d-77c1-4c09-9dca-134da280e21e");

            params.put("currentPageNum", "1");
            params.put("pageCount", "4");
            try {
                System.out.println(sign("md5", params));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        public static String md5 (String string){
            byte[] hash;
            try {
                hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 is unsupported", e);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MessageDigest不支持MD5Util", e);
            }
            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 0xFF) < 0x10){
                    hex.append("0");
                }
                hex.append(Integer.toHexString(b & 0xFF));
            }
            return hex.toString();
        }


    }
