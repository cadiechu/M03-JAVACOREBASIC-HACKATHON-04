package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] arrBook = new Book[100];
        int currentIndex = 0;
        do {
            System.out.println("\u001B[36m ⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜JAVA-HACKATHON-05-BASIC-MENU⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜ \n" +
                    "\t\t\t\t\t\t1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +
                    "\t\t\t\t\t\t2. Hiển thị thông tin tất cả sách trong thư viện \n +" +
                    "\t\t\t\t\t\t3. Sắp xếp sách theo lợi nhuận tăng dần \n + " +
                    "\t\t\t\t\t\t4. Xóa sách theo mã sách \n +" +
                    "\t\t\t\t\t\t5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả \n +" +
                    "\t\t\t\t\t\t6. Thay đổi thông tin sách theo mã sách \n +" +
                    "\t\t\t\t\t\t7. Thoát🤞");
            System.out.println(" Nhập lựa chọn theo mục tương ứng: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println(" Nhập số lượng sách muốn thêm:");
                    int cntBook = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i<cntBook; i++){
                        System.out.printf("Nhập thông tin sách thứ %d ", currentIndex+1);
                        arrBook[currentIndex] = new Book();
                        arrBook[currentIndex].inputData(sc,arrBook,currentIndex);
                        currentIndex++;
                    }
                    break;
                case 2:
                    for (int i = 0; i<currentIndex;i++){
                        System.out.printf("Thông tin sách thứ %d" , i+1);
                        arrBook[i].displayData();
                    }
                    break;
                case 3:
                    for (int i =0; i<currentIndex;i++){
                        for (int j= 1+1;j<currentIndex;j++){
                            if (arrBook[i].getInterest()>arrBook[j].getInterest()){
                                Book temp = arrBook[i];
                                arrBook[i]= arrBook[j];
                                arrBook[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp sách theo lợi nhuận tăng dần");
                    for (int i = 0; i< currentIndex; i++){
                        System.out.printf("Sách thứ %d",i+1);
                        arrBook[i].displayData();
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.err.println("Chương trình kết thúc!");
                    System.exit(0);
            }
        }while (true);
    }
}
