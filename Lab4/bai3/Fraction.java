/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//File source code của class Fraction

import java.lang.Math;

public class Fraction
{
	private int frac_num;
	private int frac_den;
	private String frac_lowest;
	private String frac_invert;
	private String frac_add;
	private String frac_subtract;
	private String frac_multiple;
	private String frac_divide;
	private String frac_compare;
	
	public Fraction()
	{
		frac_num = 0;
		frac_den = 1;
	}
	
	public void setNum(int num)
	{
		frac_num = num;
	}
	
	public void setDen(int den)
	{
		if (den == 0)
		{
			frac_den = 1;
		}
		else frac_den = den;
	}
	
	public int getNum()
	{
		return frac_num;
	}
	
	public int getDen()
	{
		return frac_den;
	}
	
	//Tìm UCLN của tử và mẫu
	static int gcd(int a, int b)
	{
		if (a == 0)
			return b;
		return gcd(b%a, a);
	}
	
	//Tối giản phân số
	public String lowest(int num, int den)
	{
		int common_factor = gcd(num, den);
		
		den = den/common_factor;
		num = num/common_factor;
		
		if (den < 0)
		{
			num *= -1;
			den *= -1;
		}
		
		String res = num + "/" + den;
		
		return res;
	}
	
	public void getLowest(int num, int den)
	{
		frac_lowest = ", toi gian: " + lowest(num, den);
	}
	
	//Nghịch đảo phân số
	public void getInvert(int num, int den)
	{
		int invert_num = den;
		int invert_den = num;
		
		frac_invert = ", nghich dao: " + lowest(invert_num, invert_den); //tối giản kết quả
	}
	
	//Tổng 2 phân số
	public void addFraction(int num1, int den1, int num2, int den2)
	{
		int den3 = gcd(den1, den2);
		
		den3 = (den1*den2) / den3;
		
		int num3 = (num1)*(den3/den1) + (num2)*(den3/den2);
		
		frac_add = "\nTong: " + lowest(num3, den3); //tối giản kết quả
	}
	
	//Hiệu 2 phân số
	public void subtractFraction(int num1, int den1, int num2, int den2)
	{
		int den4 = gcd(den1,den2);
		
		den4 = (den1*den2) / den4;

		int num4 = (num1)*(den4/den1) - (num2)*(den4/den2);
		
		frac_subtract = "\nHieu: " + lowest(num4, den4); //tối giản kết quả
	}
	
	//Nhân 2 phân số
	public void multipleFraction(int num1, int den1, int num2, int den2)
	{
		int num6 = num1*num2;
		int den6 = den1*den2;
		
		frac_multiple = "\nNhan: " + lowest(num6, den6); //tối giản kết quả
	}
	
	//Chia 2 phân số
	public void divideFraction(int num1, int den1, int num2, int den2)
	{
		int num7 = num1*den2;
		int den7 = den1*num2; //Nhân nghịch đảo
		
		frac_divide = "\nChia: " + lowest(num7, den7); //tối giản kết quả
	}
	
	//So sánh 2 phân số
	public void compareFraction(int num1, int den1, int num2, int den2)
	{
		float value1 = (float)num1 / (float)den1;
		float value2 = (float)num2 / (float)den2;
		
		if (value1 > value2)
		{
			frac_compare = "\n" + num1 + "/" + den1 + " > " + num2 + "/" + den2;
		}
		else
		{
			if (value1 == value2)
			{
				frac_compare = "\n" + num1 + "/" + den1 + " = " + num2 + "/" + den2;
			}
			else frac_compare = "\n" + num1 + "/" + den1 + " < " + num2 + "/" + den2;
		}
	}

	public String toString1()
	{
		String res1 = "Phan so: " + frac_num + "/" + frac_den + frac_lowest + frac_invert + "\n";
		
		return res1;
	}
	
	public String toString2()
	{
		String res2 = frac_add + frac_subtract + frac_multiple + frac_divide + frac_compare;
		
		return res2;
	}
}