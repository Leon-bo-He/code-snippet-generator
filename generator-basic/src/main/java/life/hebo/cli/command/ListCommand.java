package life.hebo.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

/**
 * @author BO HE
 */

@Command(name = "list",
        mixinStandardHelpOptions = true,
        description = "List files in the specified directory.")
public class ListCommand implements Runnable {

    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String sourcePath = new File(parentFile, "demo-projects/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(sourcePath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}

