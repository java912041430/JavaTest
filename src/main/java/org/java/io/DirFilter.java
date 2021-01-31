package org.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

//文件过滤器
public class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    //返回true(显示) false(不显示)
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }

}
