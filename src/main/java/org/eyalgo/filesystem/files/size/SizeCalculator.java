package org.eyalgo.filesystem.files.size;

import java.util.Collection;

import org.eyalgo.filesystem.files.MyFile;

public interface SizeCalculator {
    int size(Collection<MyFile> children);
}
