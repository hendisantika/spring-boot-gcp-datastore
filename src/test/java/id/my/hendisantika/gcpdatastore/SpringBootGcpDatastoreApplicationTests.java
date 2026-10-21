package id.my.hendisantika.gcpdatastore;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest(properties = {
        "spring.cloud.gcp.credentials.location=",
        "spring.cloud.gcp.datastore.credentials.location=",
        "spring.cloud.gcp.datastore.host=localhost:8081"
})
class SpringBootGcpDatastoreApplicationTests {

    @Test
    void contextLoads() {
    }

    // Avoid loading a real service account key so the context can start in CI
    @TestConfiguration
    static class NoCredentialsConfig {
        @Bean
        CredentialsProvider googleCredentials() {
            return NoCredentialsProvider.create();
        }
    }

}
