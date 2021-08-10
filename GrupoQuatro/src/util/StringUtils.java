package util;

/**
 *
 * @author Celiculos
 */
public class StringUtils {

    public static int getMaxLength(String... strings) {
        int len = Integer.MIN_VALUE;
        for(String str : strings) {
            len = Math.max(str.length(), len);
        }
        return len;
    }

    public static int getMaxLength(final java.util.Map<String, String> text) {
        int maxSize = 0;
        for(java.util.Map.Entry<String, String> pair : text.entrySet()) {
            int pairLength = pair.getKey().length() + pair.getValue().length();
            if(pairLength > maxSize) {
                maxSize = pairLength;
            }
        }
        return maxSize;
    }

    public static String pad(String str, int len) {
        return new StringBuilder(str).append(fill(' ', len - str.length())).toString();
    }

    public static String fill(char ch, int len) {
        if(len <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

}