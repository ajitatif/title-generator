package tech.turkisi.titlegen.ws;

import tech.turkisi.titlegen.biz.TitleGenerator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("titles")
@RequestScoped
public class TitleResource {

    @Inject
    private TitleGenerator titleGenerator;

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHelloTitle() {
        return "Senior World Greeting Executive";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomTitle() {
        return titleGenerator.getRandomTitle();
    }
}
