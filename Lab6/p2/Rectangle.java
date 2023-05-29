/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//Source code của class Rectangle

public class Rectangle extends Shape
{
	protected double rec_width;
	protected double rec_length;
	
	public Rectangle()
	{
		rec_width = 0;
		rec_length = 0;
	}
	
	public Rectangle(double _width, double _length)
	{
		rec_width = _width;
		rec_length = _length;
	}
	
	public Rectangle(double _width, double _length, String _color, boolean _filled)
	{
		super(_color, _filled);
		rec_width = _width;
		rec_length = _length;
	}
	
	public double getWidth()
	{
		return rec_width;
	}
	
	public void setWidth(double width)
	{
		rec_width = width;
	}
	
	public double getLength()
	{
		return rec_length;
	}
	
	public void setLength(double length)
	{
		rec_length = length;
	}
	
	public double getArea()
	{
		area = rec_width*rec_length;
		
		area = Math.round(area*1000);
		area = area/1000;
		
		return area;
	}
	
	public double getPerimeter()
	{
		perimeter = (rec_width + rec_length)*2;
		
		perimeter = Math.round(perimeter*1000);
		perimeter = perimeter/1000;
		
		return perimeter;
	}
	
	public String toString()
	{	
		String rec_info = "\nRectangle[color=" + shape_color + ",filled=" + shape_filled + ",width=" + Double.toString(rec_width) + ",length=" + Double.toString(rec_length) + ",area=" + getArea() + ",perimeter=" + getPerimeter() + "]";
		
		return rec_info;
	}
}