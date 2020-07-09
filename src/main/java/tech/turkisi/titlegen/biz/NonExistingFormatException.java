package tech.turkisi.titlegen.biz;

import lombok.Getter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Getter
public class NonExistingFormatException extends WebApplicationException {

    private final String format;

    public NonExistingFormatException(String format) {
        super("The specified format does not exist: " + format, Response.Status.NOT_FOUND);
        this.format = format;
    }
}
