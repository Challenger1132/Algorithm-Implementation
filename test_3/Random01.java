package test_3;
/* ʵ�ֵȸ����������0��1���������
 * */
import java.util.Random;

public class Random01 {
    private static double p = new Random().nextFloat();
    // �������p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        StringBuilder sb = new StringBuilder();
        String str = sb.append(f()).append(f()).toString(); //����f()��������
        if(str.equals("00") || str.equals("11"))
        	return random01();
        if(str.equals("01"))
        	return 0;
        else
        	return 1;
    }
}
