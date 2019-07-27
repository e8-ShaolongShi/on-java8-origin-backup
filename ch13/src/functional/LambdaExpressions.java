package functional;

/**
 * 演示 五参数 方法体 只有一行
 */
interface Description {
    String brief();
}

/**
 * 演示 一个参数
 */
interface Body {
    String details(String head);
}

/**
 * 演示多个参数 方法体多行语句
 */
interface Multi {
    String twoArg(String head, Double d);
}

/**
 * lambda表达式 例子
 *
 * @Author 时少龙
 * @Date 2019-07-13 15:21
 * @Version 1.0
 */
public class LambdaExpressions {

    static Body body = h -> h + "No Parens!!";

    static Body body2 = (h) -> h + "maore details";

    static Description desc = () -> "Short info";

    static Multi mult = (h, d) -> h + d;

    static Description moreLines = () -> {
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        Body body = head -> head + "hahah";
        System.out.println(body.details("Oh!"));
        System.out.println(body2.details("H!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("jkijfs", 14.2));
        System.out.println(moreLines);
    }
}
