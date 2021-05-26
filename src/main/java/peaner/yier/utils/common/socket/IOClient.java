package peaner.yier.utils.common.socket;

import java.net.Socket;
import java.util.Date;

public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world!").getBytes());
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e) {
            }
        }).start();
    }

}
