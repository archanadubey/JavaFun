package introductionArray;



public class FizzBuzz{


	public String fizzBuzz(int a ){
		
        String num="";



        if(a%3==0 && a%5==0){
            System.out.println("FizzBuzz");

            
        } else {
            if(a%5==0){
            System.out.println("Buzz");
            
            }else{
                if(a%3==0 ){
            System.out.println("Fizz");
            } else{

            	num=Integer.toString(a);

            }

            }
    }
        return num;

    }    
    
    public String fizzBuzz(int a, String multiOf3word,String multiOf5word,String multiOf15word) {
    	
    	
    	 String num="";



         if(a%3==0 && a%5==0){
            //System.out.println("multiOf15word");
        	 num="multiOf15word";

             
         } else {
             if(a%5==0){
             System.out.println("multiOf5word");
             
             }else{
                 if(a%3==0 ){
             System.out.println("multiOf3word");
             } else{

            	 num=Integer.toString(a);
             }

         }
     }
         return num;
    }

	
	}
        
       























//package introductionArray;
//
//public class CreatingArray {
//	
//	public static void main(String[] args) {
//		
//	
//	// Creating the array
//		int [] arr=new int[5];
//		arr[0]=10;
//		arr[1]=20;
//		arr[2]=30;
//		arr[3]=40;
//		arr[4]=50;
//		
//		for(int i=0;i<arr.length;i++) {
//			
//			System.out.println("ALl the Elements of the given array are "+i+":"+arr[i]);
//			
//		}
//				
//		// Java program to illustrate creating an array of objects
//		
//	
//	
//	
//	}	
//	
//	

//}
