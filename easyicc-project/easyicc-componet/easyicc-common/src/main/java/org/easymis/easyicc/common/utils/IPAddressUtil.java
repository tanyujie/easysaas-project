package org.easymis.easyicc.common.utils;


public class IPAddressUtil {

    public static byte[] textToNumericFormatV4(String var0) {
        byte[] var1 = new byte[4];
        long var2 = 0L;
        int var4 = 0;
        boolean var5 = true;
        int var6 = var0.length();
        if (var6 != 0 && var6 <= 15) {
            for (int var7 = 0; var7 < var6; ++var7) {
                char var8 = var0.charAt(var7);
                if (var8 == '.') {
                    if (var5 || var2 < 0L || var2 > 255L || var4 == 3) {
                        return null;
                    }

                    var1[var4++] = (byte) ((int) (var2 & 255L));
                    var2 = 0L;
                    var5 = true;
                } else if (var8 == '*' && (var4 == 3 || var4 == 4)) {
                    var1[var4++] = '*';
                } else {
                    int var9 = Character.digit(var8, 10);
                    if (var9 < 0) {
                        return null;
                    }

                    var2 *= 10L;
                    var2 += (long) var9;
                    var5 = false;
                }
            }


        } else {
            return null;
        }

        return var1;
    }

    public static boolean isIPv4LiteralAddress(String var0) {
        return textToNumericFormatV4(var0) != null;
    }


    public static void main(String[] args) {
        System.out.println(textToNumericFormatV4("123.2.255.*"));
    }
}
