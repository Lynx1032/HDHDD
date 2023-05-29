/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//File source code của Test - file thực thi chính

import java.util.*;
import java.io.*;

public class Test
{
	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Color: ");
			String color = sc.nextLine();
			
			System.out.print("Filled? [true/false]: ");
			boolean filled = sc.nextBoolean();

			System.out.print("Radius: ");
			double radius = sc.nextDouble();
			
			System.out.print("Width: ");
			double width = sc.nextDouble();
			
			System.out.print("Length: ");
			double length = sc.nextDouble();
			
			System.out.print("Side: ");
			double side = sc.nextDouble();
			
			//Shape shape = new Shape();
			Shape circle = new Circle(radius, color, filled);
			Shape rec = new Rectangle(width, length, color, filled);
			Shape sqr = new Square(side, color, filled);
			
			System.out.print(circle.toString() + rec.toString() + sqr.toString());
		}
		
		finally 
		{
			sc.close();
		}
	}
}