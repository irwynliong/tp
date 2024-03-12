package insureBook.address.logic.commands;

import static insureBook.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import insureBook.address.model.Model;
import insureBook.address.model.ModelManager;
import org.junit.jupiter.api.Test;

public class HelpCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(HelpCommand.SHOWING_HELP_MESSAGE, true, false);
        CommandTestUtil.assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }
}
