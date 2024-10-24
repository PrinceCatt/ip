package Command;

import Entity.Task;
import Entity.TaskList;

import java.util.ArrayList;
import java.util.List;
import static Utils.Print.printToTerminal;

public class Find {

    /**
     * Find existing items in message list
     *
     * <p>This method is to extract information
     * from the user input and find items
     * containing the input from the message list</p>
     * @param input The input to be searched.
     * @param list The message list to search from.
     */

    public static void find(TaskList list, String input) {
        List<Task> tasks = list.getTaskList();
        String target = input.substring(4).trim();
        int numberFound = 0;
        List<Task> foundTasks = new ArrayList<>();
        for(int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String description = task.getDescription();
            if(description.contains(target)) {
                numberFound++;
                foundTasks.add(task);
            }
        }
        if(numberFound == 0) {
            System.out.println("Sorry, no task is found");
        } else {
            System.out.println("I found " + numberFound + " task(s) for you:");
            for (Task task : foundTasks) {
                printToTerminal(task, foundTasks.indexOf(task) + 1);
            }
        }
    }
}
