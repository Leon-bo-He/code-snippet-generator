package life.hebo.cli.command;

import cn.hutool.core.util.ReflectUtil;
import life.hebo.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @author BO HE
 */

@Command(name = "config",
         mixinStandardHelpOptions = true,
         description = "Check configuration parameters.")
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Check configuration parameters");

        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);

        for (Field field : fields) {
            System.out.println("field name：" + field.getName());
            System.out.println("field type：" + field.getType());
            System.out.println("---");
        }
    }
}
