package functional;

/**
 * 定义策略接口  ，统一策略的方法签名
 * 说明： 对同一个字符串的不同种处理  处理即行为  对行为的抽象  将行为进行传递
 * 将行为说成策略
 */
interface Strategy {
    String approach(String msg);
}

/**
 * 策略的 第一种实现   对字符串进行 转换成大写的处理。
 */
class Soft implements Strategy {

    @Override
    public String approach(String msg) {
        return msg.toUpperCase();
    }
}

/**
 * 方法引用 演示：  也作为策略的一种实现。
 * 不需要定义接口 进行约束 直接写实现类方法 进行调用 类似于js
 */
class Unrelated {
    static String twice(String msg) {
        return msg + "=======" + msg;
    }
}

/**
 * 第三章：函数式编程  对比新旧语法 在策略模式下的应用
 * <p>
 * 此类一般是框架写的。
 * 需要处理的对象(Msg)不变   调用处理方法的逻辑不变    变化的是：如何处理行为，即策略
 * <p>
 * 场景：  应用在集成  第三方登录认证  多种认证方式（行为）  不变的是用户openID 、token、用户名密码等。
 *
 * @Author 时少龙
 * @Date 2019-07-13 11:22
 * @Version 1.0
 */
public class Strategize {

    String msg;  // 要处理的字符串
    Strategy strategy;  // 对字符串进行处理的方法  怎么样处理  即策略

    public Strategize(String msg) {
        this.msg = msg;
        strategy = new Soft();
    }

    /**
     * 支持策略变更的方法
     */
    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 调用策略   框架。  写框架的核心部分。
     */
    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    public static void main(String[] args) {
        Strategize s = new Strategize("hello there!");
        s.communicate();

        System.out.println( "多种参数调用");

        // 初始化策略     初始化 第三方认证流程
        Strategy[] strategies = {
                //1. 匿名内部类 原始写法
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toLowerCase(); // 转成小写。、
                    }
                },

                // 2. lambda表达式 匿名内部类 定义+调用 二合一 写法
                msg -> msg + "====" + msg + "=======" + msg,

                // 3.方法引用  调用   不用写方法参数  难道是  形参和返回参数一致 方法就可以相互替换吗？？？？
                Unrelated::twice
        };

        // 调用策略
        for (Strategy strategy: strategies){
            s.changeStrategy(strategy);
            s.communicate();
        }
    }

}
