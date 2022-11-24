package homeWork;

public class NameItemParse {

    public static NameItems parse(String line) {
        String[] strings = line.split(",");
        NameItems nameItems = new NameItems(Integer.parseInt(strings[0]),strings[1], strings[2]);
        return nameItems;
    }

}
