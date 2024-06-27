import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StringPlay {
// You are provided a string containing a list of positive integers separated by a space ( " " ).
// Take each value and calculate the sum of its digits, which we call its "weight".
// Then return the list in ascending order by weight, as a string joined by spaces.
// For example 99 will have "weight" 18 , 100 will have "weight" 1 . In the output 100 will come before 99 .

    public static void main(String[] args) {
        String stringVals = "fsjkfhkjdsfhkjdsh gfgkfjgkjfnfgkjngfkjn gfjgfj gfjjf kff kfgk fggfjnfg fgffgn fgjfgj";

        System.out.println("Input - " + stringVals);
        System.out.println(Arrays.stream(stringVals.split(" ")).sorted(String::compareTo).collect(Collectors.joining(" ")));
        
        String str = "def123, abc999, zzz000, abc123, zzz111";

        System.out.println(" input - " + str);

        String[] sArray = str.split(" ");

        Comparator<String> c1 = Comparator.comparing(s -> s.substring(0,3));
        Comparator<String> c2 =  Comparator.comparing(s -> s.substring(3));


        System.out.println(" output - " + Arrays.stream(sArray).sorted(c1.thenComparing(c2)).collect(Collectors.joining(" ")));


    }
}
