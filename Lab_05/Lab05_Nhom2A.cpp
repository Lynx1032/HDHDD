/*
Nhóm 2A
Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>

struct Dish
{
	int dish_num;
	char dish_name[150];
	int dish_price;
};

typedef struct Dish DISH;

struct Node1
{
	DISH data;
	Node1 *next;
};

typedef struct Node1 NODE1;

struct Menu
{
	NODE1 *pHead;
	NODE1 *pTail;
};

typedef struct Menu MENU;

void initMenu(MENU &list)
{
	list.pHead = NULL;
	list.pTail = NULL;
}

NODE1* createNode1(DISH x)
{
	NODE1 *p;
	p = new NODE1;
	if (p == NULL)
	{
		printf("Khong du bo nho");
		return NULL;
	}
	p -> data = x;
	p -> next = NULL;
	return p;
}

struct Order
{
	int dish_num;
	int dish_qty;
	int dish_tPrice;
};

typedef struct Order ORDER;

struct Node2
{
	ORDER data;
	Node2 *next;
};

typedef struct Node2 NODE2;

struct orderLIST
{
	NODE2 *pHead2;
	NODE2 *pTail2;
};

typedef struct orderLIST ORDER_LIST;

void initOrder(ORDER_LIST &list2)
{
	list2.pHead2 = NULL;
	list2.pTail2 = NULL;
}

NODE2* createNode2(ORDER y)
{
	NODE2 *q = new NODE2;
	if (q == NULL)
	{
		printf("Khong du bo nho");
		return NULL;
	}
	q -> data = y;
	q -> next = NULL;
	return q;
}

int checkNULL(MENU list)
{
    if (list.pHead == NULL)
	{
        return 1;
    }
    return 0;
}

int checkNULL2(ORDER_LIST list2)
{
    if (list2.pHead2 == NULL)
	{
        return 1;
    }
    return 0;
}

void addDish(MENU &list, NODE1 *p)
{
	if (list.pHead == NULL)
	{
		list.pHead = p;
		list.pTail = p;
	}
	else
	{
		list.pTail -> next = p;
		list.pTail = p;
	}
}

void inputDish(MENU &list)
{
	printf("\nNhap vao thong tin cua mon an...\n");
	
	DISH x;
	printf("Nhap ma so mon an: ");
	fflush(stdin);
	scanf("%d", &x.dish_num);
	printf("Nhap ten mon an: ");
	fflush(stdin);
	gets(x.dish_name);
	printf("Nhap don gia: ");
	fflush(stdin);
	scanf("%d", &x.dish_price);
	printf("\n \n");
	NODE1 *p = new NODE1;
	p = createNode1(x);
	addDish(list, p);
}

void exportDish(MENU list)
{
	for (NODE1 *p = list.pHead; p != NULL; p = p -> next)
	{
		printf("\nMa mon: %d\nTen mon: %s\nGia tien: %d\n", p -> data.dish_num, p -> data.dish_name, p -> data.dish_price);
	}
}

void searchDish(MENU list)
{
	int key;
	printf("Nhap ma mon an can tim: ");
	fflush(stdin);
	scanf("%d", &key);
	
	bool res = false;
	
	for (NODE1 *p = list.pHead; p != NULL; p = p -> next)
	{
		if (p -> data.dish_num == key)
		{
			printf("\nDa tim thay ket qua!\n");
			printf("Ma mon: %d\nTen mon: %s\nGia tien: %d\n\n", p -> data.dish_num, p -> data.dish_name, p -> data.dish_price);
			res = true;
		}
	}
	if (res == false)
	{
		printf("\nKhong tim thay mon an!\n");
	}
}

/*
void deleteDish(MENU list)
{
	int key;
	printf("Nhap ma mon an can xoa: ");
	fflush(stdin);
	scanf("%d", &key);
	
	bool res = false;
	
	for (NODE1 *p = list.pHead; p != NULL; p = p -> next)
	{
		if (p -> data.dish_num == key)
		{
			p = p -> next;
			res = true;
		}
	}
	
	if (res == false)
	{
		printf("\nKhong tim thay mon an!\n");
	}
}
*/

void editDish(MENU list)
{
	int key;
	printf("Nhap ma mon an can chinh sua: ");
	fflush(stdin);
	scanf("%d", &key);
	
	bool res = false;
	
	for (NODE1 *p = list.pHead; p != NULL; p = p -> next)
	{
		if (p -> data.dish_num == key)
		{
			char new_name[150];
			int new_price;
			
			printf("Nhap ten moi: ");
			fflush(stdin);
			gets(new_name);
			strcpy(p -> data.dish_name, new_name);
			
			printf("Nhap don gia: ");
			fflush(stdin);
			scanf("%d", &new_price);
			printf("\n \n");
			p -> data.dish_price = new_price;
			
			res = true;
		}
	}
	if (res == false)
	{
		printf("\nKhong tim thay mon an!\n");
	}
}

void sortMenu(MENU list)
{
	NODE1 *p, *q;
	for (p = list.pHead; p != list.pTail; p = p -> next)
	{
		for (q = p -> next; q != NULL; q = q -> next)
		{
			if (p -> data.dish_price > q -> data.dish_price)
			{
				DISH x = p -> data;
				p -> data = q -> data;
				q -> data = x;
			}
		}
	}
}

void addOrder(ORDER_LIST &list2, NODE2 *q)
{
	if (list2.pHead2 == NULL)
	{
		list2.pHead2 = q;
		list2.pTail2 = q;
	}
	else
	{
		list2.pTail2 -> next = q;
		list2.pTail2 = q;
	}
}

void inputOrder(MENU list, ORDER_LIST list2)
{
	ORDER y;
	
	int key, qty, tPrice;
	printf("Nhap ma mon an can goi: ");
	scanf("%d", &key);
	
	printf("Nhap so luong: ");
	scanf("%d", &qty);
	
	bool res = false;
	
	for (NODE1 *p = list.pHead; p != NULL; p = p -> next)
	{
		if (p -> data.dish_num == key)
		{
			tPrice = p -> data.dish_price;
			tPrice = tPrice * qty;
			res = true;
		}
	}
	if (res == false)
	{
		printf("\nKhong tim thay mon an!\n");
	}
	
	if (res == true)
	{
		printf("\n \n");
	
		y.dish_num = key;
		y.dish_qty = qty;
		y.dish_tPrice = tPrice;
	
		NODE2 *q = new NODE2;
		q = createNode2(y);
		addOrder(list2, q);
	}
}

void exportOrder(ORDER_LIST list2)
{
	for (NODE2 *p = list2.pHead2; p != NULL; p = p -> next)
	{
		printf("\nMa mon: %d\nSo phan: %d\nTam tinh: %d\n", p -> data.dish_num, p -> data.dish_qty, p -> data.dish_tPrice);
	}
}

int main()
{
	MENU list;
	ORDER_LIST list2;
	
	initMenu(list);
	initOrder(list2);
	
	int choice;
    do {
        printf("\nMOI CHON:\n");
        printf("1. Them mon an\n");
        printf("2. Xuat toan bo Menu\n");
        printf("3. Tim kiem mon an theo ma\n");
		printf("4. Chinh sua mon an theo ma\n");
		printf("5. Sap xep thuc don theo gia tang dan\n");
		printf("6. Xoa mon an theo ma\n");
		printf("7. Goi mon\n");
		printf("8. Xem mon da goi\n");
        printf("0. Thoat\n");
        printf("Nhap lua chon cua ban: ");
        scanf("%d", &choice);

        switch (choice) 
		{
            case 1:
                inputDish(list);
                break;
            case 2:
			{
				int isNULL = checkNULL(list);
				if (isNULL == 1)
				{
					printf("\nThuc don hien tai dang trong!\n");
				}
				else
				{
					exportDish(list);
				}
                break;
			}
            case 3:
			{
                int isNULL = checkNULL(list);
				if (isNULL == 1)
				{
					printf("\nThuc don hien tai dang trong!\n");
				}
				else
				{
					searchDish(list);
				}
                break;
			}
			case 4:
			{
                int isNULL = checkNULL(list);
				if (isNULL == 1)
				{
					printf("\nThuc don hien tai dang trong!\n");
				}
				else
				{
					editDish(list);
				}
                break;
			}
			case 5:
			{
				int isNULL = checkNULL(list);
				if (isNULL == 1)
				{
					printf("\nThuc don hien tai dang trong!\n");
				}
				else
				{
					sortMenu(list);
				}
				break;
			}
			case 6:
			{
				int isNULL = checkNULL(list);
				if (isNULL == 1)
				{
					printf("\nThuc don hien tai dang trong!\n");
				}
				else
				{
					//deleteDish(list);
					printf("\nChuc nang hien tai khong kha dung!\n");
				}
				break;
			}
			case 7:
			{
				inputOrder(list, list2);
				break;
			}
		case 8:
			{
				int isNULL2 = checkNULL2(list2);
				if (isNULL2 == 1)
				{
					printf("\nDanh sach goi hien tai dang trong!\n");
				}
				else
				{
					exportOrder(list2);
				}
				break;
			}
				
			case 0:
				printf("Thoat chuong trinh.\n");
			break;
			
			default:
				printf("Lua chon khong hop le.\n");
				break;
		}
	} while (choice != 0);
}