import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.*;

public class ChangeCreatedDate {

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            File file = new File(args[0]);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            } else {
                file.createNewFile();
            }
        }

        LocalDate date = LocalDate.parse(args[1]);
        LocalTime time = LocalTime.now();
        Path file = Paths.get(args[0]);
        FileTime fileTime = FileTime.fromMillis(getMillisecondsSince1970(date, time));
        Files.setAttribute(file, "creationTime", fileTime);
    }

    public static long getMillisecondsSince1970(LocalDate date, LocalTime time) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                date,
                time,
                ZoneId.systemDefault());
        return zonedDateTime.toInstant().toEpochMilli();
    }
}
