package com.telecommunication.demo.Exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException (String payment){

        super(payment);
    }
}
