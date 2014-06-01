package org.eyalgo.filesystem.files;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyFileContainerTest {
    @Test
    public void afterAddingAFile_itShouldExistsInDrive() throws Exception {
	MyFileContainer drive = new Drive("c");
	MyFile folder = new Folder("folder", drive);
	drive.add(folder);
	String[] path = {"folder"};
	assertTrue("folder is not under drive c", drive.exists(path));
    }
}
