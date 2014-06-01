package org.eyalgo.filesystem.files;

public class Drive implements MyFile {

    private final String name;

    public Drive(String name) {
	this.name = name;
    }

    @Override
    public FileType type() {
	return FileType.Drive;
    }

    @Override
    public String name() {
	return name;
    }

    @Override
    public String path() {
	return name + PATH_DELIMITER;
    }
    
    public boolean containesFile() {
	return false;
    }

}
