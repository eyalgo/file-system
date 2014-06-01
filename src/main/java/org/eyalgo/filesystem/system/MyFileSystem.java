package org.eyalgo.filesystem.system;

import static org.eyalgo.filesystem.files.MyFile.PATH_DELIMITER;

import java.util.Map;

import org.eyalgo.filesystem.exceptions.PathAlreadyExistsException;
import org.eyalgo.filesystem.files.Drive;
import org.eyalgo.filesystem.files.FileType;
import org.eyalgo.filesystem.files.Folder;
import org.eyalgo.filesystem.files.MyFile;

import com.google.common.collect.Maps;

public class MyFileSystem {
    private final Map<String, Drive> drives;

    public MyFileSystem() {
	drives = Maps.newHashMap();
    }

    public MyFile createDrive(String name) {
	if (drives.containsKey(name)) {
	    throw new PathAlreadyExistsException(String.format("Drive %s already exists", name));
	}
	Drive drive = new Drive(name);
	drives.put(name, drive);
	return drive;
    }

    public MyFile create(FileType file, String name, String parentPath) {
	String[] splitPath = parentPath.split(PATH_DELIMITER + PATH_DELIMITER);
	Drive drive = drives.get(splitPath[0]);
	Folder folder = new Folder(name, drive);
	return folder;
    }
    
    public MyFile fileFromPath() {
	return null;
    }

}
