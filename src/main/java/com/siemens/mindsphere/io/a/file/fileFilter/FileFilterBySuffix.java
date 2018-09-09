package com.siemens.mindsphere.io.a.file.fileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @author Zhang Xiao
 * @date 9/9/2018 10:58
 */
public class FileFilterBySuffix implements FilenameFilter {

    private String suffix;

    public FileFilterBySuffix(String suffix){
        super();
        this.suffix = suffix;
    }


    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }


}
