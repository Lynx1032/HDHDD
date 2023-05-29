/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

/*
Xây dựng chương trình tính tổng các chữ số của số tự nhiên n với n nhập từ
bàn phím và có ràng buộc điều kiện phù hợp
*/

import java.util.*;
import java.io.*;
import java.lang.Math;

public class sumofDigits
{
	static int findSum(int n)
	{
		int res = 0;
		
		//Chuyển số vừa nhập về dạng chuỗi
		String string_number = Integer.toString(n);
		
		for (int i = 0; i < string_number.length(); i++) 
		{
			//Chuyển số ở vị trí i trong chuỗi về lại dạng số và cộng dồn vào kết quả
			int digit = string_number.charAt(i) - '0';
			res += digit;
		}
		
		return res;
	}
	
	public static void main (String[] args)
	{
		int n = -1;
		
		//Ràng buộc điều kiện số vừa nhập là số tự nhiên lớn hơn hoặc bằng 0
		while (n < 0)
		{
			System.out.print("Nhap 1 so tu nhien lon hon hoac bang 0: ");
		
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			
			//Nếu điều kiện không thỏa, yêu cầu người dùng nhập lại.
			if (n < 0)
			{
				System.out.println("So vua nhap khong hop le, vui long nhap lai!");
			}
			
			//Nếu điều kiện thỏa, tính toán tổng các chữ số của N
			else
			{
				System.out.print("Tong cac chu so cua " + n + " la " + findSum(n));
			}
		}
	}
}