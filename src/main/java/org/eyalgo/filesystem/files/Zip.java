package org.eyalgo.filesystem.files;

public class Zip extends MyFileContainer {

    public Zip(String name, MyFile parent) {
	super(name, parent);
    }

    @Override
    public FileType type() {
	return FileType.Zip;
    }

}
