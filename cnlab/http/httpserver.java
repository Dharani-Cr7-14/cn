import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;

public class httpserver {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", e -> {
            String msg = "Hello from Server";
            e.sendResponseHeaders(200, msg.length());
            e.getResponseBody().write(msg.getBytes());
            e.close();
        });
        System.out.println("Server running on http://localhost:8000");
        server.start();
    }
}
