package interfaceabstclass;

@FunctionalInterface
public interface I2 {

    void method2();
    default void  method3() {
        System.out.println("I2 default method 3");
    }

    default void log(String s) {
        System.out.println("Hello printing from I2's default log() by -" + s);
    }

    static void logStatic(String s) {
        System.out.println("Printing from stattic I2 by - " + s);
    }
}
