package peaner.yier.utils.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Peaner
 * @time: 2020/9/4
 * @description: 随机概率
 */
public class RandomUtil {

    private static final List<Integer> propList = Stream.of(7, 14, 21, 30).collect(Collectors.toList());
    //private static final List<Integer> propList = Stream.of(10, 20, 70).collect(Collectors.toList());

    /*static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(1, 0);
        map.put(2, 0);
        map.put(5, 0);
        map.put(10, 0);
        map.put(16, 0);
        map.put(17, 0);
        map.put(19, 0);
        map.put(30, 0);
    }*/

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer tipCount = 1000;
        for (int i = 0; i < tipCount; i++) {
            int t = org.apache.commons.lang.math.RandomUtils.nextInt(4);
            System.out.println("ttt->" + t);
        }
    }

    /*public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        *//*map.put(10, 0);
        map.put(20, 0);
        map.put(70, 0);*//*
        map.put(1, 0);
        map.put(2, 0);
        map.put(5, 0);
        map.put(10, 0);
        map.put(16, 0);
        map.put(17, 0);
        map.put(19, 0);
        map.put(30, 0);

        Integer tipCount = 10000000;
        for (int i = 0; i < tipCount; i++) {
            int min = 1;
            int max = 100;
            int t = min + (int) (Math.random() * (max - min));
            for (Integer a : propList) {
                if (t - a <= 0) {
                    map.put(a, map.get(a) + 1);
                    break;
                } else {
                    t = t - a;
                }
            }
        }
        *//*for (Map.Entry entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }*//*
        for (Integer a : propList) {
             System.out.println("key: " + a + "--> 概率：" + (map.get(a) * 1.00) / tipCount);
        }
    }*/


}
