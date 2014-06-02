package org.eyalgo.filesystem.files;

import org.eyalgo.filesystem.files.size.CompressedSizeCalculator;

public class Zip extends MyFileContainer {

    Zip(String name, MyFile parent) {
	super(name, parent, new CompressedSizeCalculator());
    }

    @Override
    public FileType type() {
	return FileType.Zip;
    }

}
