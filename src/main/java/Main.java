import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("aa");
        String str = "abcabcaabcdsfsdfczxcaaazxcuiW09123456789";
        Matcher m = pattern.matcher(str);
        int counter = 0;
        while (m.find()) {
            counter++;
        }
        System.out.println(counter);
    }
}


