package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {

    /**
     * Converts time to LocalDateTime format
     *
     * <p>This method converts the input time to LocalDateTime format</p>
     * @param input The input of time to be converted.
     */

    public static LocalDateTime convertToDate(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-dd-MM-yyyy");
        return LocalDateTime.parse(input, formatter);
    }


    /**
     * Converts task to String.
     *
     * <p>This method takes task stored and convert to form that is
     * ready for writing into local data file</p>
     * @param time The task stored
     * @return The String form of the task ready for writing into file.
     */

    public static String convertToString(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-dd-MM-yyyy");
        String date = time.format(formatter);
        return date;
    }
}
