import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10000);
        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while (!(msg = in.readLine()).equals("end")) {
            System.out.println("Client: " + msg);
            out.println(kb.readLine());
        }
        s.close(); ss.close();
    }
}
