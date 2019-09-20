package Util;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
    private static Logger logger = Logger.getLogger(StringUtil.class.getName());
    private StringUtil() {

    }
    /**
     * set "UTF-8" as a constant
     */
    public static final String UTF8_ENCODING = "UTF-8";
    /** Parse a string value to long.
     * @return an long value
     * @param s string to be parsed
     * @param defaultValue long
     */
    public static long strToLong(String s, long defaultValue) {

        long i = defaultValue;
        try {
            i = Long.parseLong(s);
        } catch (NumberFormatException e) {
            if (logger.isInfoEnabled()) {
                logger.info("number format exception when parse string to long", e);
            }


        }

        return i;
    }

    /** Parse a string value to int.
     * @return an long value
     * @param s string to be parsed
     * @param defaultValue int
     */
    public static int strToInt(String s, int defaultValue) {

        int i = defaultValue;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            if (logger.isInfoEnabled()) {
                logger.info("number format exception when parse string to int", e);
            }


        }

        return i;
    }

    /**
     * Parse a string value to a array.
     * @param pointStr str
     * @param str str
     * @param strReturn str to be returned
     */
    public static void arrayStr(String pointStr, String str, String[] strReturn) {
        int pos1, pos2;
        if (str.length() > 0) {
            pos1 = str.indexOf(pointStr);
            pos2 = 0;
            int j = 0;
            while (pos1 != -1) {
                strReturn[j] = str.substring(pos2, pos1);
                pos2 = pos1 + pointStr.length();
                pos1 = str.indexOf(pointStr, pos2);
                j = j + 1;
            }
            strReturn[j] = str.substring(pos2);
        }
    }

    /** Replace String.
     *
     * @param str1 source
     * @param str2 need to replace.
     * @param str3 replace to
     * @return replaced string
     */
    public static String stringReplace(String str1, String str2, String str3) {
        String s1, s2;

        //int len1 = str1.length();
        int len2 = str2.length();
        int pos = str1.indexOf(str2);

        while (pos >= 0) {
            s1 = str1.substring(0, pos);
            s2 = str1.substring(pos + len2);
            str1 = s1 + str3 + s2;
            pos = str1.indexOf(str2);
        }
        return str1;
    }

    /**
     * convert string to array list
     * @param str str
     * @param division delimiter
     * @return array list
     */
    public static ArrayList string2Array(String str, String division) {
        ArrayList array = new ArrayList();
        String tmpStr = str;
        int index;
        do {
            index = tmpStr.indexOf(division);
            if (index > -1) {
                array.add(tmpStr.substring(0, index));
                tmpStr = tmpStr.substring(index + division.length());
            } else {
                array.add(tmpStr);
            }

        } while (index > -1);
        return array;
    }

    /**
     * check email validity
     * @param emailAddress email addr
     * @return true if it is a valid email, or false if not
     */
    public static boolean isValidEmail(String emailAddress) {
        emailAddress = emailAddress.trim();
        int apos = emailAddress.indexOf("@");
        int dpos = emailAddress.indexOf(".");
        int spos = emailAddress.indexOf(" ");
        int cpos = emailAddress.indexOf(",");
        if (cpos >= 0 || spos >= 0 || apos < 0 || dpos < 0) {
            return false;
        }
        if (dpos + 1 >= emailAddress.length()) {
            return false;
        }
        if (apos > dpos) {
            return false;
        }
        return true;
    }

    /**
     * Check the chkItme is null or empty.
     * @param chkItem item to check
     * @return true if it is <code>null</code> or empty string
     */
    public static boolean isNullOrEmpty(String chkItem) {
        if (chkItem == null) {
            return true;
        }
        if ("".equals(chkItem.trim())) {
            return true;
        }
        return false;
    }

    /**
     * Convert string to boolean ,used in meeting template logic
     *
     * @param str String
     * @return boolean
     */
    public static boolean string2boolean(String str) {
        if (str == null) {
            return false;
        }
        if ("on".equalsIgnoreCase(str.trim()) || "yes".equalsIgnoreCase(str.trim())
                || "true".equalsIgnoreCase(str.trim()) || "1".equals(str.trim())) {
            return true;
        }
        return false;
    }

//    /**
//     * check if the source is over the max Length by counting Charactor(in literal).
//     * by default, all characotor in xmlapi are encoded by "ISO-8859-1" and native code
//     * is UTF-8.
//     * @param source source
//     * @param encoding encoding
//     * @param maxLength maxLength
//     * @return boolean
//     */
//    public static boolean isValidLength(String source, String encoding, long maxLength) {
//        try {
//            source = new String(source.getBytes("ISO-8859-1"), encoding);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        if (source.length() > maxLength) {
//            return false;
//        }
//        return true;
//
//    }
    /**
     * byte2hex
     * @param b b
     * @return String
     */
    public static String byte2hex(byte[] b) {

        String hs = "";

        String stmp = "";

        for (int n = 0; n < b.length; n++) {

            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }

            if (n < b.length - 1) {
                hs = hs + ":";
            }

        }

        return hs.toUpperCase();

    }


    /**
     * hex2byte
     * @param string String
     * @return byte[]
     */


    public static byte[] hex2byte(String string) {

        byte[] bytes = new byte[(string.length() + 1) / 3];

        String buf = string.toUpperCase();



        for (int i = 0; i < buf.length(); i += 3) {

            char left = buf.charAt(i);

            char right = buf.charAt(i + 1);

            int index = i / 3;



            if (left < 'A') {

                bytes[index] = (byte) ((left - '0') << 4);

            } else {

                bytes[index] = (byte) ((left - 'A' + 10) << 4);

            }

            if (right < 'A') {

                bytes[index] += (byte) (right - '0');

            } else {

                bytes[index] += (byte) (right - 'A' + 10);

            }

        }



        return bytes;

    }

    /**
     * reverse a string, eg: "abcd" --> "dcba"
     *
     * @param str String
     * @return String
     */
    public static String reverseString(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        char[] ch = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }

    /**
     * get regular expression pattern by XSD element name, it's extracted from XMLService.
     * @param elementName XSD element name.
     * @return regular expression pattern that match by element name.
     * @since 4.9
     * @author honjoz
     */
    public static Pattern getPatternByElementName(String elementName) {
        //match bellow "password" tag
        //<ab8_c:password myatt="value" xmlns:xsi="myms">mypa ss</ab8_c:password> 02/01/2007 change it
        Pattern pattern = Pattern.compile("(?s)<(([^:]+:)?" + elementName + ")(\\s+.+?=\\s*\".+?)?>(.*?)</\\1>");
        return pattern;
    }

    /**
     * isNumericString comma and "-" are all regards as not digit.
     * @param val String
     * @return boolean
     */
    public static boolean isNumericString(String val) {
        if (null == val || "".equals(val)) {
            return false;
        }
        for (int i = 0; i < val.length(); i++) {
            if (!Character.isDigit(val.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * use escape characters to handle oracle sensitive characters '%' and '_'
     * @param confName String
     * @param escapeChar char
     * @return converted confName
     */
    public static String escapeWildcard(String confName, char escapeChar) {
        String result = "";
        String sTemp = confName;
        while (sTemp.indexOf(escapeChar) >= 0) {
            int iTemp = sTemp.indexOf(escapeChar);
            result += sTemp.substring(0, iTemp);
            result += (escapeChar + "" + escapeChar);
            sTemp = sTemp.substring(iTemp + 1);
        }
        result += sTemp;
        sTemp = result;
        result = "";

        while (sTemp.indexOf('%') >= 0) {
            int iTemp = sTemp.indexOf('%');
            result += sTemp.substring(0, iTemp);
            result += (escapeChar + "%");
            sTemp = sTemp.substring(iTemp + 1);
        }
        result += sTemp;
        return result;
    }

    /**
     * parse element value by element name from input.
     * @param in String
     * @param elementName String
     * @return element value
     * @author honjoz
     * @since 3.4
     */
    public static String parseElement(String in, String elementName) {
        String elementValue = null;
        if (in == null || elementName == null) {
            return elementValue;
        }
        Pattern pattern = getPatternByElementName(elementName);
        Matcher matcher = pattern.matcher(in);
        if (matcher.find()) {
            elementValue = matcher.group(4);
        }
        return elementValue;
    }

    /**
     * Remove element from a string.
     * @param input String
     * @param elementName String
     * @return removed given element
     */
    public static String removeElement(String input, String elementName) {
        if (input == null || elementName == null) {
            return "";
        }
        Pattern pattern = getPatternByElementName(elementName);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            input = matcher.replaceAll("");
        }
        return input;
    }

    /**
     * Replace null with "".
     * @param input String
     * @return Stirng
     */
    public static String fixNull(String input) {
        if (input == null) {
            return "";
        } else {
            return input;
        }
    }
}
