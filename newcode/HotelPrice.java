package newcode;
import java.util.*;
/* ţ������ȥ�Ķ������-���Ƶ�۸�
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
		//ʵ���Ͼ�������
		int raw = dateRangePrices.length;
		int temp;
		//��������������ݰ���ʱ������
		for(int i=0; i<raw-1; i++){
			for(int j=0; j<raw-i-1; j++){
				if(dateRangePrices[i][0]>dateRangePrices[i+1][0]){
					temp = dateRangePrices[i][0];
					dateRangePrices[i][0] = dateRangePrices[i+1][0];
					dateRangePrices[i+1][0] = temp;
					
				}
			}
		}
		//�жϲ��ϲ���ע�����һ��Ԫ�ز�û�з��뼯�ϵ��У�ԭ����Ϊ�˱����ָ��
		for(int i=0; i<raw-1; i++){
			//���ڽ����ţ��Ҽ۸���ͬ
			if(((dateRangePrices[i+1][0]-dateRangePrices[i][1])<=1) && dateRangePrices[i][2]==dateRangePrices[i+1][2]){
				dateRangePrices[i][1] = dateRangePrices[i+1][1];
				dateRangePrices[i+1] = dateRangePrices[i];
			}
			//����Set����ȥ��
			set.add(dateRangePrices[i]);
		}
		//�����һ��Ԫ�ط��뼯�ϵ���
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
