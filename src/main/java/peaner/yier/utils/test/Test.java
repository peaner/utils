package peaner.yier.utils.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lilongzhou
 * @Description:
 * @Date: Created in 15:19 2018/8/23
 */
@Slf4j
public class Test {


    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
        test4();



        /*Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");

        List<String> a = new ArrayList<>(set);

        for (String value : a) {
            System.out.println(value);
        }*/


        /*try {

            List<String> uidList = new ArrayList<>();
            uidList.add("1");
            uidList.add("2");
            uidList.add("3");
            uidList.add("4");
            uidList.add("5");

            for (int i = 0; i < 10000; i++) {
                Integer random = RandomUtils.nextInt(0, uidList.size()); //[1,100]
                System.out.println(uidList.get(random));
            }


            // 0 , 3
            *//*Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < 10000; i++) {
                Integer random = RandomUtils.nextInt(0, 4); //[1,100]
                if (map.containsKey(random)) {
                    map.put(random, map.get(random) + 1);
                } else {
                    map.put(random, 1);
                }
            }

            for (Map.Entry entry : map.entrySet()) {
                System.out.println("random key:" + entry.getKey() + ", count: " + entry.getValue());
            }*//*
        } catch (Exception e) {
            log.error("error" + e);
        }*/

    }

    private static void test1() {
        List<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        final Integer N = 10000000;
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用时长1：" + (endTime - startTime));
    }

    private static void test2() {
        final Integer N = 10000000;
        List<Integer> list = new ArrayList<>(N);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用时长2：" + (endTime - startTime));
    }

    private static void test3() {
        final Integer N = 10000000;
        ArrayList arrayList = new ArrayList();
        long startTime = System.currentTimeMillis();
        arrayList.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用时长3：" + (endTime - startTime));
    }

    private static void test4() {
        final Integer N = 10000000;
        ArrayList arrayList = new ArrayList(N);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用时长4：" + (endTime - startTime));
    }




    /*public static void main(String[] args) {

        *//*ExcelDataVO ExcelDataVO = new ExcelDataVO();
        List<ExcelDataVO> datas = new ArrayList<ExcelDataVO>();

        //找到第2行第2列的company，用"XXX有限公司"替换掉company
        ExcelDataVO vo1 = new ExcelDataVO();
        vo1.setRow(1);
        vo1.setColumn(1);
        vo1.setKey("company");
        vo1.setValue("XXX有限公司");

        //找到第2行第3列的content，用"aa替换的内容aa"替换掉content
        ExcelDataVO vo2 = new ExcelDataVO();
        vo2.setRow(1);
        vo2.setColumn(2);
        vo2.setKey("content");
        vo2.setValue("aa替换的内容aa");

        datas.add(vo1);
        datas.add(vo2);

        //d:\\template.xls为Excel模板文件，d:\\test.xls为程序根据Excel模板文件生成的新文件
        //ExcelUtils.replaceModel(datas, "j:\\templates.xls", "j:\\test.xls");

        ExcelUtils.writeToExcel(datas, "j:\\templates.xlsx", "j:\\test.xlsx", "newVersion");*//*

        //ExcelUtils.readFromExcel( "j:\\test.xlsx", Constants.NEW_VERSION);
        //ExcelUtils.excelToHtml("j:\\test.xls", Constants.PRE_VERSION);
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects, args);
                }
            });
            enhancer.create();
        }

    }*/

    static class OOMObject {

    }

}
