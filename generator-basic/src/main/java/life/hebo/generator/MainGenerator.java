package life.hebo.generator;

import freemarker.template.TemplateException;
import life.hebo.model.MainTemplateConfig;

import java.io.File;
import java.io.IOException;

/**
 * @author BO HE
 */
public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("bobo");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputMessage("Sum Output：");
        doGenerate(mainTemplateConfig);
    }


    /**
     * Generates the ACM template files.
     *
     * @param templateConfig the configuration object for the template, which contains the data to be processed
     * @throws TemplateException if there is an error processing the template
     * @throws IOException if there is an error reading or writing files
     */
    public static void doGenerate(Object templateConfig) throws TemplateException, IOException {

        String projectPath = System.getProperty("user.dir");

        File parentFile = new File(projectPath).getParentFile();
        String sourcePath = new File(parentFile, "demo-projects/acm-template").getAbsolutePath();
        String targetPath = projectPath;

        StaticGenerator.copyFiles(sourcePath, targetPath);

        String sourceDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String targetDynamicFilePath = targetPath + File.separator + "acm-template/src/life/hebo/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(sourceDynamicFilePath, targetDynamicFilePath, templateConfig);
    }
}


