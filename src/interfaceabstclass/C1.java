package interfaceabstclass;

public class C1 implements I1, I2 {


    @Override
    public void method1() {

    }

    @Override // this anno is needed on default methods as this will solve the diamond prob
    public void log(String s) {
        System.out.println(s);
    }

    @Override
    public void method2() {

    }

}
