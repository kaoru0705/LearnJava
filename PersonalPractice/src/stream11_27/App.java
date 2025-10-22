package stream11_27;
import java.util.*;
// forEach와 peek의 차이는 peek는 중간처리 메소드이고 forEach는 최종처리 메소드다.
// 따라서 최종처리 메소를 함께 사용해야 한다.
// anyMatch 처음으로 true를 반환하는 순간 처리가 끝남

public class App {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("JAVA 프로그래밍", "홍길동", 10000));
        books.add(new Book("PHP 프로그래밍", "이순신", 20000));
        books.add(new Book("마이크로프로세서 입문", "김유신", 14000));
        books.add(new Book("데이터베이스 입문", "심사임당", 21000));
        books.add(new Book("빅데이터 연구", "유관순", 12000));
        books.add(new Book("커뮤니케이션 이론", "강감찬", 15000));

        books.stream()
            .peek(book -> System.out.println(book))
            .anyMatch(m -> m.price > 20000);
    }
}

class Book {
    String title;
    String author;
    int price;

    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    int getPrice() {
        return this.price;
    };
    String getAuthor() {
        return this.author;
    }
    String getTitle() {
        return this.title;
    }

    public String toString() {
        return ("title:" + this.title + ", author:" + this.author + ", price:" + this.price);
    }
}