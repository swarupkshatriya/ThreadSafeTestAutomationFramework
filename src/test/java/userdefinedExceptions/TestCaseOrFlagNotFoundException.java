package userdefinedExceptions;

public class TestCaseOrFlagNotFoundException extends Exception{
    public TestCaseOrFlagNotFoundException(String message) {
        super(message);
    }
}
