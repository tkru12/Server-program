import java.net.ServerSocket;
import java.net.Socket;
/**
 * @version 1.0.0
 * これは、サーバープログラムです。
 * 独自のサーバープログラムを作れるようにしています。
 * 変更するときは、Server.javaのコメントの間の部分を変更してください。
 * このプログラムの再配布は禁じません。
 * ですが、商用利用は禁じます。
 */

public class App {
    /**
     * POSTはかえていいです。
     */
    public static final int POST = 10007;
    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(POST);) {
            System.out.println("Serverが起動しました\npost="+serverSocket.getLocalPort());
            while (true) { 
                Socket socket = serverSocket.accept();
                new Server(socket).start();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static int getPOST() {
        return POST;
    }
}
