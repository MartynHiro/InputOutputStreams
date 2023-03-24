public class InvalidInputCharactersException extends RuntimeException {
    public InvalidInputCharactersException(String input) {
        super("Необходимо вводить только цифры, вы ввели некорректно: " + input);
    }
}