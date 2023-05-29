/*
Nhóm 2A
Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

#include <stdio.h>
#include <conio.h>

int findGCD(int a, int b)
{
	int gcd = 0;
		for (int i = 1; i <= a; i++)
		{
			if ((a % i == 0) && (b % i == 0))
			{
				gcd = i;
			}
		}
		
		return gcd;
}

int main()
{
	int a, b;
	printf("Nhap vao so thu nhat: ");
	scanf("%d",&a);
	printf("Nhap vao so thu hai: ");
	scanf("%d",&b);
	
	printf("Uoc chung lon nhat cua %d va %d la: %d\n\n", a, b, findGCD(a,b));
	
	getchar();
	return 0;
}