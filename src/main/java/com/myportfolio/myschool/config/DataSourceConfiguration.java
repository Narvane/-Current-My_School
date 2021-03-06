package com.myportfolio.myschool.config;

import com.myportfolio.myschool.config.tenant.TenantRoutingDataSource;
import com.myportfolio.myschool.properties.DataSourceProperties;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfiguration(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource() {
        TenantRoutingDataSource customDataSource = new TenantRoutingDataSource();
        customDataSource.setTargetDataSources(
                dataSourceProperties.getDataSources());
        return customDataSource;
    }

    @PostConstruct
    public void migrate() {
        for (Object dataSource : dataSourceProperties
                .getDataSources()
                .values()) {
            DataSource source = (DataSource) dataSource;
            Flyway flyway = Flyway.configure().dataSource(source).load();
            flyway.migrate();
        }
    }

}