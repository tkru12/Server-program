import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server extends Thread {
    private Socket socket;
    private String line;

    public Server(Socket socket) {
        this.socket = socket;
        System.out.println("接続されました IP:"+socket.getRemoteSocketAddress());
    }
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            /**
             * ここからは、独自のプログラムを組んでいってください。
             * デフォルトで表示するだけになっております。
             */
            while ((line = in.readLine()) != null) { 
                System.out.print(line);
            }
            //ここまで（目安）
            System.out.println(line);
        } catch (IOException e) {
            e.getStackTrace();
        }finally {
            try {
                if (socket == null) {
                    socket.close();
                }
            } catch (IOException e) {;}
            System.out.println("切断されました。");
        }
    }
}
