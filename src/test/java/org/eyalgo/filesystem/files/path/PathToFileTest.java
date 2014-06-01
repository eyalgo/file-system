package org.eyalgo.filesystem.files.path;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Map;

import org.eyalgo.filesystem.files.MyFile;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

public class PathToFileTest {
    private PathToFile pathToFile;

    @Before
    public void setup() {
	pathToFile = new PathToFile();
    }

    @Test
    public void whenSinglePathAndNameExists_thenReturnTheFile() throws Exception {
	String[] path = { "c" };
	Map<String, MyFile> children = Maps.newHashMap();
	MyFile aFile = mock(MyFile.class);
	children.put("c", aFile);

	MyFile foundFile = pathToFile.get(children, path);
	assertThat(foundFile, sameInstance(aFile));
    }
}
