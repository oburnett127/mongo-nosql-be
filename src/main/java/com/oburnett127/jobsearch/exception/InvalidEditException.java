package com.oburnett127.jobsearch.exception;

public class InvalidEditException extends RuntimeException{
    public InvalidEditException() {
        super("The title cannot be blank nor contain non-alphanumeric characters. The description cannot be blank.");
    }
}
