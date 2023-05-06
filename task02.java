import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task02 {
    public static void main(String[] args) {
        parseStringFromFile("input.txt");
    }

    public static void parseStringFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseString(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseString(String input) {
        String pattern = "\"фамилия\":\"(.*?)\",\"оценка\":\"(.*?)\",\"предмет\":\"(.*?)\"";
        if (input.matches(pattern)) {
            String surname = input.replaceAll(pattern, "$1");
            String grade = input.replaceAll(pattern, "$2");
            String subject = input.replaceAll(pattern, "$3");

            StringBuilder result = new StringBuilder();
            result.append("Студент ").append(surname);
            result.append(" получил ").append(grade);
            result.append(" по предмету ").append(subject).append(".");
            System.out.println(result.toString());
        }
    }
}

