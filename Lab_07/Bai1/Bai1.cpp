/*
Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/
// Heap Sort in C https://www.geeksforgeeks.org/heap-sort/
 
#include <stdio.h>
#include <conio.h>
 
// Hàm hoán đổi vị trí 2 phần tử trong mảng
 
void swap(int* a, int* b)
{
 
	int temp = *a;
 
	*a = *b;
 
	*b = temp;
}
 
// To heapify a subtree rooted with node i
// which is an index in arr[].
// n is size of heap
void heapify(int arr[], int N, int i)
{
    // Find largest among root, left child and right child
 
	// Initialize largest as root
    int largest = i;
 
    // left = 2*i + 1
    int left = 2 * i + 1;
 
    // right = 2*i + 2
    int right = 2 * i + 2;
 
    // If left child is larger than root
    if (left < N && arr[left] > arr[largest])
 
        largest = left;
 
    // If right child is larger than largest
    // so far
    if (right < N && arr[right] > arr[largest])
 
        largest = right;
 
    // Swap and continue heapifying if root is not largest
    // If largest is not root
    if (largest != i) {
 
        swap(&arr[i], &arr[largest]);
 
        // Recursively heapify the affected
        // sub-tree
        heapify(arr, N, largest);
    }
}
 
// Hàm chính của thuật toán Heapsort
void heapSort(int arr[], int N)
{
 
    // Build max heap
    for (int i = N / 2 - 1; i >= 0; i--)
 
        heapify(arr, N, i);
 
    // Heap sort
    for (int i = N - 1; i >= 0; i--) {
 
        swap(&arr[0], &arr[i]);
 
        // Heapify root element to get highest element at
        // root again
        heapify(arr, i, 0);
    }
}
 
// In mảng
void printArray(int arr[], int N)
{
    for (int i = 0; i < N; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

// Khởi tạo mảng với các giá trị mặc định là 0
void initArray(int arr[], int N)
{
    for (int i = 0; i < N; i++)
        arr[i] = 0;
}

// Nhập vào các phần tử của mảng
void inputArray(int arr[], int N) {
    printf("Nhap cac phan tu cua mang:\n");
    for (int i = 0; i < N; i++) {
        while (arr[i] <= 0)
		{
			printf("arr[%d] = ", i);
			scanf("%d", &arr[i]);
		}
    }
}
 
// Chương trình chính
int main()
{
    int N;
	printf("Nhap so phan tu cua mang: ");
	scanf("%d", &N);
	int arr[N];

    // Gọi hàm
	initArray(arr, N);
	inputArray(arr, N);
	printf("Mang khi chua sap xep: ");
    printArray(arr, N);
    heapSort(arr, N);
    printf("Mang khi da sap xep: ");
    printArray(arr, N);
}