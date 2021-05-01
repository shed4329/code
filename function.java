/*
	介绍：
	求函数y=x^2在0<x<某个正数的范围内抛物线与x轴围成的面积（会有一点误差，精度问题）
*/

public class function{
	public static void main(String[] args){
		System.out.println("已开始");
		double result=0;
		double i = 0;
		for(i=0;i<=16.0;i+=0.01){
		//在0到16的范围里，将面积切割成一个个长条相加
			double j = i*i*0.01;
			result+=j;
		}
		System.out.println("函数y=x^2在0<x<"+i+"的范围内，抛物线线与x轴围成的面积约为"+result);
	}
}