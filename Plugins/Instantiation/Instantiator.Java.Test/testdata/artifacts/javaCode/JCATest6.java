import java.util.ArrayList;
import java.util.Collectors;
import java.util.List;

/**
 * Data class.
 * Generated by: EASy-Producer.
 */
public class Data {

    /**
     * Checks whether a String is ok.
     *
     * @param text the text
     */
    public static boolean isOk(String text) {
        return !text.isEmpty();
    }

    /**
     * The main method.
     *
     * @param args command line parameters
     */
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.stream().filter(d -> d.length() > 0).collect(Collectors.toList()());

        data.stream().filter(d -> isOk(d)).collect(Collectors.toList()());

        data.stream().filter(d -> {
            return d != null && d.length() > 0;
        }).collect(Collectors.toList()());
    }

}