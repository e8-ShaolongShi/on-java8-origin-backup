package static_demo;

class Person {
    static int couter = 0;
    private static final int id = couter++;

    void printId() {
        System.out.println(id);
    }
}

/**
 * static 用法例子 做计数器用。
 *
 * @Author 时少龙
 * @Date 2019-07-10 11:35
 * @Version 1.0
 */
public class Counter {

    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        p3.printId();
//        for (int i = 0; i < 50; i++) {
//
//        }
    }

}
