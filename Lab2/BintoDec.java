/*
Nhóm 2A

Phạm Huỳnh Chí - 20200143
Ngô Xuân Đạt - 20200161
Hồ Hoàng Nghiệp - 20200277 
*/

/*
Xây dựng chương trình BintoDec để xuất ra màn hình giá trị thập phân
tương ứng khi nhập một giá trị nhị phân từ bàn phím
*/

import java.io.*;
import java.util.*;

class BintoDec {
  public static void main(String[] args) {
	
	System.out.print("Nhap 1 so nhi phan (gom chu so 0 va 1): ");
		
	Scanner sc = new Scanner(System.in);
	String binary = sc.nextLine();
	
    int decimal = Integer.parseInt(binary, 2);
    System.out.println(binary + " (2) = " + decimal + " (10)");
  }
}