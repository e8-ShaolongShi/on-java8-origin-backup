package this_demo;

/**
 * this 使用demo1 将自身返回
 *
 * @Author 时少龙
 * @Date 2019-07-09 16:48
 * @Version 1.0
 */
public class Leaf {

    int i = 0;

    Leaf increament(){
        i++;
        return this; //链式编程的实现原理
    }

    void print(){
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        new Leaf().increament().increament().increament().print();
    }
}
