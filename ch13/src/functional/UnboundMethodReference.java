package functional;


class X {  //1.

    static String aa() {  //1.
        return "X::aa";
    }

    String f() {  //2.
        return "X::f();";
    }
}

// 定义接口 固定方法签名
interface MakeString {  //1.
    String make();
}

// 解决，未绑定方法无法引用的问题。  3.
interface TransformX {
    String Transform(X x);   // 需要将未绑定方法所属的对象以 依赖的形式注入    代码违和感太强
}

/**
 * 未绑定的方法引用 演示
 * 未绑定解释： 是指类的实例方法，此类方法必须绑定到对象上，才能调用
 * 所以在未 new 对象之前。实例方法都属于 未绑定方法
 *
 * @Author 时少龙
 * @Date 2019-07-21 14:52
 * @Version 1.0
 */
public class UnboundMethodReference {

    public static void main(String[] args) {

        MakeString ms = X::aa;  // 对静态方法直接调用，正确的，因为静态方法属于类
        System.out.println(ms.make());  //1.

//        ms = X::f;  // 2. 此时报错了   无法从静态上下文中引用非静态方法。
        //  原因 其实f方法方法还有一个参数this，没new对象绑定，没法传。

        // 3. 对于实例方法引用  方法签名定义时需要加一个参数传递this指针。
        TransformX tx = X::f;
        X x = new X();
        System.out.println(tx.Transform(x));
        System.out.println(x.f());
    }
}
