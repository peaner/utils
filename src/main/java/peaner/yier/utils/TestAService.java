package peaner.yier.utils;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import peaner.yier.utils.controller.TestBController;

/**
 * @author: Peaner
 * @time: 2020/12/13
 * @description:
 */
@Service
@Slf4j
public class TestAService {

    public void testA() {
        log.info("testA" + TestBController.HOST_URL);
    }

    public static void main(String[] args) {
        /*List<String> messageList = new ArrayList<>();
        messageList.add("在幹什麼呀？");
        messageList.add("來聊天呀～");
        messageList.add("嗨，聊天嗎～");
        messageList.add("你在幹嘛呀");
        messageList.add("抓住一隻小可愛！");
        System.out.println(JSON.toJSONString(messageList));*/
        /*String str1 = new StringBuilder("李隆洲").append("李子煜").toString();
        System.out.println(str1.intern() == str1);


        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        int n = 10;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);*/
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.getHourOfDay());



    }

}
