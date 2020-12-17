import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите итоговый сепаратор:");
        String separator = scanner.nextLine();
        System.out.println("Введите путь к файлу:");
        String pathToOrigin = scanner.nextLine();
        System.out.println("Введите путь создания:");
        String pathToResult = scanner.nextLine();
        System.out.println("Введите сепаратор:");
        String sep = scanner.nextLine();
        File origin = new File(pathToOrigin);
        File result = new File(pathToResult);
        Formatter formatter = new Formatter();
        String absolutePath = result.getAbsolutePath();
        Scanner scan= new Scanner(origin);
        List<String> lines= new ArrayList<>();
        while (scan.hasNext()) {
            lines.add(formatter.format(Parser.parseLine(scan.nextLine(), sep.charAt(0), '"'), separator));
        }
        StringBuilder formattedResult = new StringBuilder();
        lines.forEach(formattedResult::append);
        Files.write(Paths.get(absolutePath), Collections.singletonList(formattedResult), StandardCharsets.UTF_8);
        System.out.println(absolutePath);
    }
}
