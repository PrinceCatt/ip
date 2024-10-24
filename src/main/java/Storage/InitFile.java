package Storage;

import Entity.TaskList;

import java.io.File;

import static Storage.Retrieve.retrieveData;

public class InitFile {

    private static int todo = 1;
    private static int deadline = 2;
    private static int event = 3;
    private static final String path = "YukinoData.txt";


    /**
     * Initialise message list when program starts
     *
     * <p>This method calls the retrieve data method to retrieve data if the
     * file is already created at designated path</p>
     * @param list The message list to store retrieved data into.
     * @throws Exception If any error occurs.
     * @see java.io.File;
     */

    public static void initFile(TaskList list){
        try {
            File file = new File("YukinoData.txt");
            if(file.createNewFile()) {
            }
            else {
                retrieveData(list);
            }
        }
        catch(Exception e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }



}
