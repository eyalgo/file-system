package org.eyalgo.filesystem.files;

import java.util.Arrays;
import java.util.Map;

import org.eyalgo.filesystem.exceptions.PathNotFoundException;
import org.eyalgo.filesystem.files.size.SizeCalculator;

import com.google.common.collect.Maps;

public abstract class MyFileContainer extends MyFile {
    private final Map<String, MyFile> children;
    private SizeCalculator sizeCalculator;

    public MyFileContainer(String name, MyFile parent, SizeCalculator sizeCalculator) {
	super(name, parent);
	this.sizeCalculator = sizeCalculator;
	this.children = Maps.newHashMap();
    }

    public void add(MyFile file) {
	children.put(file.name(), file);
    }

    @Override
    public final int size() {
	return sizeCalculator.size(children.values());
    }
    
    @Override
    public final MyFile getFile(String... pathSplit) {
	checkValidSizeOfPath(pathSplit);
	checkFileName(pathSplit[0]);
	if (pathSplit.length == 1) {
	    return this;
	}
	String childToFind = pathSplit[1];
	return getFile(children.get(childToFind), pathSplit);
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

    private MyFile getFile(MyFile current, String... pathSplit) {
	if (current == null) {
	    throw new PathNotFoundException(String.format("Path not found. %s", Arrays.asList(pathSplit)));
	}
	return current.getFile(Arrays.copyOfRange(pathSplit, 1, pathSplit.length));
    }

    public boolean exists(String[] pathSplit) {
	String directFileName = pathSplit[0];
	if (children.containsKey(directFileName)) {
	    return true;
	}
	return false;
    }
}
