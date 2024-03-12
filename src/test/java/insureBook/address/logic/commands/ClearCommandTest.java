package insureBook.address.logic.commands;

import static insureBook.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import insureBook.address.model.AddressBook;
import insureBook.address.model.Model;
import insureBook.address.model.ModelManager;
import insureBook.address.model.UserPrefs;
import insureBook.address.testutil.TypicalPersons;
import org.junit.jupiter.api.Test;

public class ClearCommandTest {

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        CommandTestUtil.assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(TypicalPersons.getTypicalAddressBook(), new UserPrefs());
        Model expectedModel = new ModelManager(TypicalPersons.getTypicalAddressBook(), new UserPrefs());
        expectedModel.setAddressBook(new AddressBook());

        CommandTestUtil.assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
