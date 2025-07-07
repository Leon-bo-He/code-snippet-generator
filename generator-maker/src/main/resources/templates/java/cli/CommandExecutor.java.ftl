package ${basePackage}.cli;

import ${basePackage}.cli.command.ConfigCommand;
import ${basePackage}.cli.command.GenerateCommand;
import ${basePackage}.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "${name}",
                     mixinStandardHelpOptions = true,
                     description = "${description}")
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
        System.out.println("Please specify a command. Use --help for more information.");
    }

    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
