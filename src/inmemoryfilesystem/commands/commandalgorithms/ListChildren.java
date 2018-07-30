package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.components.Directory;
import inmemoryfilesystem.components.File;
import inmemoryfilesystem.logic.DirectoryState;

import java.util.stream.Stream;

public class ListChildren implements CommandExecutable {
    @Override
    public void Execute(DirectoryState directoryState, Command command) {
        for (Directory dir : directoryState.getCurrentDirectory().listAllDirectories()) {
            System.out.print(dir.getName() + "  ");
        }

        for (File file : directoryState.getCurrentDirectory().listAllFiles()) {
            Stream.Builder<String> builder = Stream.builder();

            Stream<String> fullName = builder.add(file.getName())
                    .add(".")
                    .add(file.getExtention())
                    .add("  ").build();

            fullName.forEach(System.out::println);
        }
    }
}
