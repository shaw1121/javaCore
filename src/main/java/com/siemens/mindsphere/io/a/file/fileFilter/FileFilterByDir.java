package com.siemens.mindsphere.io.a.file.fileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @author Zhang Xiao
 * @date 9/9/2018 11:20
 */
public class FileFilterByDir implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}
