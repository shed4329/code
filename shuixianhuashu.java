import java.lang.Math;

/*
	关于水仙花数
		https://baike.baidu.com/item/%E6%B0%B4%E4%BB%99%E8%8A%B1%E6%95%B0/2746160?fr=aladdin
	水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。
*/

	public class shuixianhuashu{
		public static void main(String[] args){
			System.out.println("已开始");
			for(int i =100;i<=999;i++){
				double first = (i/100);
				int fistNum = (int)Math.floor(first);
				double second = (i-(fistNum*100))/10;
				int secondNum = (int)Math.floor(second);
				int third = (i-(fistNum*100)-(secondNum*10))/1;
				int thirdNum = third;
				if(result(fistNum,secondNum,thirdNum) == i){
					System.out.println(i+"是水仙花数");
			}
		}
		}
		public static int result(int a,int b,int c){
			int result = (a*a*a)+(b*b*b)+(c*c*c);
			return result;
		}
}