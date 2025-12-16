/*
 * PRAKTIKUM 07 "IN234 Paradigma Pemrograman"
 * Nama Program : ConverterCalculator
 * Deskripsi    : Class yang menyimpan operasi pengubahan bentuk bilangan.
 * Penulis      : Miracle Steven Gerrald
 * NRP          : 2472019
 */

public class ConverterCalculator {
    private static final char[] HEX_DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String toBinary(int number) {
        String result = coreConverterFromDecimal(number, Radix.BINARY);
        return String.format("Number %d in binary is %s", number, result);
    }

    public static String toOctal(int number) {
        String result = coreConverterFromDecimal(number, Radix.OCTAL);
        return String.format("Number %d in octal is %s", number, result);
    }

    public static String toHex(int number) {
        String result = coreConverterFromDecimal(number, Radix.HEXADECIMAL);
        return String.format("Number %d in hexadecimal is %s", number, result);
    }

    public static int toDecimal(String number, Radix from) {
        return coreConverterToDecimal(number, from);
    }

    private static String coreConverterFromDecimal(int number, Radix radix) {
        if (number == 0) {
            return "0";
        }

        String result = "";
        final int base = radix.getConversion();

        int groupSize = (radix == Radix.OCTAL) ? 3 : 4;
        int count = 0;

        while (number > 0) {
            int remainder = number % base;
            if (count > 0 && count % groupSize == 0) {
                result = " " + result;
            }

            result = HEX_DIGITS[remainder] + result;
            count ++;
            number /= base;
        }
        return result;
    }

    private static int coreConverterToDecimal(String numberInString, Radix radix) {
        int result = 0;
        final int base = radix.getConversion();

        numberInString = numberInString.trim().toUpperCase();

        for (int i = 0; i < numberInString.length(); i++) {
            char ch = numberInString.charAt(i);
            int digit;

            if (ch >= '0' && ch <= '9') {
                digit = ch - '0';
            } else if (ch >= 'A' && ch <= 'F') {
                digit = ch - 'A' + 10;
            } else {
                throw new IllegalArgumentException("Illegal character in number: " + ch);
            }

            if (digit >= base) {
                throw new IllegalArgumentException(String.format("Digit '%c' tidak valid untuk basis %s", ch, radix));
            }

            result = result * base + digit;
        }

        return result;
    }
}
