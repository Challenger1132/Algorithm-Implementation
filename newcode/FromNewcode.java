package newcode;
import java.util.*;
public class FromNewcode {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()) {
			int[] price = new int[10001];
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			while (cin.hasNextInt()) {
				int b = cin.nextInt(), e = cin.nextInt(), p = cin.nextInt();
				for (int i = b; i <= e; ++i)
					price[i] = p;
				if (b < min)
					min = b;
				if (e > max)
					max = e;
			}
		System.out.print("[" + min + ", ");
		for (int i = min + 1, pre = price[min]; i < max; ++i) {
			int cur = price[i];//比较前一点个当前点的价格，如果不一样，说明这是一个划分点
			if (cur != pre) {//前一个点不为0，说明前一个点是一个右闭区间
				if (pre != 0) 
					System.out.print(i - 1 + ", " + pre + "],");
				//当前点不为0，说明当前点是一个左闭区间
				if (cur != 0)
					System.out.print("[" + i + ", ");
			}
			pre = cur;
		}
		System.out.println(max + ", " + price[max] + "]");
		}
		cin.close();
	}
}