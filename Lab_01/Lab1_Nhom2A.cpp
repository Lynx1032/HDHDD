/*
Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

#include <stdio.h>
#include <conio.h>

// Nhap mang
void nhapMang(float mang[], int n) {
    printf("Nhap cac phan tu cua mang:\n");
    for (int i = 0; i < n; i++) {
        printf("mang[%d] = ", i);
        scanf("%f", &mang[i]);
    }
}

// Xuat mang
void xuatMang(float mang[], int n) {
    printf("Cac phan tu cua mang la: ");
    for (int i = 0; i < n; i++) {
        printf("%.2f\t", mang[i]);
    }
    printf("\n");
}

// Hoán vị
void hoanVi(float* a, float* b) {
    float temp = *a;
    *a = *b;
    *b = temp;
}

// Tìm kiếm tuyến tính
int linearSearch(float mang[], int n, float x1) {
    for (int i = 0; i < n; i++) {
        if (mang[i] == x1) {
            return i;
        }
    }
    return -1;
}

// Tìm kiếm nhị phân
int binarySearch(float mang[], int n, float x2)
{
	int left = 0;
	int right = n - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
 
        if (mang[mid] == x2)
		{
            return mid;
		}
 
        if (mang[mid] < x2)
		{
            left = mid + 1;
		}
 
        else
		{
            right = mid - 1;
		}
    }
    return -1;
}

// Sắp xếp địa chỉ trực tiếp
void interchangeSort(float mang[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (mang[i] > mang[j]) {
                hoanVi(&mang[i], &mang[j]);
            }
        }
    }
}

// Sắp xếp nổi bọt
void bubbleSort(float mang[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (mang[j] > mang[j + 1]) {
                hoanVi(&mang[j], &mang[j + 1]);
            }
        }
    }
}

// Sắp xếp chọn trực tiếp
void selectionSort(float mang[], int n) {
    for (int i = 0; i < n - 1; i++) {
int minIndex = i;
for (int j = i + 1; j < n; j++) {
if (mang[j] < mang[minIndex]) {
minIndex = j;
}
}
if (minIndex != i) {
hoanVi(&mang[i], &mang[minIndex]);
}
}
}

// Sắp xếp chèn trực tiếp
void insertionSort(float mang[], int n) {
for (int i = 1; i < n; i++) {
float key = mang[i];
int j = i - 1;
while (j >= 0 && mang[j] > key) {
mang[j + 1] = mang[j];
j--;
}
mang[j + 1] = key;
}
}

// Sắp xếp nhanh
int partition(float mang[], int low, int high) {
float pivot = mang[high];
int i = low - 1;
for (int j = low; j <= high - 1; j++) {
if (mang[j] < pivot) {
i++;
hoanVi(&mang[i], &mang[j]);
}
}
hoanVi(&mang[i + 1], &mang[high]);
return i + 1;
}

void quickSort(float mang[], int low, int high) {
if (low < high) {
int pi = partition(mang, low, high);
quickSort(mang, low, pi - 1);
quickSort(mang, pi + 1, high);
}
}

// Hàm chính
int main() {
    int n;
    printf("Nhap so phan tu cua mang: ");
    scanf("%d", &n);

    float mang[n];
    nhapMang(mang, n);

    int choice;
    do {
        printf("\nMENU:\n");
        printf("1. Xuat mang\n");
        printf("2. Hoan vi\n");
        printf("3. Tim kiem tuyen tinh\n");
        printf("4. Tim kiem nhi phan\n");
        printf("5. Sap xep doi cho truc tiep\n");
        printf("6. Sap xep noi bot\n");
        printf("7. Sap xep chon truc tiep\n");
        printf("8. Sap xep chen truc tiep\n");
        printf("9. Sap xep nhanh\n");
        printf("0. Thoat\n");
        printf("Nhap lua chon cua ban: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                xuatMang(mang, n);
                break;
            case 2:
                {
                    int i, j;
                    printf("Nhap vi tri i: ");
                    scanf("%d", &i);
                    printf("Nhap vi tri j: ");
                    scanf("%d", &j);
                    hoanVi(&mang[i], &mang[j]);
                    printf("Sau khi hoan vi:\n");
                    xuatMang(mang, n);
                }
                break;
            case 3:
                {
                    float x1;
                    printf("Nhap gia tri can tim: ");
                    scanf("%f", &x1);
                    int index1 = linearSearch(mang, n, x1);
                    if (index1 == -1) {
                        printf("Khong tim thay gia tri %.2f trong mang.\n", x1);
                    } else {
                        printf("Gia tri %.2f co trong mang, o vi tri %d.\n", x1, index1);
                    }
                }
                break;
            case 4:
                {
                    float x2;
                    printf("Nhap gia tri can tim: ");
                    scanf("%f", &x2);
                    int index2 = binarySearch(mang, n, x2);
                    if (index2 == -1) {
                        printf("Khong tim thay gia tri %.2f trong mang.\nHay thu sap xep lai mang theo thu tu truoc va thu lai!", x2);
                    } else {
                        printf("Gia tri %.2f co trong mang, o vi tri %d.\n", x2, index2);
                    }
                }
                break;
            case 5:
                interchangeSort(mang, n);
                printf("Sau khi sap xep:\n");
                xuatMang(mang, n);
                break;
            case 6:
                bubbleSort(mang, n);
                printf("Sau khi sap xep:\n");
                xuatMang(mang, n);
                break;
            case 7:
                selectionSort(mang, n);
                printf("Sau khi sap xep:\n");
                xuatMang(mang, n);
                break;
            case 8:
                insertionSort(mang, n);
                printf("Sau khi sap xep:\n");
                xuatMang(mang, n);
                break;
            case 9:
                quickSort(mang, 0, n - 1);
                printf("Sau khi sap xep:\n");
                xuatMang(mang, n);
break;
case 0:
printf("Thoat chuong trinh.\n");
break;
default:
printf("Lua chon khong hop le.\n");
break;
}
} while (choice != 0);
return 0;
}

