package com.travel.utils;

import java.io.File;

public class FileUtil {
	
	
    public static void main(String[] args) {
    	String src = "/Users/linwenfu/Desktop/11"; 
    	String desc = "/Users/linwenfu/Desktop/tt/22" ; 
    	FileUtil.renameTo(src, desc);
    	
    }
	    
    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
    
    /**
     * 检测文件(或者文件夹)file是否存在
     * @param file
     * @return
     */
    public static boolean checkExist(String file) {
    	return checkExist(new File(file));
    }
    
    /**
     * 检测文件(或者文件夹)file是否存在
     * @param file
     * @return
     */
    public static boolean checkExist(File file) {
    	return file.exists();
    }
    
    /**
     * 创建文件夹
     * @param file
     * @return
     */
    public static boolean createDir(String file) {
    	return createDir(new File(file));
    }
    
    /**
     * 创建文件夹
     * @param file
     * @return
     */
    public static boolean createDir(File file) {
    	return file.mkdirs();
    }
    
    /**
     * 文件重命名，将originalFile重命名为targetFile
     * @param originalFile
     * @param targetFile
     */
    public static void renameTo(String originalFile, String targetFile) {
    	File original = new File(originalFile);
    	File target = new File(targetFile);
    	original.renameTo(target);
    }
}
