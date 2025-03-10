package id.my.hendisantika.gcpdatastore.repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.google.cloud.spring.data.datastore.repository.query.Query;
import id.my.hendisantika.gcpdatastore.entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-gcp-datastore
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/03/25
 * Time: 07.25
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends DatastoreRepository<User, Long> {

    List<User> findByCountry(String country);

    @Query("select * from |com.knf.dev.demo.entity.User| where name = @name")
    List<User> findByName(String name);
}
