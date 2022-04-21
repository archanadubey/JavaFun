package ArrayToDo1;

public class QuandranticEquation {
	
	public static void main(String[] args) {
		
	
	int num1=18,num2=55,num3=8;
	if (num1>num2 && num1>num3) {
		
		System.out.println("num1 is the greater numer "+num1);
	
	}else if (num2>num3 && num2>num3 ){
		
		System.out.println("num2 is the greater numer "+num2);
	}else 
		System.out.println("num3 is the greater numer "+num3);
	
	
	// write a programme to find the prime number of any given number 
	int num=48;
	 
	boolean flag=true;
	for(int i=2;i<=num/2;i++) {
		if(num%i==0) {
		flag=false;
		break;
		}
	
	}
	
	if(!flag) {
		System.out.println("number is prime "+num);
	}
	else {
		System.out.println("number is not prime "+num);
	}
	}
	
}