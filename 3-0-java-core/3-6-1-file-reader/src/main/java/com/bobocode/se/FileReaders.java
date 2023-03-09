package com.bobocode.se;

import com.bobocode.util.ExerciseNotCompletedException;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * {@link FileReaders} provides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName)).stream().map(s->s + System.lineSeparator()).collect(
                    Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        throw new ExerciseNotCompletedException(); //todo
    }
}
