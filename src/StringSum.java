import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.Integer.compare;

public class StringSum {
    public static void main(String[] args) {

        String numbers = "99 44 33 88 57 23 54 45 ";
        System.out.println(" ****** Input is --- " + numbers);
        List<String> sums = new ArrayList<>(List.of(numbers.split(" ")));

        Comparator<String> sortBySum =  (a,b) -> {
            if(StringSum.sum(a) == StringSum.sum(b))
                return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
            return Integer.compare(StringSum.sum(a), StringSum.sum(b));
        };

        Comparator<String> alternateComparator = Comparator.comparingInt(StringSum::sum);

        List<String> altSums = sums;
        altSums.sort(alternateComparator);
        System.out.println(" ****** output using alt comparator " + String.join(" ", altSums));

        //System.out.println("************** using string. join() " + String.join(" ", sums));

        System.out.println(" ******* output using sorted from streams " + sums.stream().sorted(sortBySum).collect(Collectors.joining(" ")));

    }

    private static int sum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        //System.out.println("s = " + s + " sum = " + sum);
        return sum;
    }
}
