package org.eyalgo.filesystem.files;

import java.util.Arrays;

import org.eyalgo.filesystem.exceptions.PathNotFoundException;

public class TextFile extends MyFile {
    private String content;

    TextFile(String name, MyFile parent) {
	super(name, parent);
	content = "";
    }

    @Override
    public FileType type() {
	return FileType.Text;
    }

    public String getContent() {
	return content;
    }

    public void writeContent(String content) {
	this.content = content;
    }

    @Override
    public int size() {
	return content.length();
    }

    @Override
    public MyFile getFile(String... pathSplit) {
	if (pathSplit.length == 1) {
	    if (name().equals(pathSplit[0])) {
		return this;
	    }
	}
	throw new PathNotFoundException(String.format("Path not found. %s", Arrays.asList(pathSplit)));
    }
}
