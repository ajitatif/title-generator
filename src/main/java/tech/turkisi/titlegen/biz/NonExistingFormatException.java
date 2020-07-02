package tech.turkisi.titlegen.biz;

import lombok.Getter;

@Getter
public class NonExistingFormatException extends RuntimeException {

    private final String format;

    public NonExistingFormatException(String format) {
        super("The specified format does not exist: " + format);
        this.format = format;
    }
}
