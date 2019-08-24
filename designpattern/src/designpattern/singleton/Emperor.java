package designpattern.singleton;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: xiantang
 * @Date: 2019/4/29 9:31
 */
public class Emperor {
    private static int maxNumberOfEmperor = 2;
    private static ArrayList emperorInfoList = new ArrayList(maxNumberOfEmperor);
    private static ArrayList emperorList = new ArrayList(maxNumberOfEmperor);
    private static int countNumOfEmperor = 0;

    //最先执行
    static {
        //动态创建指定个数的示例
        for (int i = 0; i < maxNumberOfEmperor; i++) {
            emperorList.add(new Emperor("皇" + (i + 1) + "帝"));
        }

    }

    //防止类被实例化
    private Emperor() {

    }
    //同上
    private Emperor(String info) {
        emperorInfoList.add(info);
    }

    public static Emperor getInstance() {
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumberOfEmperor);
        return (Emperor) emperorList.get(countNumOfEmperor);
    }

    public void emperorInfo() {
        System.out.println(emperorInfoList.get(countNumOfEmperor));
    }

}
