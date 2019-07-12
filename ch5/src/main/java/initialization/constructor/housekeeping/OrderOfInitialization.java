package initialization.constructor.housekeeping;

// housekeeping/OrderOfInitialization.java
// Demonstrates initialization order
// When the constructor is called to create a
// Window object, you'll see a message:


// 窗户
class Windows{
    public Windows(int mark){
        System.out.println("windows:("+mark+");");
    }
}

// 房子
class House{
    Windows w1 = new Windows(1);  // begin constructor

    House(){
        System.out.println("House()");
        w3 = new Windows(33);
    }

    Windows w2 = new Windows(2);  // after constructor

    void f(){
        System.out.println("House: f()");
    }

    Windows w3 = new Windows(3);  // end constructor
}

/**
 * 构造器初始化 初始化顺序   要得出成员初始化和构造器初始化的先后顺序
 *
 * @Author 时少龙
 * @Date 2019-07-10 9:27
 * @Version 1.0
 */
public class OrderOfInitialization {

    public static void main(String[] args) {
        System.out.println("================== constructor start ==================");
        House h = new House();
        System.out.println("================== constructor end ==================");
        h.f();
    }
}

/*
思考：new 创建对象时  是先调用构造函数还是先初始化成员？
          如果先成员，那么windows(1)等会先打印。    如果先构造器，那么house 会先打印。    猜测：先成员

结论：成员初始化先于构造器初始化。
 */
