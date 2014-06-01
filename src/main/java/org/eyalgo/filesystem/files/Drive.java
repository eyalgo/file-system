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

    @Override
    public MyFile getFile(String... pathSplit) {
	checkValidSizeOfPath(pathSplit);
	checkFileName(pathSplit[0]);
	if (pathSplit.length == 1) {
	    return this;
	}
	String childToFind = pathSplit[1];
	return getFile(children().get(childToFind), pathSplit);
    }

    private MyFile getFile(MyFile current, String... pathSplit) {
	if (current == null) {
	    throw new PathNotFoundException(String.format("Path not found. %s", Arrays.asList(pathSplit)));
	}
	return current.getFile(Arrays.copyOfRange(pathSplit, 1, pathSplit.length));
    }

    private void checkValidSizeOfPath(String... pathSplit) {
	if (pathSplit.length == 0) {
	    throw new PathNotFoundException(String.format("Path not found."));
	}
    }

    private void checkFileName(String currentFilePathName) {
	if (!name().equals(currentFilePathName)) {
	    throw new PathNotFoundException(String.format("Path not found. Drive %s", currentFilePathName));
	}
    }
}
