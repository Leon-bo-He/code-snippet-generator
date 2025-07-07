package life.hebo.maker.generator.file;

import freemarker.template.TemplateException;
import life.hebo.maker.model.DataModel;

import java.io.File;
import java.io.IOException;

/**
 * @author BO HE
 */
public class FileGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("bobo");
        dataModel.setLoop(true);
        dataModel.setOutputMessage("Sum Output：");
        doGenerate(dataModel);
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

        StaticFileGenerator.copyFiles(sourcePath, targetPath);

        String sourceDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String targetDynamicFilePath = targetPath + File.separator + "acm-template/src/life/hebo/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(sourceDynamicFilePath, targetDynamicFilePath, templateConfig);
    }
}


