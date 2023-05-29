/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//source code của class Cicre

import java.lang.Math;

public class Circle
{
	private double circle_radius;
	private String circle_color;
	private double area;
	
	//Khai báo hằng số pi với độ chính xác là 100 chữ số :))
	final private double pi = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
	
	public Circle()
	{
		circle_radius = 0;
		circle_color = "";
	}
	
	public void setRadius(double radius)
	{
		circle_radius = radius;
	}
	
	public void setColor(String color)
	{
		circle_color = color;
	}

	public double getRadius()
	{
		return circle_radius;
	}
	
	public String getColor()
	{
		return circle_color;
	}
	
	public double getArea(double radius)
	{
		area = Math.pow(pi, 2)*circle_radius;
		
		//Làm tròn kết quả đến 3 chữ số thập phân
		area = Math.round(area*1000);
		area = area/1000;
		
		return area;
	}
	
	public String toString()
	{
		String circle_info = "Duong tron mau " + circle_color + " co ban kinh: " + Double.toString(circle_radius) + ". Dien tich: " + Double.toString(area) + "\n";
		
		return circle_info;
	}
}