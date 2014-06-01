package org.eyalgo.filesystem.files;

public class Folder implements MyFile {
    private final String name;
    private final MyFile parent;

    public Folder(String name, MyFile parent) {
	this.name = name;
	this.parent = parent;
    }

    @Override
    public FileType type() {
	return FileType.Folder;
    }

    @Override
    public String name() {
	return name;
    }

    @Override
    public String path() {
	return parent.path() + name + PATH_DELIMITER;
    }
}
