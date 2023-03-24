public class MethodsShelf {
    public static void error(RuntimeException exception) { // error output
        System.out.println(exception + "\n" + "---------------------------------------------------------------------");
    }

    public static boolean isNumberCorrect(String firstNumber, String secondNumber, String[] products) {
        int productNumber = Integer.parseInt(firstNumber);
        int productCount = Integer.parseInt(secondNumber);
        if (productNumber > 0 && productCount > 0) {   // method to check is number < 0 or too large
            return productNumber <= products.length; //true
        }
        return false;
    }

    public static boolean isSpaceSecond(String text) { //method to check how many spaces in the text and the second character is a space?
        int spacesCounter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spacesCounter++;
            }
        }
        if (spacesCounter == 1) {
            char secondSymbol = text.charAt(1);
            return ' ' == secondSymbol; // true
        }
        return false;
    }

    public static void startMessage(String[] products, int[] prices) { //initial message output
        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + "." + products[i] + " - " + prices[i] + " руб/шт");
        }
        System.out.println("Выберите номер товара и количество через пробел, либо введите 'end'");
    }
}
