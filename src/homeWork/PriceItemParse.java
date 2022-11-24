package homeWork;

public class PriceItemParse {

    public static PriceItems parse(String line) {
        String[] strings = line.split(",");
        PriceItems priceItems = new PriceItems(Integer.parseInt(strings[0]),Double.parseDouble(strings[1]));
        return priceItems;
    }

}
