package hw;

/* ��������32λ����a��b�������һ���㷨����a��b�нϴ�ġ����ǲ������καȽ��ж�
 * ��������ͬ����������һ��
 * */
public class Compare {
    /* �Ƚ���������ķ���
     * ���c > 0��ôsignA��1��signB��Ȼ��0
     * ��֮c < 0��ôsignA��0��signB��Ȼ��1
     * a*signA + b*signB����ǽϴ���Ǹ�
     * */
    public static int getMax(int a, int b){
    	int c = a-b; 
    	int signA = getSign10(c);
    	int signB = flip(signA); 
    	return a*signA + b*signB;
    }
    public static int getSign10(int val){  //val����������1��val�Ǹ�������0�İ汾
    	return flip((val>>>31));  //val����31λ�������������λ���Ƿ���λ,��1&�����
    }
    public static int flip(int val){ // 0 --> 1		1 --> 0
    	return val^1;
    }
    
    public static int getSign01(int val){  //val����������0��val�Ǹ�������1�İ汾
    	//return (val>>>31)&1;
    	return (val>>>31);  //val����31λ�������������λ���Ƿ���λ,��1&�����
    }
}
