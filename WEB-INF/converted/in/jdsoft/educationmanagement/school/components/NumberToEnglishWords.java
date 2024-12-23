/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import java.text.DecimalFormat;
import org.springframework.stereotype.Component;

@Component
public class NumberToEnglishWords {
    private static final String[] tensNames = new String[]{"", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};
    private static final String[] numNames = new String[]{"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};

    private NumberToEnglishWords() {
    }

    private String convertLessThanOneThousand(int number) {
        String soFar;
        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            soFar = String.valueOf(tensNames[(number /= 10) % 10]) + soFar;
            number /= 10;
        }
        if (number == 0) {
            return soFar;
        }
        return String.valueOf(numNames[number]) + " hundred" + soFar;
    }

    public String convert(long number) {
        String tradHundredThousands;
        String tradMillions;
        String tradBillions;
        if (number == 0L) {
            return "zero";
        }
        String snumber = Long.toString(number);
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);
        int billions = Integer.parseInt(snumber.substring(0, 3));
        int millions = Integer.parseInt(snumber.substring(3, 6));
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        int thousands = Integer.parseInt(snumber.substring(9, 12));
        switch (billions) {
            case 0: {
                tradBillions = "";
                break;
            }
            case 1: {
                tradBillions = String.valueOf(this.convertLessThanOneThousand(billions)) + " billion ";
                break;
            }
            default: {
                tradBillions = String.valueOf(this.convertLessThanOneThousand(billions)) + " billion ";
            }
        }
        String result = tradBillions;
        switch (millions) {
            case 0: {
                tradMillions = "";
                break;
            }
            case 1: {
                tradMillions = String.valueOf(this.convertLessThanOneThousand(millions)) + " million ";
                break;
            }
            default: {
                tradMillions = String.valueOf(this.convertLessThanOneThousand(millions)) + " million ";
            }
        }
        result = String.valueOf(result) + tradMillions;
        switch (hundredThousands) {
            case 0: {
                tradHundredThousands = "";
                break;
            }
            case 1: {
                tradHundredThousands = "one thousand ";
                break;
            }
            default: {
                tradHundredThousands = String.valueOf(this.convertLessThanOneThousand(hundredThousands)) + " thousand ";
            }
        }
        result = String.valueOf(result) + tradHundredThousands;
        String tradThousand = this.convertLessThanOneThousand(thousands);
        result = String.valueOf(result) + tradThousand;
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}
