package life.hebo.maker.generator.file;


import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author BO HE
 */
public class DynamicFileGenerator {

    /**
     * Generates a file from a FreeMarker template.
     *
     * @param sourcePath the path to the FreeMarker template file
     * @param targetPath the path where the generated file will be saved
     * @param templateConfig the configuration object for the template, which contains the data to be processed
     * @throws IOException if there is an error reading or writing files
     * @throws TemplateException if there is an error processing the template
     */
    public static void doGenerate(String sourcePath, String targetPath, Object templateConfig) throws IOException, TemplateException {
        // Create a FreeMarker configuration instance, specifying the version
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // Set the directory where the template files are located
        File templateDir = new File(sourcePath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // Set the default encoding for the template files
        configuration.setDefaultEncoding("utf-8");

        // Load the template file
        String templateFileName = new File(sourcePath).getName();
        Template template = configuration.getTemplate(templateFileName);

        // Ensure the target directory exists
        if (!FileUtil.exist(targetPath)) {
            FileUtil.touch(targetPath);
        }

        Writer out = new FileWriter(targetPath);
        template.process(templateConfig, out);

        out.close();
    }

}
