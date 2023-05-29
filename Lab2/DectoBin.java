/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

/*
Xây dựng chương trình DectoBin để xuất ra màn hình giá trị nhị phân
tương ứng khi nhập một giá trị thập phân từ bàn phím
*/

import java.util.*;
import java.io.*;

class DectoBin
{
	static void decToBinary(int n)
	{
		int[] binaryNum = new int[1000];

		int i = 0;
		while (n > 0)
		{
			binaryNum[i] = n % 2;
			n = n / 2;
			i++;
		}

		for (int j = i - 1; j >= 0; j--)
			System.out.print(binaryNum[j]);
	}
	
	public static void main (String[] args)
	{
		
		System.out.print("Nhap 1 so thap phan: ");
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		System.out.println("Thap phan - " + n);
		System.out.print("Nhi phan - ");
		decToBinary(n);
	}
}