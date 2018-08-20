package inmemoryfilesystem.commands.commandalgorithms;

import inmemoryfilesystem.commands.Command;
import inmemoryfilesystem.commands.contracts.CommandExecutable;
import inmemoryfilesystem.common.Validator;
import inmemoryfilesystem.components.File;
import inmemoryfilesystem.logic.DirectoryState;

import java.util.Scanner;
import java.util.stream.Collectors;

public class EditViewContent implements CommandExecutable {

    private static final String EOFSymbol = "##EOF##";
    private DirectoryState directoryState;

    @Override
    public void execute(DirectoryState directoryState, Command command) {
        Validator.checkIfNull(directoryState, directoryState.getClass().getName());
        Validator.checkIfNull(command, command.getClass().getName());

        this.directoryState = directoryState;

        String firstParam = "";
        try {
            firstParam = command.getParameters().get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("This operation requires parameters to work. Please read how to use it in help section.");
            return;
        }

        if(firstParam.equals(">") || firstParam.equals(">>")){
            command.getParameters().remove(0);
            CreateFile crFile = new CreateFile();
            crFile.execute(directoryState, command);

            File file;
            try {

                file = this.searchFile(command.getParameters().get(0));
            } catch (IndexOutOfBoundsException e){
                System.out.println(String.format("File %s does NOT exist!", command.getParameters().get(0)));
                return;
            }

            StringBuilder content = new StringBuilder();
            Scanner input = new Scanner(System.in);
            String line;
            do{
                line = input.nextLine();
                if (line.contains(EOFSymbol)){
                    String[] endOfFile = line.split(EOFSymbol);
                    if (endOfFile.length > 0) {
                        content.append(endOfFile[0]);
                    }
                    break;
                }else { content.append(line).append(System.lineSeparator()); }
            }while(true);

            switch (firstParam){
                case ">":{
                    file.setContent(content.toString());
                }break;
                case ">>":{
                    String oldText = file.getContent();
                    file.setContent(oldText + content.toString());
                }break;
            }
        }else {
            try {

                File file = this.searchFile(firstParam);
                System.out.println(file.getContent());
            } catch (IndexOutOfBoundsException e){
                System.out.println(String.format("File %s does NOT exist!", firstParam));
                return;
            }

        }
    }

    @Override
    public String description() {
        return "Displays a content of or edits a file and if does NOT exist creates it. " +
                "You have to write '>' parameter to delete the content and rewrite it. " +
                "'>>' - to add new content below the existing one and no parameters except the file name if you want to display the content.";
    }

    private File searchFile(String fileName) throws IndexOutOfBoundsException{
        String name = fileName;
        String ext = "";
        if(fileName.contains(".")){
            String[] nameAndExt = fileName.split(".");
            name = nameAndExt[0];
            ext = nameAndExt[1];
        }

        String finalName = name;
        String finalExt = ext;
        File searchedFile = this.directoryState.getCurrentDirectory()
                .listAllFiles()
                .stream()
                .filter(t -> (t.getName().equals(finalName) && t.getExtention().equals(finalExt)))
                .collect(Collectors.toList())
                .get(0);

        return searchedFile;
    }
}
