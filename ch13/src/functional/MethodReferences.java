package functional;

// 定义接口， 固定方法签名。
interface Callable {
    void call(String s);
}

/**
 * 定义类 类中方法 符合上面方法签名
 * <p>
 * 普通类中的实例方法
 */
class Describe {

    void show(String msg) {
        System.out.println(msg);
    }
}

/**
 * 方法引用 演示  demo
 *
 * @Author 时少龙
 * @Date 2019-07-21 12:16
 * @Version 1.0
 */
public class MethodReferences {

    // 普通类中静态方法
    static void hello(String name) {
        System.out.println("Hello," + name);
    }

    // 静态类中的 实例方法
    static class Description {  // 静态内部类 相当于 普通外部类
        String about;

        Description(String desc) {
            this.about = desc;
        }

        void help(String msg) {
            System.out.println(about + "  " + msg);
        }
    }

    // 静态类中的 静态方法
    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {

        Describe d = new Describe();
        Callable c = d::show;  // 方法引用     接口 接口名 == 类名 :: 方法名  （接口引用）
        c.call("call()");

        c = MethodReferences::hello;
        c.call("时少龙");

        c = new Description("valueble")::help;
        c.call("Information");

        c = Helper::assist;
        c.call("Help!");

    }
}


