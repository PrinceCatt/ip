package Entity;

import java.time.LocalDateTime;

import static Utils.Converter.convertToString;

public class Event extends Task {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Event(String description, LocalDateTime startTime, LocalDateTime endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Event(String description, LocalDateTime startTime, LocalDateTime endTime, boolean isDone) {
        super(description, isDone);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " from: " + startTime + " by: " + endTime;
    }

    @Override
    public String toFile() {
        return "E" + " | " + super.toFile() + " | " + convertToString(startTime) + " | " + convertToString(endTime);
    }
}
