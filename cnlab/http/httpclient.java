import java.io.*;
import java.net.*;

public class httpclient {
    public static void main(String[] args) throws Exception {
        HttpURLConnection con = (HttpURLConnection) new URL("http://localhost:8000").openConnection();
        System.out.println("Status Code: " + con.getResponseCode());
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        System.out.println("Response: " + in.readLine());
        in.close();
    }
}
