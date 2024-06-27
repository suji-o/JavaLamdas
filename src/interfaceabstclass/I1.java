package interfaceabstclass;

public interface I1 {

    void method1();

    default void log(String s) {
        System.out.println("Hello printing from I1");
    }

    static void logStatic(String s) {
        System.out.print("Printing from stattic I1 by - " + s);
    }

    default void print(String str) {
        System.out.print("  printing from I1's print");
        if (!isNull(str))
            System.out.println("    MyData Print::" + str);
    }

    static boolean isNull(String str) {
        System.out.println("I1's Null Check for - " + str);

        return str == null || (str.isEmpty());
    }
}
