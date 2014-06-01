package org.eyalgo.filesystem.files;

import java.util.Map;

import com.google.common.collect.Maps;

public abstract class MyFileContainer extends MyFile {
    private final Map<String, MyFile> children;

    public MyFileContainer(String name, MyFile parent) {
	super(name, parent);
	this.children = Maps.newHashMap();
    }

    public void add(MyFile file) {
	children.put(file.name(), file);

    }

    public boolean exists(String[] pathSplit) {
	String directFileName = pathSplit[0];
	if (children.containsKey(directFileName)) {
	    return true;
	}
	return false;
    }
}
