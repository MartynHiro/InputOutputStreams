import java.io.*;

public class Basket {
    private String[] products;
    private int[] prices;
    private int[] counts;


    public Basket(String[] products, int[] prices) {
        this.products = products;
        this.prices = prices;
        this.counts = new int[products.length];
    }

    public Basket(String[] products, int[] prices, int[] counts) {
        this(products, prices);
        this.counts = counts;
    }

    public void addToCart(int productNum, int productCount) {
        this.counts[productNum] += productCount;
    }

    public String printCart() {
        StringBuilder sb = new StringBuilder("В вашей корзине:\n");
        int sum = 0;
        for (int i = 0; i < products.length; i++) {
            sb.append("Продукт - " + products[i] +
                    ", в количестве - " + counts[i] +
                    "шт. , его общая сумма - " + (prices[i] * counts[i] + ".р\n"));
            sum += prices[i] * counts[i];
        }
        sb.append("Общая сумма корзины - " + sum);
        return sb.toString();
    }

    public boolean saveTxt(File textFile) {
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(textFile, false)))) {

            for (String product : products) { //записываем все продукты в 1ю строку
                writer.write(product + " ");
            }
            writer.newLine(); //переходим на вторую строку

            for (int price : prices) { //записываем все ценники
                writer.write(price + " ");
            }
            writer.newLine(); //переходим на третью строку


            for (int count : counts) { //на третьей строке записываем количества продуктов
                writer.write(count + " ");
            }

            return true;
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
        }
        return false;
    }

    public static Basket loadFromTxtFile(File textFile) {
        try (BufferedReader reader = new BufferedReader((new FileReader(textFile)))) {
            String[] loadedProducts;
            int[] loadedPrices;
            int[] loadedCount;

            loadedProducts = (reader.readLine()).split(" "); //достали названия продуктов

            String[] pricesFromLine = (reader.readLine().split(" ")); //достаем цены каждого продукта
            loadedPrices = new int[loadedProducts.length];
            for (int i = 0; i < pricesFromLine.length; i++) {
                loadedPrices[i] = Integer.parseInt(pricesFromLine[i]);
            }

            String[] countsFromLine = (reader.readLine()).split(" "); //достаем сколько штук каждого продукта
            loadedCount = new int[loadedProducts.length];
            for (int i = 0; i < countsFromLine.length; i++) {
                loadedCount[i] = Integer.parseInt(countsFromLine[i]);
            }

            return new Basket(loadedProducts, loadedPrices, loadedCount);

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
            return null;
        }
    }
}
