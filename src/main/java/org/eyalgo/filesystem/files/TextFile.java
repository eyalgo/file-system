package org.eyalgo.filesystem.files;

public class TextFile extends MyFile {
    private String content;

    public TextFile(String name, MyFile parent) {
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
}
