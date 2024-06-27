import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.Integer.compare;

public class StringSum {
    public static void main(String[] args) {

        String numbers = "99 44 33 88 57 23 54 45 ";
        System.out.println(" ****** Input is --- " + numbers);
        List<String> sums = new ArrayList<>(List.of(numbers.split(" ")));

        Comparator<String> alternateComparator = Comparator.comparingInt(StringSum::sum);

        List<String> altSums = sums;
        callingReverse(altSums, alternateComparator);
        altSums.sort(alternateComparator);
        System.out.println(" ****** output using alt comparator " + String.join(" ", altSums));

        Comparator<String> sortBySum =  (a,b) -> {
            if(StringSum.sum(a) == StringSum.sum(b))
                return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
            return Integer.compare(StringSum.sum(a), StringSum.sum(b));
        };
        //System.out.println("************** using string. join() " + String.join(" ", sums));

        System.out.println(" ******* output using sorted from streams " + sums.stream().sorted(sortBySum).collect(Collectors.joining(" ")));

        callingGroupBy(sums);

    }

    private static void callingGroupBy(List<String> sums) {

        Map<String, Long> groupBYResult = sums.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(" ****** map after groupby " + groupBYResult);

        Map<String, Integer> groupBySumsResult = sums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(StringSum::sum)));
        System.out.println(" ****** map after summing the digits" + groupBySumsResult);

        Map<Integer, List<String>> groupMapBySumsResult = sums.stream().collect(
                Collectors.groupingBy(StringSum::sum, Collectors.toList()));
        System.out.println("******* new map after using sum and values " + groupMapBySumsResult);
    }

    private static void callingReverse(List<String> list, Comparator<String> comparator) {
        list.sort(comparator.reversed());
        System.out.println(" Reversed Version ******** " + String.join(" ", list));
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
