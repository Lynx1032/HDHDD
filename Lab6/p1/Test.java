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

			System.out.print("Radius: ");
			double radius = sc.nextDouble();
			
			System.out.print("Height: ");
			double height = sc.nextDouble();
			
			Cylinder cylinder = new Cylinder(radius, height, color);
			
			cylinder.getVolume();
			
			cylinder.display();
		}
		
		finally 
		{
			sc.close();
		}
	}
}