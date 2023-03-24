public class IncorrectInputNumbersException extends RuntimeException {
    public IncorrectInputNumbersException(String text) {
        super("Вы пытаетесь ввести неправильное число: " + text);
    }
}