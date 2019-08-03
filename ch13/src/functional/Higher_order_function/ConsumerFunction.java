package functional.Higher_order_function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;

class A {
}

class B {
}

/**
 * 高阶函数 ： 消费一个函数
 *
 * @Author 时少龙
 * @Date 2019-08-03 9:49
 * @Version 1.0
 */
public class ConsumerFunction {

    static B consumer(Function<A, B> ab) {
        // 传入函数的调用
        return ab.apply(new A());
    }

    // =========== 运用高阶函数思想，写个计算器 函数传参 ==============
    // TODO 能用 泛型(支持更多类型)  枚举（对支持的算法进行约束）
    private static Map<String, BinaryOperator<Integer>> operatorMap = new HashMap<>();
    // 系统支持的 计算初始化  （变化部分，系统会增加对新算法的支持）
    static {
        operatorMap.put(Const.add, (a, b) -> a + b);
        operatorMap.put(Const.sub, (a, b) -> a - b);
        operatorMap.put(Const.mult, (a, b) -> a * b);
        operatorMap.put(Const.div, (a, b) -> a / b);
    }

    // 框架部分 将计算参数 传入算法调用
    private static int calc(int a, int b, BinaryOperator<Integer> c) {
        // 调用  将a，b传入算法进行计算
        return c.apply(a, b);  // 高阶函数 的使用 对传入函数进行调用
    }

    // 易于外界调用的API
    public static int calc(int a, int b, String operatorStr) {
        // 调用  将a，b传入算法进行计算
        return calc(a, b, operatorMap.get(operatorStr));
    }

    private class Const {
        public static final String add = "+";
        public static final String sub = "-";
        public static final String mult = "*";
        public static final String div = "/";
    }

    // =========== 运用高阶函数思想，写个计算器 函数传参 ==============

    public static void main(String[] args) {

        // 此处写函数的定义
        consumer(a -> new B());

        // 计算器部分测试
        System.out.println(calc(4,5, "+"));
        System.out.println(calc(4,5, Const.sub));
        System.out.println(calc(4,5, Const.mult));
        System.out.println(calc(20,5, Const.div));
    }


}
