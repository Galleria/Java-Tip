
public class testFinallyReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( finallyMethod() );
	}

	
	public static int finallyMethod(){
		int num = 100;
		try{
			num ++ ;
			return num;
		}
		finally{
			num++ ;
			System.out.println( "finallyMethod() "+num );
		}
		//return num;
		
	}
}
