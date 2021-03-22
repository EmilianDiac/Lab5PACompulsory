package com.company.exceptions;

public class UnknownCatalogTypeException extends Exception{
    public UnknownCatalogTypeException(String message) {

        super("The type " + message + " is not recognized!");
    }
}
