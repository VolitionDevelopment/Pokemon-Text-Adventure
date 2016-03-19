package me.demerzel.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by Jackson on 3/18/16.
 */
public class CommandManager {
    private HashMap<String, Command> commandHashMap;

    public CommandManager(){
        commandHashMap = new HashMap<>();


    }

    public Command getCommand(String cmd){
        return commandHashMap.get(cmd);
    }

    public ArrayList<String> getAliases(Class<? extends Command> get){
        return commandHashMap.entrySet().stream().filter(command -> command.getValue().getClass().equals(get)).map(HashMap.Entry::getKey).collect(Collectors.toCollection(ArrayList::new));
    }

    public Command aliasOf(String string){
        for(HashMap.Entry<String, Command> cmds : commandHashMap.entrySet()){
            if(string.equalsIgnoreCase(cmds.getKey())){
                return cmds.getValue();
            }
        }

        return null;
    }

    public HashMap<String, Command> getCommandHashMap(){ return commandHashMap;}

    public ArrayList<Command> getCommands(){
        return commandHashMap.entrySet().stream().map(HashMap.Entry::getValue).collect(Collectors.toCollection(ArrayList::new));
    }

    public void add(String in, Command command){
        commandHashMap.put(in, command);
    }
}
