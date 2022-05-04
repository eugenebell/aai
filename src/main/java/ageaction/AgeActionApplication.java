package ageaction;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class AgeActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgeActionApplication.class, args);
	}

	
	@Configuration
	@Profile("!cloud")
	public class DataSourceConfig {
	    
	    @Bean
	    public DataSource getDataSource() {
	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
	        dataSourceBuilder.url("jdbc:mysql://localhost:3306/service_instance_db?useSSL=FALSE");
	        dataSourceBuilder.username("a7b72874e80446c9869ebacf7628100f");
	        dataSourceBuilder.password("rhnnbtcr9jkcf5m6");
	        return dataSourceBuilder.build();
	    }
	}
}
