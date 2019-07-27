package functional;

/**
 * lambda表达式在递归中的使用    实现1-10  的阶乘
 *
 * @Author 时少龙
 * @Date 2019-07-13 15:49
 * @Version 1.0
 */
public class RecursiveFactorial {

    static IntCall fact;

    public static void main(String[] args) {

        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for(int i = 0; i<= 10; i++){
            int r = fact.call(i);
            System.out.println(r);
        }
    }
}
