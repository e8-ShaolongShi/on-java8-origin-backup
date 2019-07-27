package functional;

import java.util.function.Function;

class Foo {

}

class Bar {
    Foo f;

    Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;

    IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long l;

    LBaz(long l) {
        this.l = l;
    }
}

class DBaz{
    Double d;
    DBaz(Double d){
        this.d = d;
    }
}

/**
 * 方法接口 演示
 *
 * @Author 时少龙
 * @Date 2019-07-21 17:16
 * @Version 1.0
 */
public class FunctionVariants {

    static Function<Bar,Foo> f1 = f -> new Bar(f);

    public static void main(String[] args) {

    }
}
