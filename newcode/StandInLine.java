package newcode;

/* n����վ�ӣ����ǵı�����δ�1��n��Ҫ����Ϊa���˱����ڱ��Ϊb���˵���ߣ�����Ҫ��һ�����ڣ����ʹ��ж������ŷ���
 * 	--n���˵�һ��ȫ���� a��b��ߵ�ռһ�룬��b�ұ�ռһ�룬 ����� n��/ 2
 * �ڶ������Ҫ��a������b����ߣ�����һ��Ҫ���ڣ�����һ���ж������ŷ�?
 *  -- (n-1)!
 * ��������n�������˵ı��a��b���뷵��һ������Ԫ�ص����飬��������Ԫ������Ϊ��������Ĵ𰸡���֤����С�ڵ���10��
 * */
public class StandInLine {
	public int[] getWays(int n, int a, int b) {
		int first = 1, second = 1;
		for (int i = 2; i < n; i++) 
			second *= i;
		first = second * n / 2;
        return new int[]{first, second};
    }
}
