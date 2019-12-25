package model;

import java.util.ArrayList;
import java.util.List;

public class PathMain {

    public static void main(String[] args) {
        List<String> fileList = new ArrayList<>();
        fileList.add("constant");
        fileList.add("controller");
        fileList.add("dao");
        fileList.add("dto");
        fileList.add("entity");
        fileList.add("mapper");
        fileList.add("service");
        fileList.add("service/impl");
        newFiles(basePath,modelName,fileList);
    }

    private static String basePath = "D:/code/";

    public static String modelName = "xxxxxxxxx";


    public static void newFiles(String basePath, String modelName, List<String> fileList){
        List<String> filePathList = new ArrayList<>();
        basePath = basePath + modelName + "/";
        for (String fileName : fileList) {
            fileName = basePath + fileName;
            System.out.println(fileName);
        }
    }

}
