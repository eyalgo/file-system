package org.eyalgo.filesystem.files.size;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eyalgo.filesystem.files.MyFile;
import org.junit.Test;

import com.google.common.collect.Lists;

public class SimpleSizeCalculatorTest {
    @Test
    public void shouldSumChildrenSize() throws Exception {
	MyFile file1 = mock(MyFile.class, "file 1");
	MyFile file2 = mock(MyFile.class, "file 2");
	MyFile file3 = mock(MyFile.class, "file 3");

	when(file1.size()).thenReturn(12);
	when(file2.size()).thenReturn(27);
	when(file3.size()).thenReturn(57);

	SizeCalculator calculator = new SimpleSizeCalculator();
	int size = calculator.size(Lists.newArrayList(file1, file2, file3));
	assertThat(size, equalTo(12 + 27 + 57));
    }
}
