package org.eyalgo.filesystem.files;

import static org.eyalgo.filesystem.files.MyFile.PATH_DELIMITER;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TextFileTest {
    private final static String PATH_OF_DRIVE_C = PATH_DELIMITER + "c" + PATH_DELIMITER;
    private TextFile file;

    @Before
    public void setup() {
	MyFileSystem fs = new MyFileSystem();
	fs.create(FileType.Drive, "c", PATH_DELIMITER);
	file = (TextFile) fs.create(FileType.Text, "file-name", PATH_OF_DRIVE_C);
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
