/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import java.util.StringTokenizer;
import org.springframework.stereotype.Component;

@Component
public class DecimalNumberToEnglishWords {
    public static final String[] units = new String[]{"", " one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[] tens = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String doubleConvert(double n) {
        String pass = String.valueOf(n);
        StringTokenizer token = new StringTokenizer(pass, ".");
        String first = token.nextToken();
        String last = token.nextToken();
        try {
            pass = String.valueOf(DecimalNumberToEnglishWords.convert(Integer.parseInt(first))) + " ";
            pass = String.valueOf(pass) + "POINT";
            int i = 0;
            while (i < last.length()) {
                String get = DecimalNumberToEnglishWords.convert(Integer.parseInt(String.valueOf(last.charAt(i))));
                pass = get.isEmpty() ? String.valueOf(pass) + " " + "ZERO" : String.valueOf(pass) + " " + get;
                ++i;
            }
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        return pass;
    }

    public static String convert(int n) {
        if (n < 0) {
            return "minus " + DecimalNumberToEnglishWords.convert(-n);
        }
        if (n < 20) {
            return units[n];
        }
        if (n < 100) {
            return String.valueOf(tens[n / 10]) + (n % 10 != 0 ? " " : "") + units[n % 10];
        }
        if (n < 1000) {
            return String.valueOf(units[n / 100]) + " hundred " + (n % 100 != 0 ? " " : "") + DecimalNumberToEnglishWords.convert(n % 100);
        }
        if (n < 1000000) {
            return String.valueOf(DecimalNumberToEnglishWords.convert(n / 1000)) + " thousand " + (n % 1000 != 0 ? " " : "") + DecimalNumberToEnglishWords.convert(n % 1000);
        }
        if (n < 1000000000) {
            return String.valueOf(DecimalNumberToEnglishWords.convert(n / 1000000)) + " million " + (n % 1000000 != 0 ? " " : "") + DecimalNumberToEnglishWords.convert(n % 1000000);
        }
        return String.valueOf(DecimalNumberToEnglishWords.convert(n / 1000000000)) + " billion " + (n % 1000000000 != 0 ? " " : "") + DecimalNumberToEnglishWords.convert(n % 1000000000);
    }
}
