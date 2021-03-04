package peaner.yier.utils.only;

/**
 * @author: Peaner
 * @time: 2020/11/23
 * @description: 雪花算法实现唯一id
 */
public class SnowFlakeId {

    // 时间戳
    private final long timestamp = 0L;

    // 机器id所占位数
    private final long workIdBits = 5L;

    // 数据标识id所占位数
    private final long dataCenterIdBits = 5L;

    // 支持的最大机器id, 结果为31
    private final long maxWorkerId = ~(-1L << workIdBits);

    // 支持的最大数据标识id，结果为31
    private final long maxDataCenterId = ~(-1L << dataCenterIdBits);

    // 序列在id中所占的位数
    private final long sequenceBits = 12L;

    // 机器id向左移12位
    private final long workIdShift = sequenceBits;

    // 数据标识id向左移17位
    private final long dataCenterIdShift = sequenceBits + dataCenterIdBits;


    /**
     * 工作机器ID(0~31)
     */
    private long workerId;

    /**
     * 数据中心ID(0~31)
     */
    private long dataCenterId;

    /**
     * 毫秒内序列(0~4095)
     */
    private long sequence = 0L;

    /**
     * 上次生成ID的时间截
     */
    private long lastTimestamp = -1L;

    public SnowFlakeId(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new SnowFlakeException(String.format("workerId can't be greater than %s or less than %s", maxWorkerId, 0));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new SnowFlakeException(String.format("dataCenterId can't be greater than %s or less than %s", maxWorkerId, 0));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    public synchronized long nextId() {
        long timeStamp = timeGen();
        // 如果当前时间小于上一次

        return 0L;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

}
