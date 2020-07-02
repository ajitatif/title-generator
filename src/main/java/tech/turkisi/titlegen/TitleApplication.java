package tech.turkisi.titlegen;

import tech.turkisi.titlegen.data.Migrator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class TitleApplication extends Application {

    @Inject
    private Migrator migrator;

    @PostConstruct
    public void initApplication() {
        migrator.migrate();
    }
}
