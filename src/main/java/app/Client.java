package app;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;


class Client {
    private SocketChannel socketChannel;


    Client(String host, int port) throws IOException {
        this.socketChannel=SocketChannel.open(new InetSocketAddress(host,port));
    }
    void start() throws IOException {
    Scanner sc = new Scanner(System.in);
        Thread thread= new Thread(new ReceiverThread(socketChannel));
        thread.start();
        while(true){
            String message=sc.nextLine();
            ByteBuffer buffer= ByteBuffer.wrap(message.getBytes());
            socketChannel.write(buffer);
        }
    }
}

