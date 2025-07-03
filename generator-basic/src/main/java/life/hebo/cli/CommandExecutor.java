package life.hebo.cli;

import life.hebo.cli.command.ConfigCommand;
import life.hebo.cli.command.GenerateCommand;
import life.hebo.cli.command.ListCommand;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author BO HE
 */
@Command(name = "code generator",
                     mixinStandardHelpOptions = true,
                     description = "A command line interface for code generator.")
public class CommandExecutor implements Runnable{


    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }


    @Override
    public void run() {
        System.out.println("Please specify a command.");
    }

    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
