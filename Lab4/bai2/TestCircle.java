/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//File source code của TestCircle

import java.util.*;
import java.io.*;

public class TestCircle
{
	
	public static void main (String[] args)
	{
		Circle circle;
		circle = new Circle();
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Mau: ");
			String color = sc.nextLine();
			circle.setColor(color);

			System.out.print("Ban kinh: ");
			double radius = sc.nextDouble();
			circle.setRadius(radius);
			
			circle.getArea(radius);
		}
		
		finally 
		{
			sc.close();
		}

		System.out.print("\n" + circle.toString());
	}
}