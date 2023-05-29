/*
Nhóm 2A
Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

void randomElements(int A[], int size)
{
	for(int i = 0; i < size; i++)
	{
		A[i]= rand()%100;
	}
}

void printArray(int A[], int size) 
{
    printf("Cac phan tu cua mang la: ");
    for (int i = 0; i < size; i++) 
	{
        printf("%d\t", A[i]);
    }
    printf("\n");
}

void insertionSort(int A[], int size) 
{
	for (int i = 1; i < size; i++) 
	{
		int key = A[i];
		int j = i - 1;
		while (j >= 0 && A[j] > key) 
		{
			A[j + 1] = A[j];
			j--;
		}
		A[j + 1] = key;
	}
}

int binarySearch(int A[], int l, int r, int x)
{
    if (r >= l) {
        int mid = l + (r - l) / 2;
 
        if (A[mid] == x)
            return mid;
 
        if (A[mid] > x)
            return binarySearch(A, l, mid - 1, x);
 
        return binarySearch(A, mid + 1, r, x);
    }
 
    return -1;
}

int main()
{
	int size;
	printf("Nhap kich thuoc cua mang: ");
	scanf("%d", &size);
	
	int A[size];
	randomElements(A, size); //Tạo mảng ngẫu nhiên với kích thước đã cho và số phần tử nhỏ hơn 100
	
	insertionSort(A, size); //Sắp xếp lại mảng theo thứ tự theo yêu cầu khi dùng binary search
	printArray(A, size); //In
	
	int x;
	printf("Nhap so can tim: ");
	scanf("%d", &x);
	
	int res = binarySearch(A, 0, size - 1, x);
	
	if (res == -1)
	{
		printf("So can tim khong ton tai trong mang!\n");
	}
	else
	{
		printf("%d nam o vi tri %d trong mang\n", x, res);
	}
	
	getchar();
	return 0;
}