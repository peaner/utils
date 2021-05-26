package peaner.yier.utils.test.practice;

public class GcTest {

    public static void main(String[] args) {
//         byte[] b = new byte[1 * 1024 * 1024];
//         System.gc();
        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");    //系统的最大空间
        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");  //系统的空闲空间
        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");  //当前可用的总空间
    }



}
