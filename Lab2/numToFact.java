/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

/*
 Xây dựng chương trình để phân tích số tự nhiên n thành các thừa số nguyên tố
với n nhập từ bàn phím và có ràng buộc điều kiện phù hợp
*/

import java.util.*;
import java.io.*;
import java.lang.Math;

public class numToFact
{
	static void findFact(int n)
	{
		//Tìm các thừa số nguyên tố chính
		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			while (n % i == 0)
			{
				System.out.print(" " + i);
				n /= i;
			}
		}
		
		//In phần dư khác 0, 1 còn lại 
		if ((n != 0) && (n != 1))
			{
				System.out.print(" " + n);
			}
	}
  
	public static void main(String[] args)
	{
		int n = -1;
		
		//Ràng buộc điều kiện số vừa nhập là số tự nhiên lớn hơn 0
		while (n <= 0)
		{
			System.out.print("Nhap 1 so tu nhien lon hon 0: ");
		
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			
			//Nếu điều kiện không thỏa, yêu cầu người dùng nhập lại.
			if (n <= 0)
			{
				System.out.println("So vua nhap khong hop le, vui long nhap lai!");
			}
			
			//Nếu điều kiện thỏa, tính toán thừa số nguyên tố của N
			else
			{
				System.out.print("Thua so nguyen to cua " + n + " la");
				findFact(n);
			}
		}
	}
}
