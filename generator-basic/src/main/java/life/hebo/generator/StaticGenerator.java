package life.hebo.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author BO HE
 */
public class StaticGenerator {

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String sourcePath = new File(parentFile, "demo-projects/acm-template").getAbsolutePath();
        String targetPath = projectPath;
        copyFiles(sourcePath, targetPath);
    }

    /**
     * Copies files from the source path to the target path.
     *
     * @param sourcePath the path to the source files
     * @param targetPath the path where files should be copied
     */
    public static void copyFiles(String sourcePath, String targetPath) {
        FileUtil.copy(sourcePath, targetPath, false);
    }
}
