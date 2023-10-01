package org.example.exception;

public class NoRestaurantAvailable extends RuntimeException{

    public NoRestaurantAvailable(String message){
        super(message);
    }
}
