package org.easymis.easysaas.crm.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 二维码工具
 * @author wangkai
 */
public class QrCodeUtil {

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static Pattern CRLF = Pattern.compile("(\r\n|\r|\n)");

    /**
     * 将生成的二维码图片转化为base64编码
     */
	public static String toBase64(String content,int width,int height){
		String qrCodeBase64 = null;
    	try{
			Map hint = new HashMap();
			hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			hint.put(EncodeHintType.CHARACTER_SET, DEFAULT_CHARSET);
			BitMatrix bitMatrix = new MultiFormatWriter().encode(new String(content.getBytes(DEFAULT_CHARSET), DEFAULT_CHARSET), BarcodeFormat.QR_CODE, width, height, hint);

			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
				}
			}

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(image,"png",byteArrayOutputStream);
			byte[] data = byteArrayOutputStream.toByteArray();
			byteArrayOutputStream.flush();
			byteArrayOutputStream.close();
			BASE64Encoder base64 = new BASE64Encoder();
			qrCodeBase64 = base64.encode(data);
			Matcher m = CRLF.matcher(qrCodeBase64);
			if (m.find()) {
				qrCodeBase64 = m.replaceAll("");
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return qrCodeBase64;
	}
}
