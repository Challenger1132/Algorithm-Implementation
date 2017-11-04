package test_3;

import java.util.Random;
/* ����һ���ȸ����������1~5���������������֮�⣬����ʹ���κζ�����������
 * ��ʵ�ֵȸ����������1~7���������
 * */
public class Random7 {
    private static Random rand = new Random(123456);
    // �������[1,5]
    private static int rand5() {
        return 1 + rand.nextInt(5);
    }
    
    // ͨ��rand5ʵ��rand7
    public static int randomNumber() {
    	int firstCall = rand5()-1;  // 0 1 2 3 4
    	int secondCall = (rand5()-1)*5;  // 0 5 10 15 20
    	//���������ζ����ĵ���
    	int num = firstCall + secondCall; //�������0 1 2 3 4 ... 24
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