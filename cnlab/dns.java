import java.net.*;

public class dns {
    public static void main(String[] args) throws Exception {
        String hostname = "youtube.com";

        // Hostname to IP
        InetAddress ip = InetAddress.getByName(hostname);
        System.out.println("IP Address of " + hostname + ": " + ip.getHostAddress());

        // IP to Hostname
        InetAddress host = InetAddress.getByName(ip.getHostAddress());
        System.out.println("Hostname for " + ip.getHostAddress() + ": " + host.getHostName());
    }
}
