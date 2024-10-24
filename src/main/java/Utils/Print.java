package Utils;

import Entity.Task;


public class Print {
        public static void printToTerminal(Task task, int index) {
            String output = task.toString();
            System.out.println(index + ". " + output);
    }
}
