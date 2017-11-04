package newcode;
import java.util.*;
/* 牛客网：去哪儿编程题-》酒店价格
 */
public class HotelPrice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			int[][] dateRangePrices = new int[num][3];
			for(int i=0; i<num; i++){
				for(int j=0; j<3; j++){
					dateRangePrices[i][j] = sc.nextInt();
				}
			}
			int[][] result = merge(dateRangePrices);
			
			for(int i=0; i<result.length; i++){
				if(i==result.length-1){
					System.out.print(Arrays.toString(result[i]));
				}else{
					System.out.print(Arrays.toString(result[i]) + ",");
				}
			}
		}
		sc.close();
	}
	
	public static int[][] merge(int[][] dateRangePrices){
		Set<int[]> set = new LinkedHashSet<int[]>();
		//实际上就是行数
		int raw = dateRangePrices.length;
		int temp;
		//对输入的日期数据按照时间排序
		for(int i=0; i<raw-1; i++){
			for(int j=0; j<raw-i-1; j++){
				if(dateRangePrices[i][0]>dateRangePrices[i+1][0]){
					temp = dateRangePrices[i][0];
					dateRangePrices[i][0] = dateRangePrices[i+1][0];
					dateRangePrices[i+1][0] = temp;
					
				}
			}
		}
		//判断并合并，注意最后一个元素并没有放入集合当中，原因是为了避免空指针
		for(int i=0; i<raw-1; i++){
			//日期紧挨着，且价格相同
			if(((dateRangePrices[i+1][0]-dateRangePrices[i][1])<=1) && dateRangePrices[i][2]==dateRangePrices[i+1][2]){
				dateRangePrices[i][1] = dateRangePrices[i+1][1];
				dateRangePrices[i+1] = dateRangePrices[i];
			}
			//利用Set集合去重
			set.add(dateRangePrices[i]);
		}
		//将最后一个元素放入集合当中
		set.add(dateRangePrices[raw-1]);
		int size = set.size();
		int[][] result = new int[size][];
		Iterator<int[]> iter = set.iterator();
		/*for(int[] a : set){
			result[i] = a;
		}*/
		for(int i=0; i<set.size(); i++){
			result[i] = iter.next();
		}
		return result;
	}
}
/* 
4
1 100 100
2 5 100
100 200 100
400 600 300
[1, 5, 100],[100, 200, 100],[400, 600, 300]
 * */
