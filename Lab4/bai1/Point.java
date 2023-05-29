/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//source code của class Point

import java.lang.Math;

public class Point
{
	private double x_Point;
	private double y_Point;
	private double distance;
	
	public Point()
	{
		x_Point = 0;
		y_Point = 0;
	}
	
	public void setX(double x)
	{
		x_Point = x;
	}
	
	public void setY(double y)
	{
		y_Point = y;
	}

	public double getX()
	{
		return x_Point;
	}
	
	public double getY()
	{
		return y_Point;
	}
	
	public double getDistance(double x1, double y1, double x2, double y2)
	{
		distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		
		//Làm tròn kết quả đến 3 chữ số thập phân
		distance = Math.round(distance*1000);
		distance = distance/1000;
		
		return distance;
	}
	
	public String toString1()
	{
		String coordinate = "Toa do x = " + Double.toString(x_Point) + "; y = " + Double.toString(y_Point) + "\n";
		
		return coordinate;
	}
	
	public String toString2()
	{
		String dis_result = "Khoang cach giua 2 diem: " + Double.toString(distance) + "\n";
		
		return dis_result;
	}
}