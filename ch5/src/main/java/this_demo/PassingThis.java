package this_demo;

/**
 * this-demo2: 通过调用外部工具类，对自身进行处理
 * @Author 时少龙
 * @Date 2019-07-09 16:58
 * @Version 1.0
 */
public class PassingThis {
    public static void main(String[] args) {
        new Person().eatApple(new Apple());  // 人吃削掉皮的苹果
    }
}

/**
 * 削皮器，传进来什么东西 对它进行削皮  工具类
 */
class Peeler{
    static Apple peel(Apple apple){  // 传进来对它做处理
        return apple;
    }

    /*A -> A  型方法*/
    static String toUpper(String str){
        return str.toUpperCase();
    }
}

/**'
 * 苹果， 能获取到削过皮的苹果
 */
class Apple{
    Apple getPeeled(){
        return Peeler.peel(this);   // 关键点：方法内部需要调用外部方法对自身进行处理   即：需要将自身传入
    }
}

/**
 * 人 吃苹果
 */
class Person{
    void eatApple(Apple apple){
        Apple peeled = apple.getPeeled();
        System.out.println("我吃到苹果了,"+peeled);
    }
}
