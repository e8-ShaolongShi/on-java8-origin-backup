package functional.function_interface;

import java.util.function.*;

// 充当数据结构  封装数据
class A {
    int a = 45;

    int getA() {
        return a;
    }

    A setA(int a) {
        this.a = a;
        return this;
    }
}

class B {
    int b = 56;
}


// 定义人
class Person {
    String name;
    int age;

    Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


/**
 * 学习使用JDK8 中定义的 函数接口
 *
 * @Author 时少龙
 * @Date 2019-07-27 17:27
 * @Version 1.0
 */
public class FunctionVariants {

    // 消费者 有参数 没有返回值
    static void setNumver(A a) {
        System.out.println(a.getA());
    }

    // 供应者 五参数 有返回值 supplier
    static A getA() {
        return new A().setA(88);
    }

    // 有参数 有返回值的 Function  将年龄存到A中传入方法 方法中将年龄取出 给人设置年龄
    static Person setAgeForPerson(A a) {
        return new Person("时少龙", a.getA());
    }

    // 参数和  返回值相同， 使用操作符
    static A sum(A a1, A a2) {
        return new A().setA(a1.a + a2.a);
    }

    // 返回值为Boolean 类型 predict
    static Boolean judge(A a, B b) {
        System.out.println(a);
        System.out.println(b);
        return false;
    }

    // 使用方法引用
    static void testFuntionReference() {
        // 给方法起名
        Consumer<A> aa = FunctionVariants::setNumver;
        Supplier<A> bb = FunctionVariants::getA;
        Function<A, Person> person = FunctionVariants::setAgeForPerson;
        BinaryOperator<A> aSum = FunctionVariants::sum;
        BiPredicate<A, B> predicate = FunctionVariants::judge;

        // 调用
        aa.accept(new A());
        A a = bb.get();
        System.out.println(a.getA());
        System.out.println(person.apply(new A().setA(96)));
        System.out.println(aSum.apply(new A().setA(44), new A().setA(5)).getA());
        System.out.println(predicate.test(new A(), new B()));
    }

    // 箭头方法 测试方法接口
    static void testNarra() {
        // 定义方法
        Consumer<A> aa = (A a) -> {
            System.out.println(a);
        };
        Supplier<Person> bb = () ->
                new Person("时少龙", 69);
        Function<A, Person> cc = (A a) -> new Person("小龙", a.getA());
        BinaryOperator<B> dd = (B b1, B b2) -> {
            System.out.println(b1.b + "===" + b2.b);
            B b = new B();
            b.b = b1.b + b2.b;
            return b;
        };
        BiPredicate<A,B> ee = (A a,B b) -> false;

        // 调用
        aa.accept(new A().setA(25));
        System.out.println(bb.get().name +"======="+bb.get().age);
        int age = cc.apply(new A().setA(85)).getAge();
        System.out.println(age);
        dd.apply(new B(),new B());
        System.out.println(ee.test(new A(),new B()));
    }

    public static void main(String[] args) {
        // 调用方法引用
//        testFuntionReference();
        // 运行箭头方法例子
        testNarra();
    }
}
