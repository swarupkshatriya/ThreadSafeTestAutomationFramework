package userdefinedExceptions;

public class RadioButtonOptionIsNotAvailable extends  Exception{
    public RadioButtonOptionIsNotAvailable(String message) {
        super(message);
    }
}
