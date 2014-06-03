package org.eyalgo.filesystem.files;

import static org.eyalgo.filesystem.files.MyFile.PATH_DELIMITER;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.eyalgo.filesystem.exceptions.IllegalFileSystemOperationException;
import org.junit.Before;
import org.junit.Test;

public class FileTypeTest {
    private MyFileSystem fileSystem;

    @Before
    public void setup() {
	fileSystem = new MyFileSystem();
    }

    @Test
    public void driveCreatedWithFileSystemAsParent() {
	String name = "c";
	MyFile driveFile = FileType.Drive.create(name, fileSystem);
	assertThat(driveFile.type(), is(FileType.Drive));
	assertThat(driveFile.name(), is(name));
	assertThat(driveFile.path(), is(PATH_DELIMITER + name + PATH_DELIMITER));
    }

    @Test
    public void folderCreation() {
	String name = "the-folder";
	MyFile driveFile = FileType.Drive.create("c", fileSystem);
	Folder folder = (Folder) FileType.Folder.create(name, (MyFileContainer) driveFile);
	assertThat(folder.type(), is(FileType.Folder));
	assertThat(folder.name(), is(name));
	assertThat(folder.path(), is(PATH_DELIMITER + "c" + PATH_DELIMITER + name + PATH_DELIMITER));
    }
    
    @Test(expected=IllegalFileSystemOperationException.class)
    public void whenAddingDriveNotToFileSystem_thenGetIllegalArgumentException() {
	String name = "the-folder";
	MyFile driveFile = FileType.Drive.create("c", fileSystem);
	Folder folder = (Folder) FileType.Folder.create(name, (MyFileContainer) driveFile);
	FileType.Drive.create("drive in folder should not be created", folder);
    }
}
