package Command;

import Entity.Task;
import Entity.TaskList;

import java.util.List;

public class Mark {
    /**
     * Mark existing item in the list
     *
     * <p>This method is to mark existing items
     * in the list by analysing the input</p>
     * @param input The input to recognize.
     * @param list The message list to use.
     */

    public static void mark(TaskList list, String input) {
        List<Task> tasks = list.getTaskList();
        String[] sentences = input.split(" ");
        int number = Integer.parseInt(sentences[1]);
        if(number > tasks.size()) {
            System.out.println("Sorry, you are marking a task that has not been added");
            return;
        }

        if(input.contains("unmark")){
            tasks.get(number-1).setDone(false);
            System.out.println("-----------------------------------\n");
            System.out.println("I have marked this task as not done!\n" + "[X] " + tasks.get(number-1).getDescription());
            System.out.println("-----------------------------------\n");
        }
        else {
            tasks.get(number - 1 ).setDone(true);
            System.out.println("-----------------------------------\n");
            System.out.println("I have marked this task as done!\n" + "[X] " + tasks.get(number-1).getDescription());
            System.out.println("-----------------------------------\n");
        }
    }
}
