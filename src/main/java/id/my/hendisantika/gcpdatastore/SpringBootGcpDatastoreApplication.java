package id.my.hendisantika.gcpdatastore;

import id.my.hendisantika.gcpdatastore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootGcpDatastoreApplication {
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGcpDatastoreApplication.class, args);
    }


}
