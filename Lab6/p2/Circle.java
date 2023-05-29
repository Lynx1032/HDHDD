/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//source code của class Circle

public class Circle extends Shape
{
	protected double circle_radius;
	
	public Circle()
	{
		circle_radius = 0;
	}
	
	public Circle(double _radius)
	{
		circle_radius = _radius;
	}
	
	public Circle(double _radius, String _color, boolean _filled)
	{
		super(_color, _filled);
		circle_radius = _radius;
	}
	
	public void setRadius(double radius)
	{
		circle_radius = radius;
	}
	
	/*
	public void setColor(String color)
	{
		circle_color = color;
	}
	*/

	public double getRadius()
	{
		return circle_radius;
	}
	
	/*
	public String getColor()
	{
		return circle_color;
	}
	*/
	
	public double getArea()
	{
		area = Math.pow(pi, 2)*circle_radius;
		
		//Làm tròn kết quả đến 3 chữ số thập phân
		area = Math.round(area*1000);
		area = area/1000;
		
		return area;
	}
	
	public double getPerimeter()
	{
		perimeter = 2*pi*circle_radius;
		
		perimeter = Math.round(perimeter*1000);
		perimeter = perimeter/1000;
		
		return perimeter;
	}
	
	public String toString()
	{		
		String cricle_info = "\nCircle[color=" + shape_color + ",filled=" + shape_filled + ",radius=" + Double.toString(circle_radius) + ",area=" + getArea() + ",perimeter=" + getPerimeter() + "]";
		
		return cricle_info;
	}
}