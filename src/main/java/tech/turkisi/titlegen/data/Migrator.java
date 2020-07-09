package tech.turkisi.titlegen.data;

import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import java.io.Serializable;

@Singleton
@Startup
@TransactionManagement(value = TransactionManagementType.BEAN)
public class Migrator implements Serializable {

    @Resource
    private DataSource dataSource;

    @PostConstruct
    public void migrate() {

        final Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
