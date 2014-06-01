package org.eyalgo.filesystem.files;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.eyalgo.filesystem.exceptions.PathNotFoundException;
import org.junit.Test;

public class GetFileByPathTest {

    @Test
    public void driveWithSameLetterAndOnePath_shouldReturnItself() {
	MyFile drive = new Drive("c");
	MyFile fileFound = drive.getFile(new String[] { "c" });
	assertThat(fileFound, sameInstance(drive));
    }

    @Test(expected = PathNotFoundException.class)
    public void driveWithDifferentLetterAndOneInPath_shouldThrowPathNotFoundException() {
	MyFile drive = new Drive("c");
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
    
    @Test
    public void textInsideZipInsideFolderInsideZipInsideDrive() {
	Drive drive = new Drive("c");
	
	Zip zip1 = new Zip("zip1", drive);
	drive.add(zip1);
	
	Folder folder1 = new Folder("folder1", zip1);
	zip1.add(folder1);
	
	Zip zip2 = new Zip("zip2", folder1);
	folder1.add(zip2);
	
	MyFile textFile = new TextFile("textFile-name", zip2);
	zip2.add(textFile);
	
	assertThat(drive.getFile(new String[] { "c", "zip1","folder1","zip2", "textFile-name"}), sameInstance(textFile));
	assertThat((Zip)drive.getFile(new String[] { "c", "zip1","folder1","zip2"}), sameInstance(zip2));
	assertThat((Folder)drive.getFile(new String[] { "c", "zip1","folder1"}), sameInstance(folder1));
	assertThat((Zip)drive.getFile(new String[] { "c", "zip1"}), sameInstance(zip1));
	assertThat((Drive)drive.getFile(new String[] { "c"}), sameInstance(drive));
    }

    @Test(expected = PathNotFoundException.class)
    public void driveThatGetsLongerPath_shouldThrowPathNotFoundException() throws Exception {
	Drive drive = new Drive("c");
	drive.getFile(new String[] { "c", "d" });
    }
}
