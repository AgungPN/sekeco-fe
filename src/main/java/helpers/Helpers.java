package helpers;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Helpers {

    public static Date date() {
        return new Date(System.currentTimeMillis());
    }

    public static String currency(int money) {
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        decimalFormatSymbols.setMonetaryDecimalSeparator(',');
//        decimalFormatSymbols.setGroupingSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

        return "Rp. "+decimalFormat.format(money);
    }

    public static int toInt(String stringNum) {
        // untuk konversi dari currency() ke int
        if (stringNum.endsWith(",00")) {
            stringNum = stringNum.replace(",", "");
            // start from 4 for remove "Rp. "
            stringNum = stringNum.substring(4, stringNum.length() - 2);
        }
        try {
            return Integer.parseInt(stringNum);
        } catch (NumberFormatException e) {
            Message.error(stringNum + " bukan angka", "Error");
        }
        return -1;
    }
}
