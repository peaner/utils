//package peaner.yier.utils.ai;
//
//import com.alibaba.fastjson.JSON;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Locale;
//import java.util.UUID;
//
///**
// * @author: Peaner
// * @time: 2021/3/5
// * @description:
// */
//public class HealthUtils {
//
//    public static void token(){
//
//        AuthHelper.AuthResponse response = AuthHelper.auth(APP_ID,API_KEY);
//
//        System.out.println("response : " + JSON.toJSONString(response));
//
//        if(response !=null && response.getData() !=null){
//            System.out.println("访问令牌 : " + response.getData().getToken());
//            System.out.println("有效期(秒） : " + response.getData().getExpireTime());
//        }
//    }
//
//    public static void sign() {
//
//        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
//        String timestamp = sdf.format(new Timestamp(System.currentTimeMillis()));
//
//        SignHelper.SignFieldBean signField = new SignHelper.SignFieldBean(
//                APP_ID, UUID.randomUUID().toString(), timestamp, Version.VERSION_2_0.getValue());
//
//        String sign = SignHelper.sign(signField, PRIVATE_KEY);
//
//        System.out.println("签名 ： " + sign);
//    }
//
//}
