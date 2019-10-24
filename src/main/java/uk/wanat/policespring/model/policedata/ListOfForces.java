package uk.wanat.policespring.model.policedata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfForces {

    public List<String> getForces() {
        try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Karolina\\Downloads\\force_kmls (1)\\force kmls"))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.getFileName().toString()).collect(Collectors.toList());

            List<String> stringList = result.stream().map(e -> e.substring(0, e.length() - 4)).collect(Collectors.toList());

            return stringList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
