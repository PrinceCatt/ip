import Entity.TaskList;
import Storage.InitFile;

import java.io.IOException;
import java.util.Scanner;

import static Command.PreHandle.preHandle;

public class Yukino {

    public static void main(String[] args) throws IOException {
        String logo = "__   __         _        \n"
                + "\\ \\ / /_     _ / /___ __ ______ ______      \n"
                + " \\   / //  / // ___/ / // ___ ///--/ /     \n"
                + "  / // /__/ //   \\  / // / / ///__/ /  \n"
                + " /_/ /____/ /_/ \\_\\/_//_/ /_//_____/ \n";
        System.out.println(logo);
        System.out.println("Hello, I am Yukino!\n");
        System.out.println("What can I do for you?\n");
        System.out.println("-----------------------------------\n");
        TaskList list = new TaskList();
        InitFile.initFile(list);
        Scanner scanner = new Scanner(System.in);
        String input = null;
        preHandle(list);
    }
}