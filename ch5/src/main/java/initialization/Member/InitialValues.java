package initialization.Member;

/**
 * 成员初始化 demo1 成员默认初始化
 *
 * @Author 时少龙
 * @Date 2019-07-10 9:10
 * @Version 1.0
 */
public class InitialValues {

    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    void printInitialValues() {
        System.out.println("Data type Initial value");
        System.out.println("boolean " + t);
        System.out.println("char[" + c + "]");
        System.out.println("byte " + b);
        System.out.println("short " + s);
        System.out.println("int " + i);
        System.out.println("long " + l);
        System.out.println("float " + f);
        System.out.println("double " + d);
        System.out.println("reference " + reference);
    }

    public static void main(String[] args) {
        new InitialValues().printInitialValues();
    }
}

/**
 * 成员初始化 demo2 ：定义时直接赋值
 */
class InitialValues2 {
    boolean bool = true, bool2 = false;
    char ch = 'x', a = 'b';
    byte b = 47, c = 12;
    short s = 0xff, aShort = 0xff;
    int i = 999;
    long lng = 1, aLong = 524l;
    float f = 3.14f, aFloat = 45.6352f;
    double d = 3.14159;
}

/**
 * 成员初始化demo3： 调用方法初始化
 */
class InitialValues3 {
    int a = f();
    int b = g(a);  // 此时a已经初始化完毕，可以用作值给a进行初始化

    int f(){
        return 8;
    }
    int g(int i){
        return i+5;
    }
}
