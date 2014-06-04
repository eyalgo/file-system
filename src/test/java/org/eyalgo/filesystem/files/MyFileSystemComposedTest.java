package org.eyalgo.filesystem.files;

import static org.eyalgo.filesystem.files.MyFile.PATH_DELIMITER;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.eyalgo.filesystem.exceptions.PathAlreadyExistsException;
import org.eyalgo.filesystem.exceptions.PathNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class MyFileSystemComposedTest {
    private MyFileSystemComposed fs;

    @Before
    public void setup() {
	fs = new MyFileSystemComposed();
    }

    @Test
    public void addDriveToFileSystem() {
	MyFile driveC = fs.create(FileType.Drive, "c", PATH_DELIMITER);
	assertThat(driveC.type(), is(FileType.Drive));
	assertThat(driveC.name(), is("c"));
	assertThat(driveC.path(), is(PATH_DELIMITER + "c" + PATH_DELIMITER));
    }

    @Test(expected = PathAlreadyExistsException.class)
    public void whenAddSameDrive_shouldGetPathAlreadyExists() {
	fs.create(FileType.Drive, "c", PATH_DELIMITER);
	fs.create(FileType.Drive, "c", PATH_DELIMITER);
    }

    @Test
    public void whenAddingFolderToDrive_shuouldReturnFolder() {
	fs.create(FileType.Drive, "c", PATH_DELIMITER);
	String name = "the-folder";
	String path = PATH_DELIMITER + "c" + PATH_DELIMITER;
	MyFile theFolder = fs.create(FileType.Folder, name, path);
	assertThat(theFolder.type(), is(FileType.Folder));
	assertThat(theFolder.name(), is(name));
	assertThat(theFolder.path(), is(path + name + PATH_DELIMITER));
    }

    @Test(expected = PathNotFoundException.class)
    public void whenAddingToWrongPath_shouldGetPathNotFoundException() {
	fs.create(FileType.Drive, "c", PATH_DELIMITER);
	String name = "the-folder";
	String path = PATH_DELIMITER + "d" + PATH_DELIMITER;
	fs.create(FileType.Folder, name, path);
    }
}
