package functional;

// 方法实现
class This {
    void two(int i, double d) {
    }

    void three(int i, double d, String s) {
    }

    void four(int i, double d, String s, char c) {
    }
}

// 定义接口 固定方法签名
interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(
            This athis, int i, double d, String s, char c);
}

/**
 * 多个参数的未绑定方法   使用方法引用演示
 *
 * @Author 时少龙
 * @Date 2019-07-21 15:13
 * @Version 1.0
 */
public class MultiUnbound {

    public static void main(String[] args) {

        TwoArgs ta = This::two;
        ThreeArgs tha = This::three;
        FourArgs fa = This::four;

        This aThis = new This();
        ta.call2(aThis, 11, 23.5);
        tha.call3(aThis, 56, 12.36, "sfsd");
        fa.call4(aThis, 14, 56.21, "fsdf", 'a');
    }

}
