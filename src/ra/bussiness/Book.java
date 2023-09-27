package ra.bussiness;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner sc, Book[] arrBook, int currentIndex) {
//        Scanner sc = new Scanner(System.in);
        System.out.println("Nhâp tên Sách: ");
        do {
            this.bookName = sc.nextLine();
            if (this.bookName.length() == 0) {
                System.out.println("Không được để trống. Hãy nhập lại: ");
            } else {
                System.out.println("Cập nhật thành công: ");
                break;
            }
        } while (true);
        System.out.println("Nhâp tên tác giả: ");
        do {
            this.author = sc.nextLine();
            if (this.author.length() == 0) {
                System.out.println("Không được để trống. Hãy nhập lại: ");
            } else {
                System.out.println("Cập nhật thành công: ");
                break;
            }
        } while (true);
        System.out.println("Nhập mô tả sách: ");
        do {
            this.descriptions = sc.nextLine();
            if (this.descriptions.length() < 10) {
                System.out.println("Nội dung ít nhất 10 ký tự và không được để trống. Hãy nhập lại: ");
            } else {
                System.out.println("Cập nhật thành công: ");
                break;
            }
        } while (true);
        System.out.println("Gía nhập: ");
        do {
            String input = sc.nextLine();

            if (Pattern.matches("[0-9]", input)) {
                this.importPrice = Integer.parseInt(sc.nextLine());
            } else {
                System.err.println("Vui lòng nhập số :");
            }
            if (this.importPrice < 0) {
                System.out.println("Gía nhp phải lớn hơn 0, Hãy nhp lại: ");
            } else {
                System.out.println("Cập nhật thành công!");
                break;
            }
        } while (true);
        System.out.println("Gía xuất: ");
        do {
            this.exportPrice = Integer.parseInt(sc.nextLine());
            if (this.exportPrice < (importPrice * 1.2)) {
                System.out.println("Gía xuất phải lớn hơn 1.2 lần giá nhập. Hãy nhập lại: )");
            } else {
                System.out.println("Cập nhật thành công!");
                break;
            }
        } while (true);
        System.out.println("Nhập trạng thái sách: \n1. Đang bán\n 2. Không có sẳn");
        int choice = sc.nextInt();
        boolean isDangban = true;

        switch (choice) {
            case 1:
                isDangban = true;
                this.bookStatus = isDangban;
                break;
            case 2:
                isDangban = false;
                this.bookStatus = isDangban;
                break;
            default:
                System.err.println(" Chỉ chọn 1 hoặc 2. Hãy nhập lại:");
        }
    }

    public void calInterest() {
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    public void displayData() {
        System.out.printf("❤️ Tên Sách: %s|❤️ Tác giá:r %s|❤️ Gía nhập: %s|❤️ Gía Xuất: %s|❤️ Lợi nhuận: %f|❤️ Trạng thái: %n", this.bookName, this.author, this.descriptions, this.importPrice, this.exportPrice, this.interest, this.bookStatus ? "Đang bán" : "Không bán");
    }
}
