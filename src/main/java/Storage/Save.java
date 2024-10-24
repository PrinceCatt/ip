package Storage;

import Entity.Task;
import Entity.TaskList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Save {

    private static final String path = "YukinoData.txt";

    /**
     * writes converted String into file
     *
     * <p>This method calls converter to convert message
     * in the list and writes the converted message into local data file</p>
     * @param list The message list to convert and write.
     * @see java.io.FileWriter;
     */

    public static void writeToFile(TaskList list) throws IOException {
        try {
            List<Task> tasks = list.getTaskList();
            FileWriter fw = new FileWriter(path);
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                String toWrite = task.toFile();
                fw.write(toWrite + "\n");
            }
            fw.close();
        }
        catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

}
