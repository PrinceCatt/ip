package Command;

import Entity.Deadline;
import Entity.Event;
import Entity.TaskList;
import Entity.Todo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
            String keyword = input.split(" ")[1];
            if (keyword.equals("todo")) {
                String eventName = input.substring(8).trim();
                if (eventName.isEmpty()) {
                    System.out.println("Event name is empty");
                    return;
                }
                Todo todo = new Todo(eventName);
                list.addTask(todo);
                System.out.println("-----------------------------------");
                System.out.println("added:" + eventName);
            } else if (keyword.equals("deadline")) {
                String[] strings = input.split("/");
                String endTime = strings[strings.length - 1].split(" ")[1];
                String eventName = strings[strings.length - 2].split(" ")[2];
                LocalDateTime endDate = convertToDate(endTime);

                String keyword1 = strings[strings.length - 1].split(" ")[0];

                if (!keyword1.equals("by")) {
                    System.out.println("The time keyword entered is incorrect");
                    return;
                }

                if (endDate == null) {
                    return;
                }
                if (eventName.equals("")) {
                    System.out.println("Event name is empty");
                    return;
                }
                Deadline deadline = new Deadline(eventName, endDate);
                list.addTask(deadline);
                System.out.println("-----------------------------------");
                System.out.println("added:" + eventName);
            } else if (keyword.equals("event")) {
                String[] strings = input.split("/");
                String keyword1 = strings[strings.length - 1].split(" ")[0];
                String keyword2 = strings[strings.length - 2].split(" ")[0];

                if (!keyword1.equals("from") || !keyword2.equals("by")) {
                    System.out.println("The time keyword entered is incorrect");
                    return;
                }
                String startTime = strings[strings.length - 2].split(" ")[1];
                String endTime = strings[strings.length - 1].split(" ")[1];
                String eventName = strings[strings.length - 3].split(" ")[2];
                LocalDateTime endDate = convertToDate(endTime);
                LocalDateTime startDate = convertToDate(startTime);
                if (startDate == null || endDate == null) {
                    return;
                }
                if (eventName.isEmpty()) {
                    System.out.println("Event name is empty");
                    return;
                }
                Event event = new Event(eventName, startDate, endDate);
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
