package myapp.command;

import myapp.core.BingBongUi;
import myapp.core.Storage;
import myapp.task.TaskList;
import myapp.task.Task;

public class MarkCommand extends Command {

    int index;
    public MarkCommand(int i) {
        super();
        this.index = i;
    }

    @Override
    public void execute(TaskList tasks, BingBongUi ui, Storage storage)
            throws IndexOutOfBoundsException {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
        Task task = tasks.get(index);
        task.markAsDone();
        saveTasks(tasks, ui, storage);
        ui.showResponse("Nice! I've marked this task as done:\n" + task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
