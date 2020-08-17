package com.yanhuan.modernjavainaction.cap10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class JavaDslDemo {
    public static void main(String[] args) throws IOException {
        ArrayList<String> errors = new ArrayList<>();
        int errorCount = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sdf"));
        String line1 = bufferedReader.readLine();
        while (errorCount < 40 && line1 != null) {
            if (line1.startsWith("ERROR")) {
                errors.add(line1);
                errorCount++;
            }
            line1 = bufferedReader.readLine();
        }
        //改进
        List<String> collect = Files.lines(Paths.get("sdf"))
                .filter(line -> line.startsWith("ERROR"))
                .limit(40)
                .collect(Collectors.toList());

//        Optional.of()
    }
}
