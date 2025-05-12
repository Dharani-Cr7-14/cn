
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;



public class httpserver{
    public static void main(String[] args) throws Exception {

        HttpServer server=HttpServer.create(new InetSocketAddress(8000),0);

        server.createContext("/",e->{
            String msg="heelo broo";
            e.sendResponseHeaders(200,msg.length());
            e.getResponseBody().write(msg.getBytes());
            e.close();
        });
        System.out.println("on port 8000....");
        server.start();

    }
}