package hw_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
/* 有m个人去接酒，共有n个龙头，每个人的接酒量是w[i],
 * */
public class Beer {
	public static int drinkBeer(ArrayList<Integer> vols, int numOfBucket){
		if(vols.size() <= numOfBucket) //当接酒的人数小于龙头的数目，直接返回酒量最大值
			return getMaxVol(vols);
		
		LinkedList<Integer> queue = new LinkedList<>();  //所有元素入队列
		for(Integer vol : vols)
			queue.add(vol);
		
		ArrayList<Integer> beerVols = new ArrayList<>();  //从队列取出元素，为每个空闲龙头分配一个人
		for (int i = 0; i < numOfBucket; i++)
			beerVols.add(queue.poll());
		
		int totalTime = 0;
		while(!queue.isEmpty()){  // 队列不为空就循环
			int min = getMinVol(beerVols);   // 取出接酒的人中接酒量的最小值
			totalTime += min;
			ArrayList<Integer> tempVols = beerVols;
			beerVols = new ArrayList<>();
			for(Integer vol : tempVols){   
				Integer v = vol - min;
				if(v > 0) //去除重复元素
					beerVols.add(v);
			}
			int cnt = numOfBucket - beerVols.size();
			for(int i = 0; i < cnt; i++){
				if(!queue.isEmpty())
					beerVols.add(queue.poll());
				else
					break;
			}
		}
		if(beerVols.size() > 0)
			return totalTime + getMaxVol(beerVols);
		else
			return totalTime;
	}
	public static int getMinVol(ArrayList<Integer> vols){
		return Collections.min(vols);
	}
	public static int getMaxVol(ArrayList<Integer> vols){
		return Collections.max(vols);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int numOfPerson = in.nextInt();
			int numOfBucket = in.nextInt();
			ArrayList<Integer> vols = new ArrayList<>();
			for (int i = 0; i < numOfPerson; i++) 
				vols.add(in.nextInt());
			int result = drinkBeer(vols, numOfBucket);
			System.out.println(result);
		}
		in.close();
	}
}
