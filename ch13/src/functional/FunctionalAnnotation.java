package functional;

@FunctionalInterface
interface Functional {
    String goodBye(String msg);
}

interface FunctionalNoAnn {
    String goodBye(String msg);
}

// 出现多个参数时不符合，方法接口的定义 会报编译错误
//@FunctionalInterface // 报废函数接口错误
interface NotFunctional {
    String goodBye(String msg);
    String hello(String aa);
}


/**
 * 方法接口 演示
 * 方法接口：接口中只定义一个方法的接口称为方法接口
 *
 * @Author 时少龙
 * @Date 2019-07-21 16:45
 * @Version 1.0
 */
public class FunctionalAnnotation {

    public String goodBye1(String arg){
        return "Goodbye" + arg;
    }

    public static void main(String[] args) {

        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional func = fa::goodBye1;
        FunctionalNoAnn fna =  fa::goodBye1;
        System.out.println(func.goodBye("fsf"));
        fna.goodBye("fa");

        System.out.println("=============lambda表达式实现===========");
        Functional fn2 = ss -> "goodBye  "+ss;
        FunctionalNoAnn fna2 = str -> "baibai" +str;
        System.out.println(fn2.goodBye("时少龙"));
        System.out.println(fna2.goodBye("时少龙"));
    }
}
