package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MEETING_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.model.person.PersonTest.VALID_ADDRESS;
import static seedu.address.model.person.PersonTest.VALID_EMAIL;
import static seedu.address.model.person.PersonTest.VALID_NAME;
import static seedu.address.model.person.PersonTest.VALID_PHONE;
import static seedu.address.model.person.PersonTest.VALID_TAGS;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalClients.LUTFI;
import static seedu.address.testutil.TypicalClients.XAVIER;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ClientBuilder;

public class ClientTest {
    public static final Meeting VALID_MEETING = new Meeting(VALID_MEETING_AMY);

    @Test
    public void constructor() {
        assertThrows(NullPointerException.class, () -> new Client(null, VALID_PHONE, VALID_EMAIL,
                VALID_ADDRESS, VALID_MEETING, VALID_TAGS));

        assertDoesNotThrow(() -> new Client(VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS,
                VALID_MEETING, VALID_TAGS));

        assertDoesNotThrow(() -> new Client(VALID_NAME, VALID_PHONE, null, VALID_ADDRESS,
                VALID_MEETING, VALID_TAGS));

        assertDoesNotThrow(() -> new Client(VALID_NAME, VALID_PHONE, VALID_EMAIL, null,
                VALID_MEETING, VALID_TAGS));

        assertDoesNotThrow(() -> new Client(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, null,
                VALID_TAGS));

        assertThrows(NullPointerException.class, () -> new Client(VALID_NAME, VALID_PHONE, VALID_EMAIL,
                VALID_ADDRESS, VALID_MEETING, null));
    }

    @Test
    public void equals() {
        // same value = true
        Client xavierCopy = new ClientBuilder(XAVIER).build();
        assertTrue(XAVIER.equals(xavierCopy));

        //same object = true
        assertTrue(XAVIER.equals(XAVIER));

        //null = false
        assertFalse(XAVIER.equals(null));

        //different client = false
        assertFalse(XAVIER.equals(LUTFI));

        //different name = false
        Client editedXavier = new ClientBuilder(XAVIER).withName(VALID_NAME_BOB).build();
        assertFalse(XAVIER.equals(editedXavier));

        //different phone = false
        editedXavier = new ClientBuilder(XAVIER).withPhone(VALID_PHONE_BOB).build();
        assertFalse(XAVIER.equals(editedXavier));

        //different email = false
        editedXavier = new ClientBuilder(XAVIER).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(XAVIER.equals(editedXavier));

        //different address = false
        editedXavier = new ClientBuilder(XAVIER).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(XAVIER.equals(editedXavier));

        //different meeting = false
        editedXavier = new ClientBuilder(XAVIER).withMeeting(VALID_MEETING_AMY).build();
        assertFalse(XAVIER.equals(editedXavier));

        //different tags = false
        editedXavier = new ClientBuilder(XAVIER).withTags(VALID_TAG_FRIEND).build();
        assertFalse(XAVIER.equals(editedXavier));

        //no email = false
        editedXavier = new ClientBuilder(XAVIER).withoutEmail().build();
        assertFalse(XAVIER.equals(editedXavier));

        //no address = false
        editedXavier = new ClientBuilder(XAVIER).withoutAddress().build();
        assertFalse(XAVIER.equals(editedXavier));
        //no meeting = false
        editedXavier = new ClientBuilder(XAVIER).withoutMeeting().build();
        assertFalse(XAVIER.equals(editedXavier));
    }
}
