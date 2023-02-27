package array;

import java.util.Arrays;
import java.util.Random;

public class P105 {

	public static void main(String[] args) {
		
		int arr[] = new int[10];
		
		Random rd = new Random();
		
		for (int i=0 ; i< arr.length ; i++) {
			arr[i] = rd.nextInt(9)+1;
		}	
		
		System.out.println(Arrays.toString(arr));
		
		//배열의 합과 평균을 구하시오
		//홀수번째 합과 평균을 구하시오
		int sum=0;
		int count=0;
		double avg=0;
	
		for(int i=0;i<arr.length;i++) {
			if(i%2==0) {
				sum+=arr[i];
				count++;
			}
		}
		avg = sum/(count*1.0);
		System.out.println("합은 "+ sum + " 평균은 "+ avg);

	}

}
