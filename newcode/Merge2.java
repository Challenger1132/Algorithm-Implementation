package newcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/* 	1 1 100
	2 3 100
	4 5 110
 * */
public class Merge2 {
	public static void mergeInterval(ArrayList<Interval2> arr){
		TreeMap<Integer, ArrayList<Interval2>> map = new TreeMap<>();
		for (int i = 0; i < arr.size(); i++) {
			Interval2 interval = arr.get(i);
			int price = interval.price;
			Interval2 tmp = new Interval2(interval.left, interval.right, price);
			ArrayList<Interval2> list = map.get(price);
			if(list == null)
				list = new ArrayList<>();
			list.add(tmp);
			map.put(price, list);
		}
		
		ArrayList<Interval2> result = new ArrayList<>();
		for (ArrayList<Interval2> ele : map.values()) {
			Collections.sort(ele);
			Interval2 curr = ele.get(0);
			int price = curr.price;
			int leftEdge = curr.left;
			int maxRightEdge = curr.right;
			for(int i = 1; i < ele.size(); i++){
				Interval2 temp = ele.get(i);
				if(temp.left <= maxRightEdge || maxRightEdge+1 == temp.left)
					maxRightEdge = maxRightEdge >= temp.right ? maxRightEdge : temp.right;
				
				else{
					result.add(new Interval2(leftEdge, maxRightEdge, price));
					curr = ele.get(i);
					leftEdge = curr.left;
					maxRightEdge = curr.right;
				}
			}
			result.add(new Interval2(leftEdge, maxRightEdge, price));
		}
		
		Collections.sort(result, new Comparator<Interval2>() {
			@Override
			public int compare(Interval2 o1, Interval2 o2) {
				if(o1.price > o2.price)
					return 1;
				else if(o1.price < o2.price)
					return -1;
				else
					return 0;
			}
		});
		for(int i = 0;i < result.size()-1; i++)
			System.out.print(result.get(i) + ",");
		System.out.println(result.get(result.size()-1));
		
		
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Interval2> intervals = new ArrayList<>();
		int cnt = in.nextInt();
			for(int i = 0; i < cnt; i++){
				int left = in.nextInt();
				int right = in.nextInt();
				int price = in.nextInt();
				intervals.add(new Interval2(left, right, price));
			}
			mergeInterval(intervals);
		in.close();
	}
}
class Interval2 implements Comparable<Interval2>{
	int left;
	int right;
	int price;
	public Interval2(int left, int right, int price){  // constructor
		this.left = left;
		this.right = right;
		this.price = price;
	}
	@Override
	public int compareTo(Interval2 o) {
		if(this.left > o.left)
			return 1;
		else if(this.left < o.left)
			return -1;
		else 
			return 0;
	}
	@Override
	public String toString() {
		return "[" + left + ", " + right + ", " + price +  "]";
	}
}
