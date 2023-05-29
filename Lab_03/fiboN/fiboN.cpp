/*
Nhóm 2A
Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

#include <stdio.h>
#include <conio.h>

int fibo_Dequy(int n)
{
    if (n <= 1)
	{
        return n;
	}
	
    return fibo_Dequy(n - 1) + fibo_Dequy(n - 2);
}

//Dùng 2 số liền trước để tìm số sau - nguyên tắc của dãy Fibo
int fibo_Khudequy(int n)
{
	int a = 0, b = 1, c, i; //khởi tạo 2 số đầu tiên trong dãy: 0, 1
	
	//trả kết quả về là 0 nếu phân tử cần tìm là vị trí 0 - vị trí đầu trong dãy
	if( n == 0)
	{
		return a;
	}
	
	//tìm số liền sau cho tới vị trí cần tìm, bắt đầu từ vị trí 2, do đã có 0, 1
	for (i = 2; i <= n; i++)
	{
		c = a + b; //tìm số liền sau
		a = b; //đẩy số lên đầu để có bộ 2 số mới và lặp lại việc tính toán
		b = c;
	}
	
	return b; //trả kết quả về, mặc định là 1 nếu n = 1
}

int main()
{
	int n = -1;
	
	while (n < 0)
	{
		printf("Nhap vi tri muon tim: ");
		scanf("%d",&n);
		
		if (n < 0)
		{
		printf("So vua nhap khong hop le, vui long nhap lai!\n\n");
		}
		else
		{
		printf("Phan tu thu %d cua day fibo (de quy): %d\n", n, fibo_Dequy(n));
		printf("Phan tu thu %d cua day fibo (khu de quy): %d\n\n", n, fibo_Khudequy(n));
		}
	}
	getchar();
	return 0;
}