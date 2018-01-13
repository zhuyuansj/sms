package com.paic.loancloud.sms.util;

import org.apache.commons.lang3.RandomUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by sunjian on 2017/4/2.
 */
public class CaptchaUtil {
    public static String[] CaptchImageIO(Integer WIDTH, Integer HEIGHT, Integer CODE_COUNT, String IMAGE_TYPE) {
        Integer FONT_HEIGHT = HEIGHT - 2;
        Integer LINE_COUNT = 20;
        Integer CODE_X = WIDTH / (CODE_COUNT + 2);
        Integer CODE_Y = HEIGHT - 4;
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Font font = new Font("Fixedsys", Font.BOLD, FONT_HEIGHT);

        Graphics graphics = initialPortrait(WIDTH, HEIGHT, LINE_COUNT, font, bufferedImage);
        StringBuffer randomCode = WritePicture(CODE_COUNT, CODE_X, CODE_Y, graphics);
        ByteArrayOutputStream out = OutputImage(IMAGE_TYPE, bufferedImage);
        byte[] bytes = out.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        return new String[]{encoder.encode(bytes), randomCode.toString()};//返回Base64编码过的字节数据字符串
    }




    private static StringBuffer WritePicture(Integer CODE_COUNT, Integer CODE_X, Integer CODE_Y, Graphics graphics) {
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        Random random = new Random();
        for (int i = 0; i < CODE_COUNT; i++) {
            String code = com.paic.loancloud.sms.util.RandomUtils.generateString(i);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            graphics.setColor(new Color(red, green, blue));
            graphics.drawString(code, (i + 1) * CODE_X, CODE_Y);
            randomCode.append(code);
        }
        return randomCode;
    }

    private static ByteArrayOutputStream OutputImage(String IMAGE_TYPE, BufferedImage bufferedImage) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Boolean flag = ImageIO.write(bufferedImage,IMAGE_TYPE,out);
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return out;
    }

    private static Graphics initialPortrait(Integer WIDTH, Integer HEIGHT, Integer LINE_COUNT, Font font, BufferedImage bufferedImage) {
            Graphics graphics = bufferedImage.getGraphics();
            graphics.setFont(font);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0,0,WIDTH,HEIGHT);
            graphics.setColor(Color.BLACK);
            graphics.drawRect(0,0,WIDTH,HEIGHT);
            graphics.setColor(Color.BLACK);
            makeBlankPicture(WIDTH,HEIGHT,LINE_COUNT,graphics);
            return graphics;
    }

    private static void makeBlankPicture(Integer WIDTH, Integer HEIGHT, Integer LINE_COUNT, Graphics graphics) {
            Random random = new Random();
            for(int i = 0 ; i< LINE_COUNT ; i++){
                int x = random.nextInt(WIDTH);
                int y = random.nextInt(HEIGHT);
                int xl = random.nextInt(12);
                int yl = random.nextInt(12);
                graphics.drawLine(x,y,x + xl,y + yl);
            }
    }

    public static boolean generateImage(String imgStr,String imgFilePath){//对字节数组字符串进行Base64解码并生成图片
        if(imgStr == null){
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0 ; i<bytes.length ; ++i){
                if(bytes[i] < 0){//调整异常数据
                    bytes[i] += 256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
