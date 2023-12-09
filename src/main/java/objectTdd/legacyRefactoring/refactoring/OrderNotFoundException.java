package objectTdd.legacyRefactoring.refactoring;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String message) {
        super(message);
    }

}