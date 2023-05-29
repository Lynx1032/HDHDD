/*
Nhóm 2A
Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

#include <stdio.h>
#include <conio.h>

int giaiThuadequy(int n)
{
    if (n == 0)
	{
		return 1;
	}
	return n*giaiThuadequy(n-1);
}

void giaiThuaKhudequy(int n)
{
	int k = 1;
	for (int i = 2; i <= n; i++)
	{
		k = k*i;
	}
	printf("Khu de quy: %d! = %d\n\n", n, k);
}
 
int main()
{
    int n = -1;
	while (n < 0)
	{
		printf("Nhap so ban muon tinh giai thua: ");
		scanf("%d",&n);
		
		if (n < 0)
		{
		printf("So vua nhap khong hop le, vui long thu lai!\n\n");
		}
		else
		{
			printf("De quy: %d! = %d\n", n, giaiThuadequy(n)); 
			giaiThuaKhudequy(n);
		}
	}
	getchar();
	return 0;
}