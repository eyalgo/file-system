package org.eyalgo.filesystem.files;

public interface MyFile {
    public static final String PATH_DELIMITER = "\\";

    FileType type();

    String name();

    String path();

}
