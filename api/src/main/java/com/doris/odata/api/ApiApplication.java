package com.doris.odata.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: origindoris
 * @Title: ApiApplication
 * @Description:
 * @date: 2022/9/29 17:22
 */

@SpringBootApplication(scanBasePackages = {"com.doris.odata"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.doris.odata.engine")
@EntityScan("com.doris.odata.engine")
@EnableJpaAuditing
public class ApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
