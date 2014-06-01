package org.eyalgo.filesystem.files;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TextFileTest {
    private TextFile file;
    private Drive drive;

    @Before
    public void setup() {
	drive = new Drive("c");
	file = new TextFile("file-name", drive);
	drive.add(file);
    }

    @Test
    public void verifyTextFile() {
	assertThat(file.type(), is(FileType.Text));
	assertThat(file.getContent(), is(("")));
    }
    
    @Test
    public void verifyContentAndSize() throws Exception {
	String content = "this is new content";
	file.writeContent(content);
	assertThat(file.getContent(), is(content));
	assertThat(file.size(), equalTo(content.length()));
    }
}
