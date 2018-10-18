package peaner.yier.utils;

/**
 * @Author: lilongzhou
 * @Description:
 * @Date: Created in 上午9:45 2018/9/11
 */
public class ReferenceCountintGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 *_1MB];

    public static void testGC() {
        ReferenceCountintGC gcA = new ReferenceCountintGC();
        ReferenceCountintGC gcB = new ReferenceCountintGC();

        gcA.instance = gcB;
        gcB.instance = gcA;

        gcA = null;
        gcB = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }


}
