import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Basket basket;

        String[] products = {
                "Pepsi",
                "Donut",     //продукты
                "Pie"
        };

        int[] prices = {57, 39, 189}; //цены продуктов

        File file = new File("basket.bin");

        if (Basket.loadFromBinFile(file) == null) { //если по данному пути нет файла для загрузки, создаем новую корзину
            basket = new Basket(products, prices);

        } else {
            basket = Basket.loadFromBinFile(file); //если она там есть, то сохраняем старую корзину
        }

        while (true) {
            MethodsShelf.startMessage(products, prices);

            String input = scan.nextLine();

            if ("end".equals(input)) {
                break;
            }

            if (!MethodsShelf.isSpaceSecond(input)) {
                RuntimeException x = new AmountOfInputNumbersException(input);
                MethodsShelf.error(x);
                continue;
            }

            String[] parts = input.split(" ");

            try {
                int productNumber = Integer.parseInt(parts[0]) - 1;
                int productCount = Integer.parseInt(parts[1]);

                boolean isAdd = Objects.requireNonNull(basket).addToCart(productNumber, productCount);
                if (isAdd) {
                    System.out.println("Товар успешно добавлен в корзину");
                } else {
                    System.out.println("Товар не добавлен!");
                }

            } catch (Exception x) {
                System.out.println("Вы вводите буквы, а необходимы цифры!!!!!!");
                System.out.println("-------------------------------------------");
                continue;
            }

            if (!MethodsShelf.isNumberCorrect(parts[0], parts[1], products)) {
                RuntimeException x = new IncorrectInputNumbersException(input);
                MethodsShelf.error(x);
            }
        }

        System.out.println(Objects.requireNonNull(basket).printCart()); //выводим корзину на экран

        boolean isSave = Objects.requireNonNull(basket).saveBin(file, basket); //в конце работы сохраняем нашу корзину
        if (isSave) {
            System.out.println("Файл успешно сохранен");
        } else {
            System.out.println("Ошибка в сохранении файла");
        }
    }
}