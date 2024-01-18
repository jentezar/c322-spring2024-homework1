package part3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Guitar> guitarList = new ArrayList<>();
    public void addGuitar(String serialNumber, double price,
                          String builder, String model, String type,
                          String backWood, String topWood){
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitarList.add(guitar);
        System.out.println("Guitar added to list");
        //now adding guitar to text file
        String fileName = "guitars_database.txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            // Append the guitar information to the file
            writer.write( serialNumber + ", " + price + ", " + builder + ", " + model + ", " + type + ", " +
                    backWood + ", " + topWood + "\n");
            System.out.println("Guitar added to the database.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitarList) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null; //serial number not found
    }
    public Guitar search(Guitar searchGuitar) {
        String sn = searchGuitar.getSerialNumber();
        for (Guitar guitar : guitarList) {
            if (guitar.getSerialNumber().equals(sn)) {
                return guitar;
            }
        }
        return null; // Guitar not found
    }

}




