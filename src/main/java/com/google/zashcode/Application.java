package com.google.zashcode;

import com.google.zashcode.model.City;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws IOException {
        List<String> files = new ArrayList<String>();
        files.add("a_example");
        files.add("b_should_be_easy");
        files.add("c_no_hurry");
        files.add("d_metropolis");
        files.add("e_high_bonus");

        City city = null;
        for (String file : files) {
            //city = DataLoader;
            city = new DataLoader(file.concat(".in")).getCity();


            DataOutput.write(file, city.drive());
        }
    }

}
