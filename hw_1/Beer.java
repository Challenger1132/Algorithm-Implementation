package hw_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
/* ��m����ȥ�Ӿƣ�����n����ͷ��ÿ���˵ĽӾ�����w[i],
 * */
public class Beer {
	public static int drinkBeer(ArrayList<Integer> vols, int numOfBucket){
		if(vols.size() <= numOfBucket) //���ӾƵ�����С����ͷ����Ŀ��ֱ�ӷ��ؾ������ֵ
			return getMaxVol(vols);
		
		LinkedList<Integer> queue = new LinkedList<>();  //����Ԫ�������
		for(Integer vol : vols)
			queue.add(vol);
		
		ArrayList<Integer> beerVols = new ArrayList<>();  //�Ӷ���ȡ��Ԫ�أ�Ϊÿ��������ͷ����һ����
		for (int i = 0; i < numOfBucket; i++)
			beerVols.add(queue.poll());
		
		int totalTime = 0;
		while(!queue.isEmpty()){  // ���в�Ϊ�վ�ѭ��
			int min = getMinVol(beerVols);   // ȡ���ӾƵ����нӾ�������Сֵ
			totalTime += min;
			ArrayList<Integer> tempVols = beerVols;
			beerVols = new ArrayList<>();
			for(Integer vol : tempVols){   
				Integer v = vol - min;
				if(v > 0) //ȥ���ظ�Ԫ��
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
