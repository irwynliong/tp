package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Client;

/**
 * A utility class containing a list of {@code Client} objects to be used in tests.
 */
public class TypicalClients {
    public static final Client SOO = new ClientBuilder().withName("Soo Wee")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("soowee@example.com")
            .withPhone("94351253")
            .withMeeting("2024-01-02")
            .withTags("friends").build();
    public static final Client XAVIER = new ClientBuilder().withName("Xavier Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withMeeting("2024-12-12")
            .withTags("owesMoney", "friends").build();
    public static final Client LUTFI = new ClientBuilder().withName("Lutfi Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street")
            .withMeeting("2024-03-11").build();
    public static final Client DANIEL = new ClientBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street")
            .withMeeting("2024-04-13").withTags("friends").build();
    public static final Client EVE = new ClientBuilder().withName("Eve Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").withMeeting("2024-05-15").build();
    public static final Client FABIAN = new ClientBuilder().withName("Fabian Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").withMeeting("2024-06-20").build();
    public static final Client GEORGE = new ClientBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").withMeeting("2024-12-01").build();

    // Manually added
    public static final Client HOON = new ClientBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Client IDA = new ClientBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Client's details found in {@code CommandTestUtil}
    public static final Client AMY = new ClientBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Client BOB = new ClientBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalClients() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Client client : getTypicalClient()) {
            ab.addClient(client);
        }
        return ab;
    }

    public static List<Client> getTypicalClient() {
        return new ArrayList<>(Arrays.asList(XAVIER, LUTFI, DANIEL, EVE, FABIAN, GEORGE));
    }
}
