package br.com.tiger.request.converters;

public class NumberConverter {
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isBlank()) {
            return false;
        }
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?\\d*\\.?\\d+");
    }

    // why static?
    // because we don't need to create an instance of the class to use the methods
    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        return Double.parseDouble(strNumber.replace(",", "."));
    }
}
