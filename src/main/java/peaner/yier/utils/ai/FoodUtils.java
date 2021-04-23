package peaner.yier.utils.ai;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author: Peaner
 * @time: 2021/3/5
 * @description: 食物卡路里识别
 */
public class FoodUtils {


    //设置APPID/AK/SK
    public static final String APP_ID = "23763258";
    public static final String API_KEY = "veCZwLH6xIuwoCm8LYGo14pV";
    public static final String SECRET_KEY = "v5cIgrlzIfI8yqzPE7GtGUXhxouzNy0t";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(20000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        // client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        // client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "3");
        options.put("filter_threshold", "0.7");
        options.put("baike_num", "5");

        // 调用接口
        String path = "/Users/lilongzhou/Desktop/png/latiao.png";
        JSONObject res = client.objectDetect(path, options);
        System.out.println(res.toString(2));

    }

    public void sample(AipImageClassify client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "3");
        options.put("filter_threshold", "0.7");
        options.put("baike_num", "5");


        // 参数为本地路径
        String image = "test.jpg";
        JSONObject res = client.dishDetect(image, options);
        System.out.println(res.toString(2));

        // 参数为二进制数组
        // byte[] file = Util.readFileByBytes("test.jpg");
        //res = client.dishDetect(file, options);
        // System.out.println(res.toString(2));
    }

    /*public static String dish(String path) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/dish";
        try {
            // 本地文件路径
            String filePath = path;
            byte[] imgData = Util.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam + "&top_num=" + 5;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
