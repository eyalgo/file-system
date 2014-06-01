package org.eyalgo.filesystem.files;

public class Drive extends MyFile {

    public Drive(String name) {
	super(name, null);
    }

    @Override
    public FileType type() {
	return FileType.Drive;
    }

    @Override
    public String path() {
	return name() + PATH_DELIMITER;
    }
    
    public boolean containesFile() {
	return false;
    }

}
