import java.net.*;

public class udpserver {
    public static void main(String[] a) throws Exception {
        DatagramSocket s = new DatagramSocket(10000);
        byte[] buf = new byte[1000];

        while (true) {
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            s.receive(p);
            String msg = new String(p.getData(), 0, p.getLength());
            System.out.println("Client: " + msg);
            if (msg.equals("end")) break;

            byte[] r = new java.util.Scanner(System.in).nextLine().getBytes();
            s.send(new DatagramPacket(r, r.length, p.getAddress(), p.getPort()));
        }
        s.close();
    }
}
