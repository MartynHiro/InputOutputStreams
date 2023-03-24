public class AmountOfInputNumbersException extends RuntimeException {
    public AmountOfInputNumbersException(String input) {
        super("Необходимо ввести 2 числа через пробел, вы ввели некорректно: " + input);
    }
}