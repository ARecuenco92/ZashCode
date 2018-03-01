package com.google.zashcode;

import com.google.zashcode.model.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataOutput {

    public static void write(String file, List<Car> cars) {
        List<String> lines = new ArrayList<String>();
        lines.add(Integer.toString(cars.size()));

        for (Car car : cars) {
            lines.add(car.toString());
        }

        try {
            Files.createDirectories(Paths.get("out"));
            Files.write(Paths.get("out/" + file + ".out"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
