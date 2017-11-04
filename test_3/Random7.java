package test_3;

import java.util.Random;
/* 给定一个等概率随机产生1~5的随机函数，除此之外，不能使用任何额外的随机机制
 * 请实现等概率随机产生1~7的随机函数
 * */
public class Random7 {
    private static Random rand = new Random(123456);
    // 随机产生[1,5]
    private static int rand5() {
        return 1 + rand.nextInt(5);
    }
    
    // 通过rand5实现rand7
    public static int randomNumber() {
    	int firstCall = rand5()-1;  // 0 1 2 3 4
    	int secondCall = (rand5()-1)*5;  // 0 5 10 15 20
    	//以上是两次独立的调用
    	int num = firstCall + secondCall; //随机产生0 1 2 3 4 ... 24
    	if(num > 20)
    		return randomNumber();
    	num %= 7;  // 0 1 2 3 4 5 6
    	num += 1;
    	return num;
    }
    public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(randomNumber());
		}
	}
}