package dudu.command;

import dudu.exception.DuduException;
import dudu.task.TaskList;
import dudu.util.Storage;

public abstract class Command {
    private String input;
    public Command(String input) {
        this.input = input;
    }

    public abstract Command execute(TaskList list, Storage storage) throws DuduException;


}
