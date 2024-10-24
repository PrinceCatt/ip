package Command;

import Entity.Task;
import Entity.TaskList;

import java.util.List;

import static Utils.Print.printToTerminal;

public class Show {
    /**
     * Show list
     *
     * <p>This method is to show or to list down the message list</p>
     * @param list The message list to show.
     */

    public static void listShow(TaskList list) {
        System.out.println("-----------------------------------\n");
        int i = 1;
        List<Task> messages = list.getTaskList();
        while(i <= messages.size()) {
            Task task = messages.get(i - 1);
            printToTerminal(task, i);
            i++;
        }
        if(messages.size() == 0) {
            System.out.println("No task found");
        }
        System.out.println("-----------------------------------\n");
    }
}
