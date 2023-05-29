/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

// file source code của class TestFraction

import java.util.*;
import java.io.*;

public class TestFraction
{
	
	public static void main (String[] args)
	{
		Fraction frac1, frac2;
		frac1 = new Fraction();
		frac2 = new Fraction();
		
		Scanner sc = new Scanner(System.in);
		
		//dùng try - finally để tránh tìnht trạng "resource leak"
		try
		{
			System.out.print("Nhap vao tu so thu nhat: ");
			int num1 = sc.nextInt();
			frac1.setNum(num1);
			
			int den1 = 0;
			while (den1 == 0)
			{
				System.out.print("Nhap vao mau so thu nhat: ");
				den1 = sc.nextInt();
			}
			frac1.setDen(den1);
			
			System.out.print("Nhap vao tu so thu hai: ");
			int num2 = sc.nextInt();
			frac2.setNum(num2);
			
			int den2 = 0;
			while (den2 == 0)
			{
				System.out.print("Nhap vao mau so thu nhat: ");
				den2 = sc.nextInt();
			}
			frac2.setDen(den2);
			
			frac1.getLowest(num1, den1);
			frac2.getLowest(num2, den2);
			frac1.getInvert(num1, den1);
			frac2.getInvert(num2, den2);
			
			frac2.addFraction(num1, den1, num2, den2);
			frac2.subtractFraction(num1, den1, num2, den2);
			frac2.multipleFraction(num1, den1, num2, den2);
			frac2.divideFraction(num1, den1, num2, den2);
			frac2.compareFraction(num1, den1, num2, den2);
		}
		
		finally 
		{
			sc.close(); //giải phóng Scanner sau khi nhập liệu --> không bị leak
		}
		
		System.out.print("\n" +  frac1.toString1() + frac2.toString1() + frac2.toString2() + "\n");
	}
}