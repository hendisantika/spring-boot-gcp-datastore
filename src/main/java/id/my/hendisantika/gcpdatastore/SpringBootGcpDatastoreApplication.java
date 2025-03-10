package id.my.hendisantika.gcpdatastore;

import com.google.common.collect.Lists;
import id.my.hendisantika.gcpdatastore.entity.Book;
import id.my.hendisantika.gcpdatastore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootGcpDatastoreApplication {
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGcpDatastoreApplication.class, args);
    }

    @ShellMethod("Saves a book to Cloud Datastore: save-book <title> <author> <year>")
    public String saveBook(String title, String author, int year) {
        Book savedBook = this.bookRepository.save(new Book(title, author, year));
        return savedBook.toString();
    }

    @ShellMethod("Loads all books")
    public String findAllBooks() {
        Iterable<Book> books = this.bookRepository.findAll();
        return Lists.newArrayList(books).toString();
    }

}
