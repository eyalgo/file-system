package org.eyalgo.filesystem.files;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.eyalgo.filesystem.exceptions.PathNotFoundException;
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

    @Test
    public void whenPathSingleAndSameName_thenReturnThis() {
	Drive drive = new Drive("c");
	MyFile textFile = new TextFile("textFile-name", drive);
	drive.add(textFile);

	MyFile fileFound = textFile.getFile(new String[] { "textFile-name" });
	assertThat(fileFound, sameInstance(textFile));
    }

    @Test(expected = PathNotFoundException.class)
    public void whenPathSingleAndDifferentName_thenThrowException() {
	Drive drive = new Drive("c");
	MyFile textFile = new TextFile("textFile-name", drive);
	drive.add(textFile);

	textFile.getFile(new String[] { "textFile-name-different" });
    }

    @Test(expected = PathNotFoundException.class)
    public void whenPathMoreThanOne_thenThrowException() {
	Drive drive = new Drive("c");
	MyFile textFile = new TextFile("textFile-name", drive);
	drive.add(textFile);

	textFile.getFile(new String[] { "textFile-name", "more-file" });
    }

    @Test(expected = PathNotFoundException.class)
    public void emptyPath_thenThrowException() {
	Drive drive = new Drive("c");
	MyFile textFile = new TextFile("textFile-name", drive);
	drive.add(textFile);

	textFile.getFile(new String[] {});
    }
}
