/*
1�������ַ����Ƿ�Ϊ��ת�ʣ�
��һ���ַ���str��ǰ������ַ��ƶ��������γɵ��ַ����Ǹ��ַ�������ת��
Ѱ����ת�ʣ�
	�����ַ������Ȳ��ȷ���false���������
	��str double��ÿn���Ȳ����ַ���(����n���ȵĻ�������)��ٳ�str������ת�ʣ����Ƿ����str
	public boolean chkRotation(String A, int lena, String B, int lenb) {
        if(lena != lenb)
            return false;
        String str = A + A;
        return str.contains(B);
    }	
�Ƿ�Ϊ���δʣ��ַ������ַ��������Ŀ��ͬ���ַ�������Ϊ���δ�
�����ַ�����ͳ��ÿ���ַ���Ƶ���Լ���Ӧ������--������Ͱ�Լ���ϣ����ʵ��
    
    
2���ַ�������ΪN������i�����ַ���str[0--i]�����ƶ����ұߣ�str[i+1--N-1]�����ƶ������
Ҫ��ʱ�临�Ӷ�ΪO(N) �ռ临�Ӷ���O(1){Ҳ����˵ֻ�ܽ���ԭ�ص���}
�����Ҳ��ֱַ�ԭ����������������
�ַ����ľֲ�������
    public String stringTranslation(String A, int n, int len) {
        if(A == null)
            return null;
        char[] chs = A.toCharArray();
        reverse(chs, 0, len-1);
        reverse(chs, len, chs.length-1);
        reverse(chs, 0, chs.length-1);
        return new String(chs);
    }
    public static void reverse(char[] chs, int left, int right){
        char c = 0;
        while(left < right){
            c = chs[left];
            chs[left] = chs[right];
            chs[right] = c;
            left++;
            right--;
        }
    }

3��������������ͷ���ֱ���t1��t2���ж�t1���Ƿ�����t2���˽ṹ��ȫ��ͬ������
����������+ƥ�� 	   ��t1�е�����(��t1��ĳ���ӽڵ㿪ʼ)���Ƿ��t2�����˽ṹ��ͬ
ת��Ϊ�ַ����Ľⷨ����t1��t2���л����Ӧ���ַ���s1��s2����s1���Ƿ����s2
���s1����s2����ô˵��t1�е�ĳ��������t2�������˽ṹ��ͬ������t1�в�����t2����
�������л�Ϊ�ַ������������ı�����ʽ�ĸı�
	public static String serialBypreOrderTravversal(TreeNode t){
		if(t == null)
			return "#!";
		String s = t.val + "!";
		s += serialBypreOrderTravversal(t.left);
		s += serialBypreOrderTravversal(t.right);
		return s;
	}
	����ʵ��
	public boolean chkIdentical(TreeNode stra, TreeNode strb){
		String s1 = serialBypreOrderTravversal(stra);
		String s2 = serialBypreOrderTravversal(strb);
		return s1.contains(s2);
	}
	�ַ������л� -- ��������ĳ�ֱ�����ʽ���޸�
	 ע��Ҫ�ӽ�����־!(�����ַ�)


5������һ���������ַ������飬���ҵ�һ��ƴ��˳��ʹ����С�ַ���ƴ�ӳɵĴ��ַ��������п��ܵ�ƴ�����ֵ�����С��,�뷵��ƴ�ӳɵĴ�
����ֱ�Ӱ����ֵ������ƴ��
���� "ba" "b"  �����ֵ���ƴ�� "bba"
����"bab"���ֵ���С��"bba"
���԰������¹������ƴ�� str1��str2���Ƚ�str1 + str2 �� str2 + str1��ɵ��ַ������ֵ���
str1 + str2 �ֵ���< str2 + str1��str1��ǰ��str2�ں� 
str1 + str2 �ֵ���> str2 + str1��str2��ǰ��str1�ں� 
	public class MyComparator implements Comparator {
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}


*/
	
