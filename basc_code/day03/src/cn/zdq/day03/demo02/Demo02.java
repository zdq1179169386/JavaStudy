package cn.zdq.day03.demo02;

public class Demo02 {
    public static void main(String[] args) {
            MyInterfaceImp imp = new MyInterfaceImp();
            imp.method();
            //接口的静态方法
            MyInterface.method2();
            imp.methodDefault();
            System.out.println("==========");

            MyInterfaceImpA impA = new MyInterfaceImpA();
            impA.methodDefault();


    }
}
