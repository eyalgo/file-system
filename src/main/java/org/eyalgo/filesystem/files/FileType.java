package org.eyalgo.filesystem.files;

public enum FileType {
    Drive {
	@Override
	public MyFile create(String name, MyFile parent) {
	    return new Drive(name);
	}
    },
    Folder {
	@Override
	public MyFile create(String name, MyFile parent) {
	    return new Folder(name, parent);
	}
    },
    Text {
	@Override
	public MyFile create(String name, MyFile parent) {
	    return new TextFile(name, parent);
	}
    },
    Zip {
	@Override
	public MyFile create(String name, MyFile parent) {
	    return new Zip(name, parent);
	}
    },
    FILE_SYSTEM {
	@Override
	public MyFile create(String name, MyFile parent) {
	    return new MyFileSystem();
	}
    };
    public abstract MyFile create(String name, MyFile parent);
}
