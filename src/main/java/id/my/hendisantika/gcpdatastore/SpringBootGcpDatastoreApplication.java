package id.my.hendisantika.gcpdatastore;

import com.google.common.collect.Lists;
import id.my.hendisantika.gcpdatastore.entity.Book;
import id.my.hendisantika.gcpdatastore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootGcpDatastoreApplication {
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGcpDatastoreApplication.class, args);
    }

    @Command(name = "save-book", description = "Saves a book to Cloud Datastore: save-book <title> <author> <year>")
    public String saveBook(@Argument(index = 0) String title, @Argument(index = 1) String author,
                           @Argument(index = 2) int year) {
        Book savedBook = this.bookRepository.save(new Book(title, author, year));
        return savedBook.toString();
    }

    @Command(name = "find-all-books", description = "Loads all books")
    public String findAllBooks() {
        Iterable<Book> books = this.bookRepository.findAll();
        return Lists.newArrayList(books).toString();
    }

    @Command(name = "find-by-author", description = "Loads books by author: find-by-author <author>")
    public String findByAuthor(@Argument(index = 0) String author) {
        List<Book> books = this.bookRepository.findByAuthor(author);
        return books.toString();
    }

    @Command(name = "find-by-year-after", description = "Loads books published after a given year: find-by-year-after <year>")
    public String findByYearAfter(@Argument(index = 0) int year) {
        List<Book> books = this.bookRepository.findByYearGreaterThan(year);
        return books.toString();
    }

    @Command(name = "find-by-author-year", description = "Loads books by author and year: find-by-author-year <author> <year>")
    public String findByAuthorYear(@Argument(index = 0) String author, @Argument(index = 1) int year) {
        List<Book> books = this.bookRepository.findByAuthorAndYear(author, year);
        return books.toString();
    }

    @Command(name = "remove-all-books", description = "Removes all books")
    public void removeAllBooks() {
        this.bookRepository.deleteAll();
    }
}
