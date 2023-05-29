/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//Source code của class Square

public class Square extends Rectangle
{	
	public Square()
	{
		double side = 0;
	}
	
	public Square(double _side)
	{
		super(_side, _side);
	}
	
	public Square(double _side, String _color, boolean _filled)
	{
		super(_side, _side, _color, _filled);
	}
	
	public double getSide()
	{
		return rec_length;
	}
	
	public void setSide(double side)
	{
		rec_length = side;
	}
	
	public void setWidth(double side)
	{
		rec_width = side;
	}
	
	public void setLength(double side)
	{
		rec_length = side;
	}
	
	public String toString()
	{	
		String sqr_info = "\nSquare[color=" + shape_color + ",filled=" + shape_filled + ",side=" + rec_length + ",area=" + getArea() + ",perimeter=" + getPerimeter() + "]";
		
		return sqr_info;
	}
}