import java.io.OutputStream;
import java.net.Socket;

public class SendTest {
    public static void main(String[] args) throws Exception {
        try (Socket s = new Socket("127.0.0.1", 5565)) {
            OutputStream os = s.getOutputStream();
            os.write("hello server\n".getBytes("UTF-8"));
            os.flush();
            Thread.sleep(100);
        }
    }
}
