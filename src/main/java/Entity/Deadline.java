package Entity;

import java.time.LocalDateTime;

import static Utils.Converter.convertToString;

public class Deadline extends Task {

    private LocalDateTime endTime;

    public Deadline(String description, LocalDateTime endTime) {
        super(description);
        this.endTime = endTime;
    }

    public Deadline(String description, LocalDateTime endTime, Boolean isDone) {
        super(description, isDone);
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " by: " + endTime;
    }

    @Override
    public String toFile() {
        return "D" + " | " + super.toFile() + " | " + convertToString(endTime);
    }
}
