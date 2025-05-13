import java.util.Scanner;

public class crc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data bits: ");
        String data = sc.next();

        System.out.print("Enter divisor (generator): ");
        String divisor = sc.next();

        String dividend = data + "0".repeat(divisor.length() - 1);
        String remainder = divide(dividend, divisor);

        String transmitted = data + remainder;
        System.out.println("Transmitted data: " + transmitted);

        // Receiver side
        System.out.print("Enter received data: ");
        String received = sc.next();

        String rem = divide(received, divisor);
        if (rem.contains("1"))
            System.out.println("Error detected in received data.");
        else
            System.out.println("No error detected.");

        sc.close();
    }

    static String divide(String dividend, String divisor) {
        int len = divisor.length();
        char[] temp = dividend.substring(0, len).toCharArray();

        for (int i = len; i <= dividend.length(); i++) {
            if (temp[0] == '1') {
                for (int j = 1; j < len; j++)
                    temp[j - 1] = xor(temp[j], divisor.charAt(j));
            } else {
                for (int j = 1; j < len; j++)
                    temp[j - 1] = xor(temp[j], '0');
            }

            if (i < dividend.length())
                temp[len - 1] = dividend.charAt(i);
        }

        return new String(temp).substring(0, len - 1);
    }

    static char xor(char a, char b) {
        return (a == b) ? '0' : '1';
    }
}
