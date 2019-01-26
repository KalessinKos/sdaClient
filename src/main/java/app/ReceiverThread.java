package app;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ReceiverThread implements Runnable {
    private SocketChannel socket;
    ReceiverThread(SocketChannel socket){
    this.socket=socket;
}


    public void run() {
        try {
            while(true){
                ByteBuffer buffer= ByteBuffer.allocate(256);
                socket.read(buffer);
                System.out.println(new String (buffer.array()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
