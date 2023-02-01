package dudu.command;

import dudu.exception.DuduException;
import dudu.exception.EmptyDescriptionException;
import dudu.task.Event;
import dudu.task.TaskList;
import dudu.util.Storage;

/**
 * Command class for event task
 */
public class EventCommand extends Command {
    private String input;

    /**
     * Constructor for event command.
     * @param input name, from & to date of the event task.
     */
    public EventCommand(String input) {
        super(input);
        this.input = input;
    }

    @Override
    public String execute(TaskList list, Storage storage) throws DuduException {
        if (!input.contains(" /from ")) {
            throw new EmptyDescriptionException("event", "date" , "Missing date");
        }
        String[] inputStr = input.split(" /from ");
        String[] dateStr = inputStr[1].split(" /to ");
        Event event = new Event(inputStr[0], dateStr[0], dateStr[1]);
        storage.saveTask(list.addTask(event));
        return "Got it. I've added this task:\n  " + event + "\n" + list.getTotalTask();
    }
}
