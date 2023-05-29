/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

/*
Xây dựng chương trình để xuất ra màn hình n số nguyên tố đầu tiên với n nhập 
từ bàn phim
*/

import java.util.*;
import java.io.*;

public class nPrimeNum 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Ban muon xuat bao nhieu so: ");
		int n = Integer.parseInt(sc.nextLine());
		int num = 2;
		int count = 0;
		System.out.print(n + " so nguyen to dau tien:");
		
		while(count != n) 
		{
			boolean prime = true;
			for (int i = 2; i <= Math.sqrt(num); i++)
			{
				if (num % i == 0)
				{
					prime = false;
					break;
				}

			}
			if (prime) 
			{
				count++;
				System.out.print(" " + num);
			}
			num++;
		}
	}
}