/*
	���ܣ�
	����y=x^2��0<x<ĳ�������ķ�Χ����������x��Χ�ɵ����������һ�����������⣩
*/

public class function{
	public static void main(String[] args){
		System.out.println("�ѿ�ʼ");
		double result=0;
		double i = 0;
		for(i=0;i<=16.0;i+=0.01){
		//��0��16�ķ�Χ�������и��һ�����������
			double j = i*i*0.01;
			result+=j;
		}
		System.out.println("����y=x^2��0<x<"+i+"�ķ�Χ�ڣ�����������x��Χ�ɵ����ԼΪ"+result);
	}
}