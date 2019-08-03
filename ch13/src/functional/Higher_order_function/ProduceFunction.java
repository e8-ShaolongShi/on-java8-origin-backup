package functional.Higher_order_function;

import java.util.function.BinaryOperator;
import java.util.function.Function;


interface Funcs extends Function<String, String> {
}

/**
 * 高阶函数： 产生或消费函数   的函数
 *
 * @Author 时少龙
 * @Date 2019-08-03 9:39
 * @Version 1.0
 */
public class ProduceFunction {

    /**
     * 返回类型  是接口方法类型  说明返回一个函数
     *
     * @return
     */
    static Funcs produce() {
        return s -> s.toUpperCase();
    }

    static BinaryOperator<Integer> sumInt() {
        return (a, b) -> a + b;
    }

    public static void main(String[] args) {
        // 调用函数 得到了一个函数
        Funcs funcs = produce();
        // 调用函数产生的函数
        String aLong = funcs.apply("long");
        System.out.println(aLong);

        // 产生一个计算两个数相加的函数
        BinaryOperator sum = sumInt();
        Integer result = (Integer)sum.apply(5, 4);
        System.out.println(result);
    }
}
