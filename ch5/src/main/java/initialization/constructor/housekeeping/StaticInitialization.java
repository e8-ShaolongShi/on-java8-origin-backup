package initialization.constructor.housekeeping;

// housekeeping/StaticInitialization.java
// Specifying initial values in a class definition

// 碗
class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }

    /*
    * javaBean： 基本数据  充当entity。
    */
}

// 格子
class Table {
    static Bowl bowl1 = new Bowl(1);

    Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);

    /*
    有构造器、成员变量   原则：成员变量优先于构造器。


    注意：创建Table对象时需要注意，有两个静态域bowl1和bowl2   所有对象共享，只需要初始化一份，第二次就不需要再初始化。
     */
}

// 橱柜
class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);

    /*
    * 构造方法、静态成员变量、非静态成员变量。   先后顺序
    * 成员变量优先于构造器   那静态成员变量该注意什么呢？
    */
}

/**
 * 初始化例子： 静态成员初始化
 *
 * @Author 时少龙
 * @Date 2019-07-10 10:06
 * @Version 1.0
 */
public class StaticInitialization {

    public static void main(String[] args) {
        System.out.println("main creating new Cupboard()");
        new Cupboard();   // Cupboard 已经有一份了，  这次不应初始化静态成员变量。
        System.out.println("main creating new Cupboard()");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
    // 成员定义为静态的原因：主类JVM并未new 对象，而是以静态方法调用的方式调用入库函数main方法。所以涉及到的只是类加载
    // 类加载静态域就会先做初始化。

    /*
    *  入库口类，类加载执行。
    */
}

/*
猜测：
    Bowl(1)
    Bowl(2)
    Table()
    f1(1)
    Bowl(3)
    Bowl(4)
    Bowl(5)
    Cupboard()
    f1(2)
    main creating new Cupboard()
    Bowl(3)
    Cupboard()
    f1(2)
    main creating new Cupboard()
    Bowl(3)
    Cupboard()
    f1(2)
    f2(1)
    f3(1)
结果：
    Bowl(1)
    Bowl(2)
    Table()
    f1(1)
    Bowl(4)          此处开始3行  与猜测顺序相反
    Bowl(5)
    Bowl(3)
    Cupboard()
    f1(2)
    main creating new Cupboard()
    Bowl(3)
    Cupboard()
    f1(2)
    main creating new Cupboard()
    Bowl(3)
    Cupboard()
    f1(2)
    f2(1)
    f3(1)

分析：
    结果与猜测有出入。猜测与结果的三行出现顺序不一致问题。
结论：

*/



