package org.eyalgo.filesystem.files;

import org.eyalgo.filesystem.exceptions.IllegalFileSystemOperationException;

enum FileType {
    Drive {
	@Override
	MyFile create(String name, MyFileContainer parent) {
	    if (rootFileSystem(parent)) {
		return new Drive(name, (MyFileSystemContainer) parent);
	    }
	    throw new IllegalFileSystemOperationException(String.format(
		    "Drive can only be child of MyFileSystem. Got parent of: %s", parent.type()));
	}

	private boolean rootFileSystem(MyFileContainer parent) {
	    return parent instanceof MyFileSystemContainer;
	}
    },
    Folder {
	@Override
	MyFile create(String name, MyFileContainer parent) {
	    return new Folder(name, parent);
	}
    },
    Text {
	@Override
	MyFile create(String name, MyFileContainer parent) {
	    return new TextFile(name, parent);
	}
    },
    Zip {
	@Override
	MyFile create(String name, MyFileContainer parent) {
	    return new Zip(name, parent);
	}
    },
    FILE_SYSTEM {
	@Override
	MyFile create(String name, MyFileContainer parent) {
	    return new MyFileSystem();
	}
    };
    abstract MyFile create(String name, MyFileContainer parent);
}
