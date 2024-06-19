package org.triangle.exception;

public class CollinearPointsException extends IllegalArgumentException{
    public CollinearPointsException(){
        super("Points on one line");
    }
    public CollinearPointsException(String message){
        super(message);
    }
    public CollinearPointsException(String message, Throwable cause){
        super(message,cause);
    }
}
