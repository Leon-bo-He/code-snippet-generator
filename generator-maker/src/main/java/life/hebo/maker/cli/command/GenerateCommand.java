package life.hebo.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import life.hebo.maker.generator.file.FileGenerator;
import life.hebo.maker.model.DataModel;
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
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        System.out.println("Config info: " + dataModel);
        FileGenerator.doGenerate(dataModel);
        return 0;
    }
}

