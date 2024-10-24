package Entity;

import java.time.LocalDateTime;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    /* Constructor with completion status*/
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFile() {
        return "T" + " | " + super.toFile();
    }
}
