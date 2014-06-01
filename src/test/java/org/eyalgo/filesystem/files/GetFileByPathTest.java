package org.eyalgo.filesystem.files;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.eyalgo.filesystem.exceptions.PathNotFoundException;
import org.junit.Test;

public class GetFileByPathTest {

    @Test
    public void driveWithSameLetterAndOnePath_shouldReturnItself() {
	Drive drive = new Drive("c");
	Drive fileFound = (Drive) drive.getFile(new String[] { "c" });
	assertThat(fileFound, sameInstance(drive));
    }

    @Test(expected = PathNotFoundException.class)
    public void driveWithDifferentLetterAndOneInPath_shouldThrowPathNotFoundException() {
	Drive drive = new Drive("c");
	drive.getFile(new String[] { "d" });
    }

    @Test
    public void textFileUnderDriveWithCorrectPath_shouldReturnTheFile() {
	Drive drive = new Drive("c");
	MyFile textFile = new TextFile("textFile-name", drive);
	drive.add(textFile);

	MyFile fileFound = drive.getFile(new String[] { "c", "textFile-name" });
	assertThat(fileFound, sameInstance(textFile));
    }

    @Test(expected = PathNotFoundException.class)
    public void driveThatGetsLongerPath_shouldThrowPathNotFoundException() throws Exception {
	Drive drive = new Drive("c");
	drive.getFile(new String[] { "c", "d" });
    }
}
