package interfaceabstclass;

public class Main {
    public static void main(String[] args) {
        C1 c1 = new C1();
        c1.log("hello suji papa ");
        c1.print("");
        c1.print("Suji");
        //c1.logStatic this call wont work as that is static to the interface alone

        I1 i1  = new C1();
        i1.method1();
        i1.log("Interface I1 this is overridden by implementation in c1 for default method");
        I1.logStatic("Suji");
        System.out.println();

        /*I2 i2 = new I2() {
            @Override
            public void method2() {
                System.out.println("I am getting printed from I2's method2");
            }
        };*/

        //above is equal to
        I2 i2 = () -> System.out.println("I am getting printed from main overridden-method2");

        i2.method2();
        i2.method3();
        i2.log("S");
        I2.logStatic("static from I2");
    }
}
