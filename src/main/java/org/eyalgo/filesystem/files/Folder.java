package org.eyalgo.filesystem.files;

public class Folder extends MyFile {

    public Folder(String name, MyFile parent) {
	super(name, parent);
    }

    @Override
    public FileType type() {
	return FileType.Folder;
    }

}
