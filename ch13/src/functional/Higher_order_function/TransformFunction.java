package functional.Higher_order_function;

import java.util.function.Function;

// 定义测试用的数据结构
class I {
    public int i = 1;

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "I" + i;
    }
}

class O {
    @Override
    public String toString() {
        return "O";
    }
}

/**
 * 高阶函数：使用技巧，将消费函数和生产函数结合使用， 中间对消费函数进行了处理，以生成新的函数
 *
 * @Author 时少龙
 * @Date 2019-08-03 10:27
 * @Version 1.0
 */
public class TransformFunction {

    // 方法增强 代理 AOP思想的支持
    static Function<I, O> transForm(Function<I, O> in) {
//        return IN; // 最简单的直接将传入的IN 返回出去，
        return in.andThen(o -> {  // 是对返回值做的处理
            System.out.println(o);
            return o;
        });
    }

    public static void main(String[] args) {
        Function<I, O> testTrans = transForm(i -> {
            System.out.println(i);
            return new O();
        });
        testTrans.apply(new I());
    }


}
