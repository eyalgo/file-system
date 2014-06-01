package org.eyalgo.filesystem.files.size;

import java.util.Collection;

import org.eyalgo.filesystem.files.MyFile;

public class CompressedSizeCalculator implements SizeCalculator {

    public CompressedSizeCalculator() {
    }

    @Override
    public int size(Collection<MyFile> children) {
	int sum = 0;
	for (MyFile file : children) {
	    sum += file.size();
	}
	return sum/2;
    }
}
