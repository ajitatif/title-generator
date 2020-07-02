package tech.turkisi.titlegen.data;

import org.flywaydb.core.Flyway;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.io.Serializable;

@Singleton
@ApplicationScoped
public class Migrator implements Serializable {

    @Resource(lookup = "jdbc/the-datasource")
    private DataSource dataSource;

    public void migrate() {

        final Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
