package hu.dpc.phee.operator;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})
public class DatabaseImporterApplication {

    static {
        // NOTE zeebe timestamps are also GMT, parsed dates in DB should also use GMT to match this
        System.setProperty("user.timezone", "GMT");
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseImporterApplication.class, args);
    }

    @Bean
    public CsvMapper csvMapper() {
        return new CsvMapper();
    }
}
