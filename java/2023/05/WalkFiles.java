import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFiles {

    private final Path path;

    public WalkFiles() {
        path = Paths.get("io");
    }

    public static void main(String[] args) {
        WalkFiles walkFiles = new WalkFiles();
        walkFiles.process();
    }

    private void process() {
        try {
            Files.walkFileTree(path, new FileWalker());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class FileWalker implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.printf("Visiting Directory: %s%n", dir.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.printf("Visited File: %s%n", file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}
