package org.eyalgo.filesystem.files;

import org.eyalgo.filesystem.files.size.SimpleSizeCalculator;

public class Drive extends MyFileContainer {

    Drive(String name, MyFileSystemContainer fileSystem) {
	super(name, fileSystem, new SimpleSizeCalculator());
    }

    @Override
    public FileType type() {
	return FileType.Drive;
    }
}
