package Storage;

import Entity.Deadline;
import Entity.Event;
import Entity.TaskList;
import Entity.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Converter.convertToDate;

public class Retrieve {

    private static int todo = 1;
    private static int deadline = 2;
    private static int event = 3;
    private static final String path = "YukinoData.txt";

    /**
     * Retrieves data
     *
     * <p>This method retrieves data from the local data file
     * and store into a new message list when the program starts</p>
     * @param list The message list to store retrieved data.
     * @throws FileNotFoundException If no data file is found.
     * @see java.io.File;
     */

    public static void retrieveData(TaskList list){
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split("\\|");
                String done = data[1].trim();
                boolean isDone = false;
                if(done == "1") {
                    isDone = true;
                }
                else if (done == "0") {
                    isDone = false;
                }

                String description = data[2].trim();
                if (data.length == 3) {                               //todo
                    Todo todo = new Todo(description, isDone);
                    list.addTask(todo);
                }
                else if (data.length == 4) {                          //deadline
                    String endTime = data[3].trim();
                    Deadline deadline = new Deadline(description, convertToDate(endTime), isDone);
                    list.addTask(deadline);
                }
                else if (data.length == 5) {                          //event
                    String startTime = data[3].trim();
                    String endTime = data[4].trim();
                    Event event = new Event(description, convertToDate(startTime), convertToDate(endTime), isDone);
                    list.addTask(event);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
