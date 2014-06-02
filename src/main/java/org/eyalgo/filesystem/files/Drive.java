package org.eyalgo.filesystem.files;

import org.eyalgo.filesystem.files.size.SimpleSizeCalculator;

public class Drive extends MyFileContainer {

    Drive(String name) {
	super(name, null, new SimpleSizeCalculator());
    }

    @Override
    public FileType type() {
	return FileType.Drive;
    }

    @Override
    public String path() {
	return name() + PATH_DELIMITER;
    }
}
