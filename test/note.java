/*
1、两个字符串是否互为旋转词？
将一个字符串str的前任意个字符移动到后面形成的字符串是该字符串的旋转词
寻找旋转词：
	两个字符串长度不等返回false，否则继续
	将str double，每n长度操作字符串(类似n长度的滑动窗口)穷举出str所有旋转词，看是否包含str
	public boolean chkRotation(String A, int lena, String B, int lenb) {
        if(lena != lenb)
            return false;
        String str = A + A;
        return str.contains(B);
    }	
是否互为变形词，字符串中字符种类和数目相同的字符串，互为变形词
遍历字符串，统计每个字符的频次以及对应的种类--可以用桶以及哈希表来实现
    
    
2、字符串长度为N，整数i，将字符串str[0--i]部分移动到右边，str[i+1--N-1]部分移动到左边
要求时间复杂度为O(N) 空间复杂度是O(1){也就是说只能进行原地调整}
将左、右部分分别原地逆序，再整体逆序
字符串的局部逆序函数
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

3、给定两棵树，头结点分别是t1和t2，判断t1中是否含有与t2拓扑结构完全相同的子树
二叉树遍历+匹配 	   找t1中的子树(从t1的某个子节点开始)，是否和t2的拓扑结构相同
转化为字符串的解法：将t1和t2序列化向对应的字符串s1和s2，看s1中是否包含s2
如果s1包含s2，那么说明t1中的某个子树和t2子树拓扑结构相同，否则t1中不包含t2子树
树的序列化为字符串，就是树的遍历方式的改编
	public static String serialBypreOrderTravversal(TreeNode t){
		if(t == null)
			return "#!";
		String s = t.val + "!";
		s += serialBypreOrderTravversal(t.left);
		s += serialBypreOrderTravversal(t.right);
		return s;
	}
	代码实现
	public boolean chkIdentical(TreeNode stra, TreeNode strb){
		String s1 = serialBypreOrderTravversal(stra);
		String s2 = serialBypreOrderTravversal(strb);
		return s1.contains(s2);
	}
	字符串序列化 -- 就是树的某种遍历方式的修改
	 注意要加结束标志!(特殊字符)


5、对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的,请返回拼接成的串
不能直接按照字典序进行拼接
例如 "ba" "b"  按照字典序拼接 "bba"
但是"bab"的字典序小于"bba"
所以按照如下规则进行拼接 str1、str2，比较str1 + str2 与 str2 + str1组成的字符串的字典序
str1 + str2 字典序< str2 + str1则，str1在前，str2在后 
str1 + str2 字典序> str2 + str1则，str2在前，str1在后 
	public class MyComparator implements Comparator {
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}


*/
	
