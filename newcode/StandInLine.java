package newcode;

/* n个人站队，他们的编号依次从1到n，要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？
 * 	--n个人的一个全排列 a在b左边的占一半，在b右边占一半， 因此是 n！/ 2
 * 第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法?
 *  -- (n-1)!
 * 给定人数n及两个人的编号a和b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。保证人数小于等于10。
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
