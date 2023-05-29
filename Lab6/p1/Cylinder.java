/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

//Source code của class Cylinder - kế thừa class Circle

public class Cylinder extends Circle
{
	double cylinder_height;
	double volume;
	
	public Cylinder()
	{
		cylinder_height = 0;
	}
	
	public Cylinder(double _radius)
	{
		super(_radius);
	}
	
	public Cylinder(double _radius, double _height)
	{
		super(_radius);
		cylinder_height = _height;
	}
	
	public Cylinder(double _radius, double _height, String _color)
	{
		super(_radius, _color);
		cylinder_height = _height;
	}
	
	public double getHeight()
	{
		return cylinder_height;
	}
	
	public void setHeight(double height)
	{
		cylinder_height = height;
	}
	
	public double getVolume()
	{
		volume = pi*Math.pow(circle_radius, 2)*cylinder_height;
		
		volume = Math.round(volume*1000);
		volume = volume/1000;
		
		return volume;
	}
	
	public void display()
	{
		String circle_info = toString();
		System.out.print(circle_info + "\nCylinder[color=" + circle_color + ",radius=" + circle_radius + ",height=" + cylinder_height + ",volume=" + volume + "]");
	}
}