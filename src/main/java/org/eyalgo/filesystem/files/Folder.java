package org.eyalgo.filesystem.files;

public class Folder extends MyFileContainer {

    public Folder(String name, MyFile parent) {
	super(name, parent);
    }

    @Override
    public FileType type() {
	return FileType.Folder;
    }

}
