package org.eyalgo.filesystem.files;

import org.eyalgo.filesystem.files.size.SizeCalculator;

abstract class MyFileSystemContainer extends MyFileContainer {

    MyFileSystemContainer(String name, MyFile parent, SizeCalculator sizeCalculator) {
	super(name, parent, sizeCalculator);
    }
}
