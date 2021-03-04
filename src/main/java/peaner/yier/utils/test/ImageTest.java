package peaner.yier.utils.test;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Peaner
 * @time: 2020/9/16
 * @description:
 */
public class ImageTest {

    public static void main(String[] args) {
        try {
//            List<String> list = readTxt("/Users/lilongzhou/Desktop/png/gift");

            List<String> listName = readTxt("/Users/lilongzhou/Desktop/png/gift_name");
            Map<String, String> map = new HashMap<>();
            String domain = "https://static.7b6ae.com/giftwall/";
            for (int i = 0; i < listName.size(); i++) {
                String realName = domain + listName.get(i) + "_gray.png";
                System.out.println(realName);
            }

            /*for (int i = 0; i < list.size(); i++) {
                String pngName = "png" + i;
                download(list.get(i), "/Users/lilongzhou/Desktop/png/static/" + pngName + ".png");
                System.out.println(pngName);
            }*/

            /*String path = "/Users/lilongzhou/Desktop/png/slices/";
            String path1 = "/Users/lilongzhou/Desktop/png/slices-1/";
            File file = new File(path);
            for (File f : file.listFiles()) {
                String originName = f.getName();
                String name = f.getName().substring(0, (f.getName().lastIndexOf("@") - 2));
                f.renameTo(new File(path1 + map.get(name) + "_gray.png"));
                System.out.println("originName: " + originName + ", name: " + name);
            }*/



            /*for (int i = 0; i <= 151; i++) {
                String filePath = path + "png" + i + ".png";
                BufferedImage bufferedImage = ImageIO.read(new FileInputStream(filePath));
                BufferedImage grayImage = getGrayImage(bufferedImage);
                String pngName = listName.get(i) + "_gray.png";
                File out = new File("/Users/lilongzhou/Desktop/png/gray/" + pngName);
                ImageIO.write(grayImage, "png", out);
            }*/

            /*for (File f : file.listFiles()) {
                System.out.println(f.getName());
                BufferedImage bufferedImage = ImageIO.read(new FileInputStream(f));
                BufferedImage grayImage = getGrayImage(bufferedImage);
                String pngName = f.getName().substring(0, f.getName().lastIndexOf(".")) + "_gray.png";
                File out = new File("/Users/lilongzhou/Desktop/png/static/" + pngName);
                ImageIO.write(grayImage, "png", out);
            }*/

            // String pngName = "https://qiniustatic.wodidashi.com/h5/front-backstage/latiao_1536652774000.png";
            // download(pngName, "/Users/lilongzhou/Desktop/png/辣条.png");
            /*String imagePath = "/Users/lilongzhou/Desktop/png/辣条.png";

            BufferedImage bufferedImage = ImageIO.read(new FileInputStream(imagePath));
            BufferedImage grayImage = getGrayImage(bufferedImage);

            File out = new File("/Users/lilongzhou/Desktop/png/latiao_gray.png");
            ImageIO.write(grayImage, "png", out);*/




        } catch (Exception e) {

        }

    }

    private static List<String> readTxt(String filePath) {
        List<String> list = new ArrayList<>();
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                reader = new InputStreamReader(new FileInputStream(file), "GBK");
                bufferedReader = new BufferedReader(reader);
                String readLine = null;
                while (null != (readLine = bufferedReader.readLine())) {
                    list.add(readLine);
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static BufferedImage getGrayImage(BufferedImage originalImage) {
        BufferedImage grayImage;
        int imageWidth = originalImage.getWidth();
        int imageHeight = originalImage.getHeight();
        //TYPE_3BYTE_BGR -->  表示一个具有 8 位 RGB 颜色分量的图像，对应于 Windows 风格的 BGR 颜色模型，具有用 3 字节存储的 Blue、Green 和 Red 三种颜色。
        grayImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_3BYTE_BGR);
        ColorConvertOp cco = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        cco.filter(originalImage, grayImage);
        return grayImage;
    }

    /**
     * 将图片置灰 --- 手动
     * @param originalImage
     * @return
     */
    public static BufferedImage getGrayImageManual(BufferedImage originalImage){
        int green = 0,red = 0,blue = 0,rgb;
        int imageWidth = originalImage.getWidth();
        int imageHight = originalImage.getHeight();
        BufferedImage routeImage = new BufferedImage(imageWidth,imageHight,BufferedImage.TYPE_3BYTE_BGR);
        for(int i = originalImage.getMinX();i < imageWidth;i++){
            for(int j = originalImage.getMinY();j < imageHight;j++){
                //获取该点像素，用Object类型标识
                Object data = routeImage.getRaster().getDataElements(i, j,null);
                red = routeImage.getColorModel().getRed(data);
                green = routeImage.getColorModel().getGreen(data);
                blue = routeImage.getColorModel().getBlue(data);
                red = (red*3+green*6+blue*1)/10;
                green = red;
                blue = green;
                rgb = (red*256 +green)*256 +blue;
                if(rgb>8388608){
                    rgb = rgb - 256*256*256;
                }
                //将rgb值写回图片
                routeImage.setRGB(i, j, rgb);
            }
        }
        return routeImage;
    }


    /**
     * 下载文件到本地
     *
     * @param urlString
     *          被下载的文件地址
     * @param filename
     *          本地文件名
     * @throws Exception
     *           各种异常
     */
    public static void download(String urlString, String filename) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        OutputStream os = new FileOutputStream(filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }


}
