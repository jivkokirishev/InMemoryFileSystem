package inmemoryfilesystem.common;

public class Validator {
    public static void checkIfNull(Object obj, String name){
            if (obj == null){
                throw new NullPointerException(String.format("The '%s' object is null and thus can NOT be used!", name));
            }
    }

    public static void checkIfNullOrEmpty(String argument, String name){
            if (argument == null || argument.isEmpty()){
                throw new IllegalArgumentException(String.format("The '%s' argument is null or empty!", name));
            }
    }
}
