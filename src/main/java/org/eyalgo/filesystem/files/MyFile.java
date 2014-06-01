package org.eyalgo.filesystem.files;

import java.util.Map;

import com.google.common.collect.Maps;

public abstract class MyFile {
    public static final String PATH_DELIMITER = "\\";
    private final String name;
    private final MyFile parent;
    private final Map<String, MyFile> children;

    public MyFile(String name, MyFile parent) {
	this.name = name;
	this.parent = parent;
	this.children = Maps.newHashMap();
    }

    public final String name() {
	return name;
    }

    public String path() {
	return parent.path() + name + PATH_DELIMITER;
    }

    public int size() {
	return -1;
    }
    
    public void add(MyFile file) {
	children.put(file.name, file);
	
    }

    public boolean exists(String[] pathSplit) {
	String directFileName = pathSplit[0];
	if (children.containsKey(directFileName)) {
	    return true;
	}
	return false;
    }
    
    public abstract FileType type();
}
