package main.Exception;

public class DateIsNullException extends KinomichiException{

    public  DateIsNullException(String message){
        super(message);
    }

    public void getMessage(String message) {
        System.out.println(message);
    }
}
