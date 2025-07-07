package ${basePackage}.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

@Command(name = "list",
        mixinStandardHelpOptions = true,
        description = "List files in the specified directory.")
public class ListCommand implements Runnable {

    @Override
    public void run() {
        String sourcePath = "${fileConfig.sourceRootPath}";
        List<File> files = FileUtil.loopFiles(sourcePath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
