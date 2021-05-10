package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static List<String> readFile(String path) throws IOException {
        List<String> inputs = new ArrayList<>();
        File f = new File(path);
        if(!f.exists())
            f.createNewFile();

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null)
            inputs.add(line);

        return inputs;


    }
}
