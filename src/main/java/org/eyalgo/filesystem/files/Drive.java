package org.eyalgo.filesystem.files;

import java.util.Arrays;

import org.eyalgo.filesystem.exceptions.PathNotFoundException;
import org.eyalgo.filesystem.files.size.SimpleSizeCalculator;

public class Drive extends MyFileContainer {

    public Drive(String name) {
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
    
    public MyFile getFile(String... pathSplit) {
	if (pathSplit.length == 1) {
	    if (name().equals(pathSplit[0])) {
		return this;
	    }
	}
	throw new PathNotFoundException(String.format("Path not found. Drive %s", Arrays.asList(pathSplit)));
    }
    
    public boolean containesFile() {
	return false;
    }

}
