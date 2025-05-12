
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;



public class updclient{
    public static void main(String[] args) throws Exception{
        

        DatagramSocket s=new DatagramSocket();
        InetAddress ip=InetAddress.getByName("localhost");
        Scanner sc=new Scanner(System.in);

        while (true) { 
              
              String msg=sc.nextLine();
              s.send(new DatagramPacket(msg.getBytes(),msg.length(),ip,10000));

              if(msg.equals("end"))
              {
                break;
              }

              byte[] buf=new byte[1000];
              DatagramPacket p=new DatagramPacket(buf,buf.length);
              s.receive(p);
              System.out.println("server:"+new String(p.getData(),0,p.getLength()));

        }
        s.close();
    }
}