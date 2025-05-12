import java.net.*;
import java.util.*;

public class udpclient {
    public static void main(String[] a) throws Exception {
        DatagramSocket s = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);

        while (true) {
            String msg = sc.nextLine();
            s.send(new DatagramPacket(msg.getBytes(), msg.length(), ip, 10000));
            if (msg.equals("end")) break;

            byte[] buf = new byte[1000];
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            s.receive(p);
            System.out.println("Server: " + new String(p.getData(), 0, p.getLength()));
        }
        s.close();
    }
}
