package phattrienungdungj2ee.bai2.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import phattrienungdungj2ee.bai2.model.Book;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    // Lấy tất cả sách
    public List<Book> getAllBooks() {
        return books;
    }

    // Lấy sách theo id
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm sách
    public void addBook(Book book) {
        books.add(book);
    }

    // ===== PHẦN SLIDE EM HỎI (TIẾP TỤC) =====

    // Cập nhật sách
    public void updateBook(int id, Book updatedBook) {
        books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                });
    }

    // Xóa sách
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
