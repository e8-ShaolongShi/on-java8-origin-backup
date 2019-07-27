package functional;

// 定义有不同构造方法的类
class Dog {
    String name;
    int age = -1; // For "unknown"

    Dog() {
        name = "stray";
    }

    Dog(String nm) {
        name = nm;
    }

    Dog(String nm, int yrs) {
        name = nm;
        age = yrs;
    }
}

// 接口中定义 与 类中构造器相匹配的方法签名
interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

/**
 * 构造函数引用  语法：  类名:: new
 *
 * @Author 时少龙
 * @Date 2019-07-21 15:22
 * @Version 1.0
 */
public class CtoReference {

    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;  // 引用构造函数
        Make1Arg m1a = Dog::new;
        Make2Args m2a = Dog::new;

        Dog dn = mna.make();
        Dog sdfs = m1a.make("sdfs");
        Dog fsdf = m2a.make("fsdf", 45);
    }
}
