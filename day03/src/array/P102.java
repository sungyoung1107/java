package array;

public class P102 {

	public static void main(String[] args) {
		
		int a = 100; //primitive type
		
//		int arr[] = new int[3]; //reference type(String...)
		// int []arr = new int[3]; 도 가능
		
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
		
		int arr[] = {10,20,30};
		
		System.out.println("Type 1");
		for (int i =0 ; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("Type 2");
		for (int k : arr) { // 오른쪽은 배열의 집합체 // 집합체에 들어가 있는 데이터 타입과 변수명 지정
			System.out.println(k);
		}

	}

}
