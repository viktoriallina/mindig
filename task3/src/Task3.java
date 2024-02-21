import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        String testsJsonPath = args[0];
        String valuesJsonPath = args[1];
        String reportJsonPath = args[2];
        try {
            Gson gson = new Gson();
            JsonReader testJsonReader = new JsonReader(new FileReader(testsJsonPath));
            JsonReader valuesJsonReader = new JsonReader(new FileReader(valuesJsonPath));
            Tests tests = gson.fromJson(testJsonReader, Tests.class);
            Values values = gson.fromJson(valuesJsonReader, Values.class);
            for (Test test : tests.tests) {
                setValues(test, values);
            }
            String report = gson.toJson(tests);
            FileWriter reportWriter = new FileWriter("report.json");
            reportWriter.write(report);
            reportWriter.close();
            testJsonReader.close();
            valuesJsonReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setValues(Test test, Values values) {
        for (Value value : values.values) {
            if (test.id == value.id) {
                test.value = value.value;
            }
        }
        if (test.values != null) {
            for (Test tst : test.values) {
                setValues(tst, values);
            }
        }
    }
}