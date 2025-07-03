package life.hebo.cli.command;

import cn.hutool.core.bean.BeanUtil;
import life.hebo.generator.MainGenerator;
import life.hebo.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author BO HE
 */

@Command(name = "generate",
                     mixinStandardHelpOptions = true,
                     description = "Generate code based on the provided configuration.")
@Data
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "Need while loop? (true/false)", interactive = true, echo = true)
    private boolean loop;

    @Option(names = {"-a", "--author"}, arity = "0..1", description = "Author of the generated code", interactive = true, echo = true)
    private String author = "BB";

    @Option(names = {"-o", "--outputMessage"}, arity = "0..1", description = "Output message prefix", interactive = true, echo = true)
    private String outputMessage = "Sum: ";

    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("Config info: " + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}

