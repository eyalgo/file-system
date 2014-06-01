package org.eyalgo.filesystem.system;

import static org.eyalgo.filesystem.files.MyFile.PATH_DELIMITER;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.eyalgo.filesystem.exceptions.PathAlreadyExistsException;
import org.eyalgo.filesystem.files.FileType;
import org.eyalgo.filesystem.files.MyFile;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyFileSystemTest {
    private MyFileSystem fs;

    @Before
    public void setup() {
	fs = new MyFileSystem();
    }

    @Test
    public void whenCreatingNonExistingDrive_shouldReturnIt() {
	String name = "c";
	MyFile driveC = fs.createDrive(name);

	assertThat(driveC.type(), is(FileType.Drive));
	assertThat(driveC.name(), is(name));
	assertThat(driveC.path(), is(name + PATH_DELIMITER));
    }

    @Test(expected = PathAlreadyExistsException.class)
    public void whenCreatingDriveWithTheSameName_shouldThrowPathAlreadyExists() {
	String name = "c";
	fs.createDrive(name);
	fs.createDrive(name);
    }

    @Test
    public void whenAddingFolderToDrive_shuouldReturnFolder() {
	fs.createDrive("c");
	String name = "the-folder";
	String path = "c\\";
	MyFile theFolder = fs.create(FileType.Folder, name, path);
	assertThat(theFolder.type(), is(FileType.Folder));
	assertThat(theFolder.name(), is(name));
	assertThat(theFolder.path(), is("c" + PATH_DELIMITER + name + PATH_DELIMITER));
    }
    
    @Test
    @Ignore
    public void addFolderToAnotherFolder() {
	fs.createDrive("c");
	String parentFolder = "parentFolder";
	fs.create(FileType.Folder, parentFolder, "c\\");
	
	String path = "c\\parentFolder\\";
	String theFolderName = "the-folder";
	MyFile theFolder = fs.create(FileType.Folder, theFolderName, path);
	assertThat(theFolder.type(), is(FileType.Folder));
	assertThat(theFolder.name(), is(theFolderName));
	assertThat(theFolder.path(), is("c\\parentFolder\\"+theFolderName));
    }
}
