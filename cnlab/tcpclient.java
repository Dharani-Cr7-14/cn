import java.io.*;
import java.net.Socket;



public class tcpclient{
    public static void main(String[] args) throws Exception {
        
     Socket s=new Socket("localhost",10000);

     BufferedReader in =new BufferedReader(new InputStreamReader(s.getInputStream()));
     PrintWriter out=new PrintWriter(s.getOutputStream(),true);
     BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));

     
     String msg=kb.readLine();
     out.println(msg);

     while(!msg.equals("end"))
     {
        System.out.println("server:"+in.readLine());
        out.println(kb.readLine());
     }

     s.close();

    }
}