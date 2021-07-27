package org.test.task;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/resources/input.txt";
        ParseFile parseFile = new ParseFile(filename);
        parseFile.parse();
        final List<Bus> busList = parseFile.getBusList();
        BusSelectionService selectionService = new BusSelectionService();
        Set<Bus> result = new HashSet<>();
        for (int i=0 ; i<busList.size(); i++){
            final Bus bus1 = busList.get(i);
            for(int j=i+1; j<busList.size()-1; j++) {
                final Bus bus2 = busList.get(j);
                final Bus efficient = selectionService.preferredBus(bus1, bus2);
                if (efficient == bus2) {
                    result.add(bus2);
                    result.remove(bus1);
                    break;
                } else {
                    result.add(bus1);
                }
            }
        }
        System.out.println(result);

        try (BufferedWriter wr = Files.newBufferedWriter(Paths.get("output.txt")) ){
            result.stream().filter(bus -> bus.getCompanyName().equals("Posh")).forEach(bus -> printBus(wr, bus));
            wr.newLine();
            result.stream().filter(bus -> bus.getCompanyName().equals("Grotty")).forEach(bus -> printBus(wr, bus));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printBus(BufferedWriter wr, Bus bus) {
        try {
            wr.write(bus.getCompanyName());
            wr.write(" ");
            wr.write(bus.getDepartureTime().toString());
            wr.write(" ");
            wr.write(bus.getArrivalTime().toString());
            wr.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
