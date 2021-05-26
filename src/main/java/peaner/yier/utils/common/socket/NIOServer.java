package peaner.yier.utils.common.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws IOException {
        /**
         * 1、serverSelector负责轮询是否有新的连接，服务端检测到有新的连接后，不再创建一个新的线程。
         * 而是直接将连接绑定到clientSelector上，这样就不用IO模型中1w个while循环在死等。
         */
        Selector serverSelector = Selector.open();
        /**
         * 2、clientSelector负责轮询连接是否有数据可读
         */
        Selector clientSelector = Selector.open();

        new Thread(() -> {
            try {
                // 对应IO编程中服务端启动
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(3333));
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                while (true) {
                    // 检测是否有新连接，这里的1指的是阻塞时间1ms
                    if (serverSelector.select(1) > 0) {
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = set.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            if (key.isAcceptable()) {
                                try {
                                    SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector, SelectionKey.OP_READ);

                                    // SocketChannel socketChannel = new sc
//                                    SocketChannel channel = (SocketChannel) key.channel();
//                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                                    channel.read(byteBuffer);
//                                    byteBuffer.flip();
//                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                } catch (Exception e) {
                                } finally {
                                    iterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    if (clientSelector.select(1) > 0) {
                        Set<SelectionKey> selectionKeySet = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = selectionKeySet.iterator();
                        while (keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();
                            if (key.isAcceptable()) {

                            }

                        }

                    }
                }
            } catch (Exception e) {

            }
        }).start();



    }

}
