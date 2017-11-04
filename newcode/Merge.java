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
		// map�Ǽ�ֵ�Դ�����ʽ������price ֵ��һ��ArrayList,�����ͬprice��Ӧ������
		for (int i = 0; i < data.length; i++) {
			int price = data[i][2];
			Interval tmp = new Interval(data[i][0], data[i][1], price); //������ͼ۸��װΪInterval����
			ArrayList<Interval> list = map.get(price);
			if(list == null)
				list = new ArrayList<>();
			list.add(tmp);
			map.put(price, list);
		} // �����ͬ�۸�����䱻�ŵ�ͬһ��ArrayList<Interval>��
		
		ArrayList<Interval> result = new ArrayList<>(); //������ս��
		for (ArrayList<Interval> ele : map.values()) {  //����ÿһ�������ͬ�۸��ArrayList<Interval> ele
			Collections.sort(ele);  //�������� ��� ��ֵ��������
			Interval curr = ele.get(0);
			int price = curr.price;
			int leftEdge = curr.left;
			int maxRightEdge = curr.right;
			for(int i = 1; i < ele.size(); i++){
				Interval temp = ele.get(i);
				/* maxRightEdge�����ϴμ������������Ҷ˵�ֵ
				 * �����ǰ��������ֵС�ڵ���maxRightEdge������maxRightEdge+1���ڵ�ǰ���������˵�ֵ��
				 * ����ϲ����������������������Ҷ˵����ֵmaxRightEdge
				 * */
				if(temp.left <= maxRightEdge || maxRightEdge+1 == temp.left) 
					maxRightEdge = maxRightEdge >= temp.right ? maxRightEdge : temp.right;
					//�������������Ҷ˵����ֵmaxRightEdge
				
				else{ 
				//������ϲ�����������һ���������result�У���ʹcurr��leftEdge��maxRightEdge����Ϊ��ǰ�����ֵ
					result.add(new Interval(leftEdge, maxRightEdge, price));
					curr = ele.get(i);
					leftEdge = curr.left;
					maxRightEdge = curr.right;
				}
			}
			result.add(new Interval(leftEdge, maxRightEdge, price)); //������������
		}
		for(int i = 0;i < result.size()-1; i++)  //��ӡ���
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
class Interval implements Comparable<Interval>{  //��������ʵ��Comparable�ӿڣ������䰴��˵�ֵ��������
	int left;
	int right;
	int price;
	public Interval(int left, int right, int price){  // Constructor
		this.left = left;
		this.right = right;
		this.price = price;
	}
	@Override
	public int compareTo(Interval o) {  //�����������˵�ֵ�������������
		if(this.left > o.left)
			return 1;
		else if(this.left < o.left)
			return -1;
		else 
			return 0;
	}
	@Override
	public String toString() { //��дtoString������������Ϣ
		return "[" + left + ", " + right + ", " + price +  "]";
	}
}
