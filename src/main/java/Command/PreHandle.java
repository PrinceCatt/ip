package Command;

import Entity.TaskList;
import java.io.IOException;
import java.util.Scanner;

import static Command.Add.addList;
import static Command.Delete.delete;
import static Command.Find.find;
import static Command.Mark.mark;
import static Command.Show.listShow;
import static java.lang.System.exit;


public class PreHandle {
    public static void preHandle(TaskList list) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while(true) {
            input = scanner.nextLine();
            String command = input.split(" ")[0];
            if (command.equals("bye")) {
                System.out.println("-----------------------------------\n");
                System.out.println("Bye! Hope to see you soon!\n");
                System.out.println("-----------------------------------\n");
                break;
            }
            else if (input.equals("list")) {
                listShow(list);
            }
            else if (command.equals("mark") || command.equals("unmark")) {
                mark(list, input);
            }
            else if (command.equals("delete")) {
                delete(list, input);
            }
            else if (command.equals("add")) {
                addList(list, input);
            }
            else if (command.equals("find")) {
                find(list, input);
            }
            else if (command.equals("exit")) {
                System.out.println("Bye! Hope to see you soon!\n");
                exit(0);
            }
            else {
                System.out.println("Sorry, your command is not recognized!");
            }
        }
    }
}
