package com.google.zashcode;

import com.google.zashcode.model.City;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args){
        List<String> files = new ArrayList<String>();
        files.add("a_example");
        files.add("b_should_be_easy");
        files.add("c_no_hurry");
        files.add("d_metropolis");
        files.add("e_high_bonus");

        City city = null;
        for (String file : files) {
            //city = DataLoader;

            DataOutput.write(file, city.drive());
        }
    }

}
