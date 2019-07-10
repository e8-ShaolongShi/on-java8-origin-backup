package this_demo;

/**
 * this-demo3： 一个构造函数中调用另一个构造方法
 *
 * @Author 时少龙
 * @Date 2019-07-09 17:18
 * @Version 1.0
 */
public class Flower {

    int petalCount = 0;
    String ss = "initial value";

    public Flower(int petals) {
        this.petalCount = petals;
        System.out.println("this is constructor /w  only a int " + petals);
    }

    public Flower(String ss) {
        System.out.println("this is constructor /w  only a String " + ss);
        this.ss = ss;
    }

    public Flower(String ss, int petals) {
        this(petals);
//        this(ss); //构造器中使用this调用构造器，只能有一个并且还应该卸载第一行
        this.ss = ss;
        System.out.println("String & int"+ss);
    }

    public Flower() {
        this("qibanmei", 7);
    }

    public static void main(String[] args) {
        new Flower();
    }
}
