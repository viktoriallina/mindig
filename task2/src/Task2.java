import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        String centerFileName = args[0];
        String pointsFileName = args[1];
        try {
            BufferedReader centerFile = new BufferedReader(new FileReader(centerFileName));
            double centerX, centerY;
            double radius;
            String centerLine = centerFile.readLine();
            String[] centerParts = centerLine.split(" ");
            centerX = Double.parseDouble(centerParts[0]);
            centerY = Double.parseDouble(centerParts[1]);
            radius = Double.parseDouble(centerFile.readLine());
            centerFile.close();
            BufferedReader pointFile = new BufferedReader(new FileReader(pointsFileName));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = pointFile.readLine()) != null) {
                String[] pointParts = line.split(" ");
                double pointX = Double.parseDouble(pointParts[0]);
                double pointY = Double.parseDouble(pointParts[1]);
                double dist = Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));
                if (dist < radius) {
                    result.append("1\n");
                } else if (dist == radius) {
                    result.append("0\n");
                } else {
                    result.append("2\n");
                }
            }
            pointFile.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}