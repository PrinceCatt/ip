package Command;

import Entity.Deadline;
import Entity.Event;
import Entity.TaskList;
import Entity.Todo;

import java.io.IOException;

import static Storage.Save.writeToFile;
import static Utils.Converter.convertToDate;

public class Add {
    /**
     * Add new item to message list
     *
     * <p>This method is to extract information
     * from the user input and add them to the message list</p>
     * @param input The input to be added.
     * @param list The message list to add to.
     */

    public static void addList(TaskList list, String input) throws ArrayIndexOutOfBoundsException {
        try {
            if (input.contains("todo")) {
                String eventName = input.substring(8).trim();
                Todo todo = new Todo(eventName);
                list.addTask(todo);
                System.out.println("-----------------------------------");
                System.out.println("added:" + eventName);
            } else if (input.contains("deadline")) {
                String[] strings = input.split("/");
                String endTime = strings[strings.length - 1].split(" ")[1];
                String eventName = strings[strings.length - 2].split(" ")[2];
                Deadline deadline = new Deadline(eventName, convertToDate(endTime));
                list.addTask(deadline);
                System.out.println("-----------------------------------");
                System.out.println("added:" + eventName);
            } else if (input.contains("event")) {
                String[] strings = input.split("/");
                String startTime = strings[strings.length - 2].split(" ")[1];
                String endTime = strings[strings.length - 1].split(" ")[1];
                String eventName = strings[strings.length - 3].split(" ")[2];

                Event event = new Event(eventName, convertToDate(startTime), convertToDate(endTime));
                list.addTask(event);
                System.out.println("-----------------------------------");
                System.out.println("added:" + eventName);
            }
            writeToFile(list);
            int taskNumber = list.getTaskListSize();
            System.out.println("Now you have " + taskNumber + " tasks");
            System.out.println("-----------------------------------\n");
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            e.printStackTrace();
            System.out.println("Sorry, you have entered an invalid command");
        }
    }
}
