package com.oburnett127.jobsearch.exception;

public class InvalidUpdateException extends RuntimeException{
    public InvalidUpdateException() {
        super("The title cannot be blank nor contain non-alphanumeric characters. The description cannot be blank.");
    }
}
