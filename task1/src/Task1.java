public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] array;
        // заполняем массив от 1 до n
        if (n > 0) {
            array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = i + 1;
            }
        } else if (n == 0) {
            array = new int[]{1, 0};
        } else {
            array = new int[Math.abs(n) + 2];
            for (int i = 0, j = 0; i > -array.length; i--, j++) {
                array[j] = i + 1;
            }
        }
        int[] arrayInterval = new int[m];
        StringBuilder result = new StringBuilder();
        boolean resume = true;
        int arrayIndex = 0;
        while (resume) {
            for (int i = 0; i < m; i++, arrayIndex++) {
                if (arrayIndex == array.length) {
                    arrayIndex = 0;
                }
                arrayInterval[i] = array[arrayIndex];
                if (i == 0) {
                    arrayInterval[i] = array[arrayIndex];
                    result.append(arrayInterval[i]);
                } else if (m - 1 == i) {
                    // сохраняем корректный индекс для начала следующего интервала
                    arrayIndex -= 1;
                }
                if (arrayInterval[m - 1] == 1) {
                    resume = false;
                }
            }
        }
        System.out.println(result);
    }
}