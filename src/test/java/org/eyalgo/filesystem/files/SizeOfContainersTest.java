package org.eyalgo.filesystem.files;

import static org.eyalgo.filesystem.files.MyFile.PATH_DELIMITER;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SizeOfContainersTest {
    private MyFileSystem fs;
    private final static String PATH_OF_DRIVE_C = PATH_DELIMITER + "c" + PATH_DELIMITER;

    @Before
    public void setup() {
	fs = new MyFileSystem();
	assertThat(fs.size(), equalTo(0));
    }

    @Test
    public void whenNoChildrent_sizeIsZero() {
	MyFile drive = fs.create(FileType.Drive, "c", PATH_DELIMITER);
	assertThat(drive.size(), equalTo(0));
    }

    @Test
    public void whenChildrenTextFiles_thenShouldReturnTheirSum() {
	MyFile drive = fs.create(FileType.Drive, "c", PATH_DELIMITER);
	MyFile file1 = fs.create(FileType.Text, "n1", PATH_OF_DRIVE_C);
	MyFile file2 = fs.create(FileType.Text, "n2", PATH_OF_DRIVE_C);
	assertThat(drive.size(), equalTo(0));

	// Allowing by reference to modify files...
	String content1 = "this is new content";
	((TextFile) file1).writeContent(content1);

	String content2 = "more content for another file";
	((TextFile) file2).writeContent(content2);

	assertThat(drive.size(), equalTo(content1.length() + content2.length()));
    }

//    @Test
//    public void sumOfFolderAndFiles() {
//	Drive drive = new Drive("c");
//	Folder folder1 = new Folder("f1", drive);
//	Folder folder2 = new Folder("f2", drive);
//
//	TextFile file1 = new TextFile("n1", drive);
//	String content1 = "this is new content";
//	file1.writeContent(content1);
//
//	TextFile file2 = new TextFile("n2", folder1);
//	String content2 = "more content for another file";
//	file2.writeContent(content2);
//
//	drive.add(file1);
//	drive.add(folder1);
//	drive.add(folder2);
//	folder1.add(file2);
//
//	assertThat(drive.size(), equalTo(content1.length() + content2.length()));
//    }
//
//    @Test
//    public void sumOfFoldersAndFilesInZipShouldBeDividedToTwo() {
//	Drive drive = new Drive("c");
//	Zip zip = new Zip("z", drive);
//	Folder folder1 = new Folder("f1", zip);
//	Folder folder2 = new Folder("f2", zip);
//
//	TextFile file1 = new TextFile("n1", zip);
//	String content1 = "this is new content";
//	file1.writeContent(content1);
//
//	TextFile file2 = new TextFile("n2", folder1);
//	String content2 = "more content for another file";
//	file2.writeContent(content2);
//
//	TextFile file3 = new TextFile("n3", drive);
//	String content3 = "third content";
//	file3.writeContent(content3);
//
//	drive.add(zip);
//	drive.add(file3);
//	zip.add(file1);
//	zip.add(folder1);
//	zip.add(folder2);
//	folder1.add(file2);
//
//	int expectedSizeOfZip = (content1.length() + content2.length()) / 2;
//	assertThat(zip.size(), equalTo(expectedSizeOfZip));
//
//	int expectedSizeOfDrive = expectedSizeOfZip + content3.length();
//	assertThat(drive.size(), equalTo(expectedSizeOfDrive));
//    }
}
