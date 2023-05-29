/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

// file source code của class TestPoint

import java.util.*;
import java.io.*;

public class TestPoint
{
	
	public static void main (String[] args)
	{
		Point point1, point2;
		point1 = new Point();
		point2 = new Point();
		
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("Nhap vao toa do x diem thu nhat: ");
			double x1 = sc.nextDouble();
			point1.setX(x1);
			
			System.out.print("Nhap vao toa do y diem thu nhat: ");
			double y1 = sc.nextDouble();
			point1.setY(y1);
			
			System.out.print("Nhap vao toa do x diem thu hai: ");
			double x2 = sc.nextDouble();
			point2.setX(x2);
			
			System.out.print("Nhap vao toa do y diem thu hai: ");
			double y2 = sc.nextDouble();
			point2.setY(y2);
			
			point2.getDistance(x1, y1, x2, y2);
		}
		
		finally 
		{
			sc.close();
		}
		
		System.out.print("\n" +  point1.toString1() + point2.toString1() + "\n" + point2.toString2());
	}
}