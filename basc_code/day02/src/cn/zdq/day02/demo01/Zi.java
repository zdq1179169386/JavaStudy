package cn.zdq.day02.demo01;

public class Zi extends Fu {
    public Zi() {
        System.out.println("zi");
//       跟 oc 有点像，super 只是关键字
        System.out.println(this.getClass());
        System.out.println(super.getClass());
    }
}
