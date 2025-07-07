package life.hebo.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * @author BO HE
 */
public class StaticFileGenerator {

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
