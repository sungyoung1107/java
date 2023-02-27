package array;

import java.util.Arrays;
import java.util.Random;

public class P103 {

	public static void main(String[] args) {
		
		int arr[] = new int[10];
		
		Random rd = new Random();
		
		for (int i=0 ; i< arr.length ; i++) {
//			int data = rd.nextInt(99)+1; //1부터 99
//			arr[i]= data;
			
			arr[i] = rd.nextInt(99)+1;
		}
		
		for (int data : arr) {
			System.out.println(data);
		}
		
		System.out.println(Arrays.toString(arr));
		
		//배열의 합과 평균을 구하시오
		int sum=0;
		double avg=0;
		for (int a : arr) {		
			sum+=a;		
		}
		avg = sum/(arr.length*1.0);
		System.out.println("합은 "+ sum + " 평균은 "+ avg);

	}

}
