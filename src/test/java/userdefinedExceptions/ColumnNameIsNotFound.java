package userdefinedExceptions;

public class ColumnNameIsNotFound extends Exception{
    public ColumnNameIsNotFound(String message) {
        super(message);
    }
}
