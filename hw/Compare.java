package hw;

/* 对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断
 * 若两数相同，返回任意一个
 * */
public class Compare {
    /* 比较两个数差的符号
     * 如果c > 0那么signA是1，signB必然是0
     * 反之c < 0那么signA是0，signB必然是1
     * a*signA + b*signB结果是较大的那个
     * */
    public static int getMax(int a, int b){
    	int c = a-b; 
    	int signA = getSign10(c);
    	int signB = flip(signA); 
    	return a*signA + b*signB;
    }
    public static int getSign10(int val){  //val是正数返回1，val是负数返回0的版本
    	return flip((val>>>31));  //val右移31位，保留的是最高位，是符号位,与1&运算符
    }
    public static int flip(int val){ // 0 --> 1		1 --> 0
    	return val^1;
    }
    
    public static int getSign01(int val){  //val是正数返回0，val是负数返回1的版本
    	//return (val>>>31)&1;
    	return (val>>>31);  //val右移31位，保留的是最高位，是符号位,与1&运算符
    }
}
