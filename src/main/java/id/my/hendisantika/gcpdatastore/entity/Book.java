package id.my.hendisantika.gcpdatastore.entity;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-gcp-datastore
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/03/25
 * Time: 08.30
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "books")
public class Book {
    @Id
    Long id;

    String title;

    String author;

    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", year=" + this.year +
                '}';
    }
}
