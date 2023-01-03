package stringe;

/**
 * @author Fernando Villalobos Betancourt
 *
 */

public class Stringe {

    // ===== FILL =====

    // Zero Fill

    public static String zfill(String strNum, int size) {
        if (isNumeric(strNum) && size > strNum.length()) {
            return "0".repeat(size - strNum.length()) + strNum;
        } else
            return strNum;
    }

    // Left Fill

    public static String leftFill(String str, int size) {
        if (size > str.length()) {
            return " ".repeat(size - str.length()) + str;
        } else
            return str;
    }

    public static String leftFill(String str, int size, char chr) {
        if (size > str.length()) {
            return Character.toString(chr).repeat(size - str.length()) + str;
        } else
            return str;
    }

    // Right Fill

    public static String rightFill(String str, int size) {
        if (size > str.length()) {
            return str + " ".repeat(size - str.length());
        } else
            return str;
    }

    public static String rightFill(String str, int size, char chr) {
        if (size > str.length()) {
            return str + Character.toString(chr).repeat(size - str.length());
        } else
            return str;
    }


    // ===== IS NUMERIC =====

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    // ===== CENTER =====

    public static String center(String str, int length) {
        if (length > str.length() + 1) {
            int right = (int) Math.floor((length - str.length()) / 2), left = length - right - str.length();
            return " ".repeat(right) + str + " ".repeat(left);
        } else
            return str;
    }

    public static String center(String str, int length, char chr) {
        if (length > str.length() + 1) {
            int right = (int) Math.floor((length - str.length()) / 2), left = length - right - str.length();
            return Character.toString(chr).repeat(right) + str + Character.toString(chr).repeat(left);
        } else
            return str;
    }


    // ===== COUNT =====

    public static int count(String str, char toFound) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == toFound)
                res++;
        }

        return res;
    }

    public static int count(String str, String toFound) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.startsWith(toFound, i))
                res++;
        }

        return res;
    }


    // ===== TITLE =====

    public static String title(String str) {
        if (!str.isEmpty()) {
            StringBuilder res = new StringBuilder((Character.toString(str.charAt(0))).toUpperCase());

            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i - 1) == ' ')
                    res.append((Character.toString(str.charAt(i))).toUpperCase());
                else
                    res.append((Character.toString(str.charAt(i))).toLowerCase());
            }

            return res.toString();
        } else
            return "";
    }


    // ===== PARAGRAPH =====

    public static String paragraph(String str) {
        if (!str.isEmpty()) {
            return (Character.toString(str.charAt(0))).toUpperCase() + str.substring(1).toLowerCase();
        } else
            return "";
    }


    // ===== NUMBER =====

    public static String number(String strNum) {
        if (isNumeric(strNum)) {
            String res = "";
            String[] separated = strNum.split("\\.");
            int comma = 0;

            for (int i = separated[0].length() - 1; i >= 0; i--) {
                res = separated[0].charAt(i) + res;
                comma++;

                if (comma == 3 && i != 0) {
                    res = "," + res;
                    comma = 0;
                }
            }

            if (separated.length == 2)
                res += "." + separated[1];

            return res;
        } else
            return strNum;
    }
}