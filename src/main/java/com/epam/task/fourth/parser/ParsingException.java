package com.epam.task.fourth.parser;

public class ParsingException extends Exception{
    public ParsingException(Throwable cause) {
        super(cause);
    }

    public ParsingException(String message) {
        super(message);
    }
}
