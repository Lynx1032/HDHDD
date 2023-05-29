/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//Source của class trừu trượng Shape

import java.lang.Math;

public abstract class Shape
{
	protected String shape_color;
	protected boolean shape_filled;
	double area;
	double perimeter;
	
	final double pi = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
	
	public Shape()
	{
		shape_color = "";
		shape_filled = false;
	}
	
	public Shape(String _color, boolean _filled)
	{
		shape_color = _color;
		shape_filled = _filled;
	}
	
	public String getColor()
	{
		return shape_color;
	}
	
	public void setColor(String color)
	{
		shape_color = color;
	}
	
	public boolean isFilled()
	{
		return shape_filled;
	}
	
	public void setFilled(boolean filled)
	{
		shape_filled = filled;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	
	public String toString()
	{
		String shape_info = "\nShape[color=" + shape_color + ",filled=" + Boolean.toString(shape_filled) + "]";
		
		return shape_info;
	}
}