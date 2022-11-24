package homeWork;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {

        Map<Integer, NameItems> nameItemsMap = new HashMap<>();
        File fileNameItems = Path.of("resourcesHomework", "items-name.csv").toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameItems))) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null){
                NameItems nameItems = NameItemParse.parse(line);
                nameItemsMap.put(nameItems.getId(), nameItems);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<Integer, PriceItems> priceItemsMap = new HashMap<>();
        File filePriceItems = Path.of("resourcesHomework", "items-price.csv").toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePriceItems))) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                PriceItems priceItems = PriceItemParse.parse(line);
                priceItemsMap.put(priceItems.getId(), priceItems);
            }
            } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<ResultItem> resultItems = new ArrayList<>();
        for (NameItems result : nameItemsMap.values()) {
            PriceItems priceItems = priceItemsMap.get(result.getId());
            if (priceItems != null) {
                resultItems.add(new ResultItem(result.getId(),result.getName(), priceItems.getPrice()));
            }
        }

        File file = Path.of("resourcesHomework", "result.csv").toFile();
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))){
            fileWriter.append("ID,NAME,PRICE");
            fileWriter.newLine();
            for (ResultItem resultItem : resultItems) {
                fileWriter.append(resultItem.getId() + ", " + resultItem.getName() + ", " + resultItem.getPrice());
                fileWriter.newLine();
            }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
