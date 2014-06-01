package org.eyalgo.filesystem.files.path;

import java.util.Map;

import org.eyalgo.filesystem.files.MyFile;

public class PathToFile {

    public PathToFile() {
    }

    public MyFile get(Map<String, MyFile> children, String... path) {
	if (path.length == 1) {
	    String candidateChild = path[0];
	    if (children.containsKey(candidateChild)) {
		return children.get(candidateChild);
	    }
	}
	return null;
    }

}
