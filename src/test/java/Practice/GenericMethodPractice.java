package Practice;

public class GenericMethodPractice {
	public static void main(String[] args) {
		
		int sum=add(10, 20);
		System.out.println(sum);
		System.out.println(add(sum, 30));
		System.out.println(add(30, 40));
		System.out.println(add(40, sum));
		int res=add(30, 50);
		System.out.println(res);
		
		int s= sub(40, 10);
		System.out.println("Substraction is : "+s);
		
		int m=mul(10, 10);
		System.out.println("Multiplication is : "+m);
		
		int d=div(44, 4);
		System.out.println("Division is : "+d);		
		
	}
	
	
	public static int add(int a, int b)  //Called function
	{
		int c= a+ b;
		return c;
	}
	
	public static int sub(int x, int y)
	{
		int sub=x - y;
		return sub;
	}
	
	public static int mul(int x, int y)
	{
		int m=x * y;
		return m;
	}
	
	public static int div(int x, int y)
	{
		int d=x/y;
		return d;
	}

}
