package newcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

/* 	1 1 100
	2 3 100
	4 5 110
 * */
public class Merge {
	public static void mergeInterval(int[][] data){
		TreeMap<Integer, ArrayList<Interval>> map = new TreeMap<>();
		// map是键值对处的形式，键是price 值是一个ArrayList,存放相同price对应的区间
		for (int i = 0; i < data.length; i++) {
			int price = data[i][2];
			Interval tmp = new Interval(data[i][0], data[i][1], price); //将区间和价格封装为Interval对象
			ArrayList<Interval> list = map.get(price);
			if(list == null)
				list = new ArrayList<>();
			list.add(tmp);
			map.put(price, list);
		} // 最后相同价格的区间被放到同一个ArrayList<Interval>中
		
		ArrayList<Interval> result = new ArrayList<>(); //存放最终结果
		for (ArrayList<Interval> ele : map.values()) {  //对于每一个存放相同价格的ArrayList<Interval> ele
			Collections.sort(ele);  //按照区间 左端 的值进行排序
			Interval curr = ele.get(0);
			int price = curr.price;
			int leftEdge = curr.left;
			int maxRightEdge = curr.right;
			for(int i = 1; i < ele.size(); i++){
				Interval temp = ele.get(i);
				/* maxRightEdge代表上次计算后区间的最右端的值
				 * 如果当前区间的左端值小于等于maxRightEdge，或者maxRightEdge+1等于当前区间的最左端的值，
				 * 满足合并条件，并更新两个区间右端的最大值maxRightEdge
				 * */
				if(temp.left <= maxRightEdge || maxRightEdge+1 == temp.left) 
					maxRightEdge = maxRightEdge >= temp.right ? maxRightEdge : temp.right;
					//更新两个区间右端的最大值maxRightEdge
				
				else{ 
				//不满足合并条件，将上一个区间放入result中，并使curr、leftEdge、maxRightEdge更新为当前区间的值
					result.add(new Interval(leftEdge, maxRightEdge, price));
					curr = ele.get(i);
					leftEdge = curr.left;
					maxRightEdge = curr.right;
				}
			}
			result.add(new Interval(leftEdge, maxRightEdge, price)); //放入最后的区间
		}
		for(int i = 0;i < result.size()-1; i++)  //打印结果
			System.out.print(result.get(i) + ",");
		System.out.println(result.get(result.size()-1));
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int cnt = in.nextInt();
			int[][] data = new int[cnt][3];
			for (int i = 0; i < data.length; i++) 
				for (int j = 0; j < 3; j++) 
					data[i][j] = in.nextInt();
			mergeInterval(data);
		}
		in.close();
	}
}
class Interval implements Comparable<Interval>{  //定义区间实现Comparable接口，对区间按左端的值进行排序
	int left;
	int right;
	int price;
	public Interval(int left, int right, int price){  // Constructor
		this.left = left;
		this.right = right;
		this.price = price;
	}
	@Override
	public int compareTo(Interval o) {  //按照区间的左端的值的升序进行排序
		if(this.left > o.left)
			return 1;
		else if(this.left < o.left)
			return -1;
		else 
			return 0;
	}
	@Override
	public String toString() { //重写toString便于输出类的信息
		return "[" + left + ", " + right + ", " + price +  "]";
	}
}
