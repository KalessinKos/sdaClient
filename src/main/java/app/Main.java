package app;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String [ ] args){
        try {
            Client client = new Client("localhost",14449);
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
