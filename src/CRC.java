import java.util.Scanner;

public class CRC {
    static String xor(String dividend, String divisor){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < divisor.length(); i++) {
            sb.append(dividend.charAt(i) == divisor.charAt(i) ? '0' : '1');
        }
        return sb.toString();
    }

    static void divide(String dividend, String divisor){
        int divisorLength = divisor.length();
        String tempDividend = dividend.substring(0, divisorLength);

        while (divisorLength < dividend.length()) {
            if (tempDividend.charAt(0) == '1') {
                tempDividend = xor(tempDividend, divisor) + dividend.charAt(divisorLength);
            } else {
                tempDividend = xor(tempDividend, "0".repeat(divisor.length())) + dividend.charAt(divisorLength);
            }
            divisorLength++;
            tempDividend = tempDividend.substring(1); // Remove the processed bit
        }

        // Process the last bits
        if (tempDividend.charAt(0) == '1') {
            tempDividend = xor(tempDividend, divisor);
        } else {
            tempDividend = xor(tempDividend, "0".repeat(divisor.length()));
        }
        tempDividend = tempDividend.substring(1); // Final adjustment

        System.out.println("Remainder: " + tempDividend);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Dividend: ");
        String dividend = sc.next();
        System.out.println("Enter the Divisor: ");
        String divisor = sc.next();

        divide(dividend, divisor);
        sc.close();
    }
}
