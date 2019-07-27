package test;

// 策略是对字符串 进行不同的处理
interface Strategizies {
    String stragize(String ss);
}

class Soft implements Strategizies {

    @Override
    public String stragize(String ss) {
        return ss.toUpperCase();
    }
}

// 演示方法引用
class Underline {
    public static String Lowwer(String ss) {
        return ss.toUpperCase();
    }
}

/**
 * 使用lambda表达式实现  策略模式
 *
 * @Author 时少龙
 * @Date 2019-07-21 10:49
 * @Version 1.0
 */
public class Strategize {

    String str;
    Strategizies stragize;

    public Strategize(String str) {
        this.str = str;
        this.stragize = new Soft();
    }

    void changeStrage(Strategizies stragize){
        this.stragize = stragize;
    }

    void callStrage(){
        System.out.println(stragize.stragize(str));
    }

    public static void main(String[] args) {
        Strategize strategize = new Strategize("shishdfisdjif");
        strategize.callStrage();

        // 策略初始化
        Strategizies[] strategizies = {
                new Strategizies() {
                    @Override
                    public String stragize(String ss) {
                        return ss+":=========:"+ss;
                    }
                },
                ss -> ss + ss  + ss+ "===========three", // 箭头函数
                Underline :: Lowwer   // 方法引用
        };

        System.out.println("===============调用策略集================");
        // 遍历策略 进行调用
        for (Strategizies strategizies1 : strategizies){
            strategize.changeStrage(strategizies1);  // 更改策略
            strategize.callStrage();  // 调用信息策略。
        }
    }
}
