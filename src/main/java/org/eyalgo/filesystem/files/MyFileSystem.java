package org.eyalgo.filesystem.files;

import java.util.Map;

import org.eyalgo.filesystem.exceptions.PathAlreadyExistsException;
import org.eyalgo.filesystem.files.size.SimpleSizeCalculator;

import com.google.common.collect.Maps;

public class MyFileSystem extends MyFileContainer {
    private final Map<String, Drive> drives;

    public MyFileSystem() {
	super("", null, new SimpleSizeCalculator());
	drives = Maps.newHashMap();
    }

    @Override
    public String path() {
	return PATH_DELIMITER;
    }

    public MyFile createDrive(String name) {
	if (drives.containsKey(name)) {
	    throw new PathAlreadyExistsException(String.format("Drive %s already exists", name));
	}
	Drive drive = new Drive(name);
	drives.put(name, drive);
	return drive;
    }

    public MyFile create(FileType fileType, String name, String parentPath) {
	// 1. find MyFile by path
	// 2. add a new file using the enum (avoid switch case)
	// Example fileType.create(name, parent);
	// 3. set this file's parent to the the one found in (1)
	return null;
    }

    public void delete(String path) {
	// 1. find file by path
	// 2. get parent
	// 3. remove the file from the parent (list of children)
	// 4. do the same for each children recuresevly (free up memory)
    }
    
    public void move(String source, String destination) {
	// 1. get files for source and destination
	// 2. remove source from list of children of its parent
	// 3. set new parent and add to list of children
    }
    
    public void writeToFile(String path, String content) {
	// 1. find file by path
	// 2. check that it's TextFile
	// 3. write content
    }
    
    private MyFile getFile(String path) {
	String[] splitPath = path.split(PATH_DELIMITER);
	return this.getFile(splitPath);
    }

    @Override
    public FileType type() {
	return FileType.FILE_SYSTEM;
    }

}
