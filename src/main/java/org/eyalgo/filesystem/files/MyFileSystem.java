package org.eyalgo.filesystem.files;

import org.eyalgo.filesystem.exceptions.IllegalFileSystemOperationException;
import org.eyalgo.filesystem.exceptions.PathAlreadyExistsException;
import org.eyalgo.filesystem.files.size.SimpleSizeCalculator;

public class MyFileSystem extends MyFileContainer {

    public MyFileSystem() {
	super("", null, new SimpleSizeCalculator());
    }

    @Override
    public String path() {
	return PATH_DELIMITER;
    }

    public MyFile create(FileType fileType, String name, String parentPath) {
	MyFile parentByPath = getFileByPath(parentPath);
	if (parentByPath instanceof MyFileContainer) {
	    MyFileContainer filesContainer = (MyFileContainer) parentByPath;
	    if (filesContainer.childExists(name)) {
		throw new PathAlreadyExistsException(String.format("Path exists: %s", filesContainer.path()
			+ PATH_DELIMITER + name));
	    }
	    return handleNewFile(fileType, name, filesContainer);
	}
	throw new IllegalFileSystemOperationException(String.format(
		"Only file of type container can hold other files. Got %s", parentByPath.type()));
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

    private MyFile handleNewFile(FileType fileType, String name, MyFileContainer filesContainer) {
	MyFile newFile = fileType.create(name, filesContainer);
	filesContainer.add(newFile);
	return newFile;
    }

    @Override
    public FileType type() {
	return FileType.FILE_SYSTEM;
    }

    public MyFile getFileByPath(String path) {
	if (PATH_DELIMITER.equals(path)) {
	    return this;
	}
	String[] splitPath = path.split(PATH_DELIMITER + PATH_DELIMITER);
	return this.getFile(splitPath);
    }
}
