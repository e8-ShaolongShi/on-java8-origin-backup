package functional;

/**
 * Lambda表达式 写递归  斐波那契数列
 *
 * @Author 时少龙
 * @Date 2019-07-13 15:56
 * @Version 1.0
 */
public class RecursiveFibonacci {

    IntCall fib;

    /**
     * 构造方法中 定义 斐波那契数列计算方法
     */
    RecursiveFibonacci() {
        fib = n ->
                n == 0 ? 0 :
                        n == 1 ? 1 :
                                fib.call(n - 1) + fib.call(n - 2);
    }

    /**
     * 对斐波那契数列 的调用  注意是单独封装方法  单一职责原则的应用。
     *
     * @param n
     * @return
     */
    int fibnacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++) {
            System.out.println(rf.fibnacci(i));
        }
    }
}
