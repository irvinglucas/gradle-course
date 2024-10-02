package com.example;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFile;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;

/**
 * --- Docs for studying purposes ---
 * Jar count task class. To keep this task wired with other tasks, it's recommended to use
 * default Gradle types, such as:
 * - ConfigurableFileCollection, for multiple files/folders
 * - RegularFileProperty, for a single file
 * - DirectoryProperty, for a single directory
 */
// @CacheableTask only if this task is eligible to be cacheable
public abstract class JarCount extends DefaultTask {

    /**
     * Task's input function.
     * @return {@link ConfigurableFileCollection}
     */
    @InputFiles
    public abstract ConfigurableFileCollection getAllJars();

    /**
     * Task's output function.
     * @return {@link RegularFileProperty}
     */
    @OutputFile
    public abstract RegularFileProperty getCountFile();

    /**
     * Task's actual implementation. The @TaskActin annotation is mandatory for gradle, to identify
     * the method that should perform some actions when the task is executed.
     * @throws IOException if for some reason the system couldn't write the file.
     */
    @TaskAction
    public void doCount() throws IOException {
        Set<File> jarFiles = getAllJars().getFiles();
        int count = jarFiles.size();

        File out = getCountFile().get().getAsFile();
        Files.write(out.toPath(), Collections.singleton("" + count));
    }
}
