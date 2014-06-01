package org.eyalgo.filesystem.files;

import org.eyalgo.filesystem.files.size.SimpleSizeCalculator;

public class Folder extends MyFileContainer {

    public Folder(String name, MyFile parent) {
	super(name, parent, new SimpleSizeCalculator());
    }

    @Override
    public FileType type() {
	return FileType.Folder;
    }

}
