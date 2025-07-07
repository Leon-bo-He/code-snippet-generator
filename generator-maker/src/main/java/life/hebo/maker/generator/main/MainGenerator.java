package life.hebo.maker.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import freemarker.template.TemplateException;
import life.hebo.maker.generator.file.DynamicFileGenerator;
import life.hebo.maker.meta.Meta;
import life.hebo.maker.meta.MetaManager;

import java.io.File;
import java.io.IOException;

/**
 * @author BO HE
 */
public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        Meta meta = MetaManager.getMetaObject();
        System.out.println(meta);

        // target root path
        String projectPath = System.getProperty("user.dir");
        String targetPath = projectPath + File.separator + meta.getFileConfig().getTargetRootPath() + File.separator + meta.getName();
        if (!FileUtil.exist(targetPath)) {
            FileUtil.mkdir(targetPath);
        }

        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();

        String targetBasePackage = meta.getBasePackage();
        String targetBasePackagePath = StrUtil.join("/", StrUtil.split(targetBasePackage, "."));
        String targetBaseJavaPackagePath = targetPath + File.separator + "src/main/java/" + targetBasePackagePath;

        String sourceFilePath;
        String targetFilePath;

        sourceFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
        targetFilePath = targetBaseJavaPackagePath + "/model/DataModel.java";
        DynamicFileGenerator.doGenerate(sourceFilePath , targetFilePath, meta);


        // cli.command.ConfigCommand
        sourceFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
        targetFilePath = targetBaseJavaPackagePath + "/cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerate(sourceFilePath , targetFilePath, meta);

        // cli.command.GenerateCommand
        sourceFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
        targetFilePath = targetBaseJavaPackagePath + "/cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerate(sourceFilePath , targetFilePath, meta);

        // cli.command.ListCommand
        sourceFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
        targetFilePath = targetBaseJavaPackagePath + "/cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerate(sourceFilePath , targetFilePath, meta);

        // cli.CommandExecutor
        sourceFilePath = inputResourcePath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
        targetFilePath = targetBaseJavaPackagePath + "/cli/CommandExecutor.java";
        DynamicFileGenerator.doGenerate(sourceFilePath , targetFilePath, meta);

        // Main
        sourceFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        targetFilePath = targetBaseJavaPackagePath + "/Main.java";
        DynamicFileGenerator.doGenerate(sourceFilePath , targetFilePath, meta);
    }
}
