package functional;


class Go{
    static void go(){
        System.out.println("Go::go()");
    }
}

/**
 * 方法引用 与 Runnable接口结合 使用
 *
 * 分析： Runnable 本身就是定义好的一个接口类，这样我们就不需要再固定方法签名了
 * 只需写与它签名相同的方法，然后将引用赋值给他。
 *
 * @Author 时少龙
 * @Date 2019-07-21 12:34
 * @Version 1.0
 */
public class RunnableMethodReference {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
                () -> System.out.println("Lambda")
        ).start();

        // 方法引用
        new Thread( Go::go).start();
    }
}
