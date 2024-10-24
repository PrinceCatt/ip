package Command;

import Entity.Task;
import Entity.TaskList;
import Storage.InitFile;

import java.io.IOException;
import java.util.List;

import static Storage.Save.writeToFile;

public class Delete {
    /**
     * Delete an existing item to message list
     *
     * <p>This method is to extract information
     * from the user input and delete corresponding
     * item from the message list</p>
     * @param input The input to be deleted.
     * @param list The message list to delete from.
     * @throws IOException If an error occurs.
     */

    public static void delete(TaskList list, String input) throws IOException {
        String[] sentences = input.split(" ");
        List<Task> tasks = list.getTaskList();
        int i = 0;
        for(i = 0; i < list.getTaskListSize(); i++) {
            if(tasks.get(i).getDescription().equals(sentences[1])) {
                list.removeTask(tasks.get(i));
                break;
            }
        }
        if(tasks.size() == 0 || i > tasks.size() - 1) {
            System.out.println("Sorry, you are deleting an event that has not been added");
        }
        else {
            System.out.println("------------------------------------\n");
            System.out.println("You have successfully deleted this task");
            System.out.println("------------------------------------\n");
        }
        writeToFile(list);
    }
}
