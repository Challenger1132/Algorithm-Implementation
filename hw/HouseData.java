package hw;

import java.util.*;

public class HouseData {
	public static void merge(ArrayList<Interval> data){
		TreeMap<Integer, ArrayList<Interval>> map = new TreeMap<>();
		for (int i = 0; i < data.size(); i++) {
			Interval interval = data.get(i);
			int price = interval.price;
			ArrayList<Interval> arr = map.get(price);
			if(arr == null)
				arr = new ArrayList<>();
			arr.add(interval);
			map.put(price, arr);
		}  //实现数据的转换
		
		ArrayList<Interval> result = new ArrayList<>();
		for(ArrayList<Interval> list : map.values()){
			Collections.sort(list);
			Interval curr = list.get(0);
			int price = curr.price;
			int leftEdge = curr.left;
			int maxRightEdge = curr.right;
			for(int i = 1; i < list.size(); i++){
				Interval temp = list.get(i);
				if(temp.left <= maxRightEdge || maxRightEdge+1 == temp.left)
					maxRightEdge = maxRightEdge >= temp.right ? maxRightEdge : temp.right;
				else{
					result.add(new Interval(leftEdge, maxRightEdge, price));
					curr = list.get(i);
					leftEdge = curr.left;
					maxRightEdge = curr.right;
				}
			}
			result.add(new Interval(leftEdge, maxRightEdge, price));
		}
		// print
		Collections.sort(result);
		for (int i = 0; i < result.size()-1; i++) 
			System.out.print(result.get(i) + ",");
		System.out.println(result.get(result.size()-1));
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Interval> data = new ArrayList<>();
		while(in.hasNext()){
			int left = in.nextInt();
			int right = in.nextInt();
			int price = in.nextInt();
			data.add(new Interval(left, right, price));
		}
		merge(data);
		in.close();
	}
}
class Interval implements Comparable<Interval>{
	public Interval(int left, int right, int price) {
		super();
		this.left = left;
		this.right = right;
		this.price = price;
	}
	int left;
	int right;
	int price;
	@Override
	public String toString() {
		return "[" + left + ", " + right + ", " + price +  "]";
	}
	@Override
	public int compareTo(Interval interval){
		if(this.left > interval.left)
			return 1;
		else if(this.left < interval.left)
			return -1;
		else
			return 0;
	}
}