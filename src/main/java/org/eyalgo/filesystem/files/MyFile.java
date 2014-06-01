package org.eyalgo.filesystem.files;

public abstract class MyFile {
    public static final String PATH_DELIMITER = "\\";
    private final String name;
    private final MyFile parent;

    public MyFile(String name, MyFile parent) {
	this.name = name;
	this.parent = parent;
    }

    public final String name() {
	return name;
    }

    public String path() {
	return parent.path() + name + PATH_DELIMITER;
    }

    public abstract int size();

    public abstract FileType type();
}
