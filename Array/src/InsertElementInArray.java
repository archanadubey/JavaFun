import java.util.Arrays;

public class InsertElementInArray {
	
public static int [] arrX(int n , int [] arr, int y) {
	
	// Print the  origin Array
	
	System.out.println("Original Array "+ Arrays.toString(arr));
	
	//  create the new Array of size n 
	
	int newArr [] = new int[n+1];
	
	// Add the element to the new Array 
	
	for(int i =0;i<n;i++) {
		
		newArr[i] = arr[i];
		
		newArr[n]= y;
		
		
	}
	
	
	System.out.println("New Array "+ Arrays.toString(newArr));
	
  return newArr;
	
	
	
}

	public static void main(String[] args) {
		
		int n = 10;
		
		int [] arr = {1,2,4,3,6,5,9,8,7,10};
		// New Element to add.
		
		int x = 11;
		
		
		arrX(n , arr, x);
		

	}

}
