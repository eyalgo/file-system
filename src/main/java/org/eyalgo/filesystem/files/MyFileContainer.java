package org.eyalgo.filesystem.files;

import java.util.Map;

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

    public final int size() {
	return sizeCalculator.size(children.values());
    }
    
    public MyFile getFile(String... pathSplit) {
	return null;
    }

    public boolean exists(String[] pathSplit) {
	String directFileName = pathSplit[0];
	if (children.containsKey(directFileName)) {
	    return true;
	}
	return false;
    }
}
