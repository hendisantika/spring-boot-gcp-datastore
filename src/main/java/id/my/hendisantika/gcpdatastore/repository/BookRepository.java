package id.my.hendisantika.gcpdatastore.repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import id.my.hendisantika.gcpdatastore.entity.Book;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-gcp-datastore
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/03/25
 * Time: 08.31
 * To change this template use File | Settings | File Templates.
 */
public interface BookRepository extends DatastoreRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByYearGreaterThan(int year);

    List<Book> findByAuthorAndYear(String author, int year);
}
