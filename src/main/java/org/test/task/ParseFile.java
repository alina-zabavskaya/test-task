package org.test.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class ParseFile {
    private String fileName;
    private List<Bus> busList;

    public ParseFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public void parse(){
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            busList = reader.lines().map(s -> {
                final String[] strings = s.split("\\s+");
                    Bus b = new Bus(strings[0], LocalTime.parse(strings[1]), LocalTime.parse(strings[2]));
                    return b;
            }).filter(bus -> bus.getDuration() < 60).sorted().collect(Collectors.toList());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
