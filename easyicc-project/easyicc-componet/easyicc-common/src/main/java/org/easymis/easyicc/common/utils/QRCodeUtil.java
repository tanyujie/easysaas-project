package org.easymis.easyicc.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;


/**
 * <p>Title:QRCodeUtil </p>
 * <p>Description:二维码生成工具类 </p>
 *
 * @Copyright:Copyright (c) 2015
 * @Author:PJJ
 * @Version:1.0
 * @date 2016年6月29日 下午2:43:06
 * @since JDK 1.7
 */
public class QRCodeUtil {
    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸  
    private static final int QRCODE_SIZE = 200;

    /**
     * 生成二维码()
     *
     * @param content      内容
     * @param imgPath      LOGO地址
     * @param destPath     存储地址
     * @param needCompress 是否压缩LOGO
     * @throws Exception
     */
    public static File encode(String content, String imgPath, String destPath, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
        new File(imgPath).mkdir();
        ImageIO.write(image, FORMAT_NAME, new File(imgPath));
        return new File(imgPath);
    }

    public static BufferedImage createImage(String content, String imgPath,
                                            boolean needCompress) throws WriterException {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
        return image;
    }


    /**
     * @param qrCodeFile  生成二维码路径  /home/deploy/
     * @param productId 生成二维码产品id
     * @param content   生成二维码地址  一般为 http://www.dspt.com/product.html?id=111111;
     *                  2015年10月26日
     *                  time下午2:53:48
     *                  hulp
     * @throws Exception
     */
    public static File createQRCode(String qrCodeFile, String productId, String content) {
        try {
            File f = encode(content, qrCodeFile, "", true);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
