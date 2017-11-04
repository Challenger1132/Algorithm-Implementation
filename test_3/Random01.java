package test_3;
/* 实现等概率随机产生0和1的随机函数
 * */
import java.util.Random;

public class Random01 {
    private static double p = new Random().nextFloat();
    // 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        StringBuilder sb = new StringBuilder();
        String str = sb.append(f()).append(f()).toString(); //两次f()独立调用
        if(str.equals("00") || str.equals("11"))
        	return random01();
        if(str.equals("01"))
        	return 0;
        else
        	return 1;
    }
}
