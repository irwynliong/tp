package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalClients.XAVIER;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.Client;
import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.ClientNotFoundException;
import seedu.address.model.person.exceptions.DuplicateClientException;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.testutil.ClientBuilder;
import seedu.address.testutil.PersonBuilder;

public class AddressBookTest {

    private final AddressBook addressBook = new AddressBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), addressBook.getPersonList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        AddressBook newData = getTypicalAddressBook();
        addressBook.resetData(newData);
        assertEquals(newData, addressBook);
    }

    //Person tests
    @Test
    public void resetData_withDuplicatePersons_throwsDuplicatePersonException() {
        // Two persons with the same identity fields
        Person editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Person> newPersons = Arrays.asList(ALICE, editedAlice);
        AddressBookStub newData = new AddressBookStub(newPersons, new ArrayList<>());

        assertThrows(DuplicatePersonException.class, () -> addressBook.resetData(newData));
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasPerson(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(addressBook.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        addressBook.addPerson(ALICE);
        assertTrue(addressBook.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addPerson(ALICE);
        Person editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(addressBook.hasPerson(editedAlice));
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getPersonList().remove(0));
    }

    //Client tests
    @Test
    public void resetData_withDuplicateClients_throwsDuplicateClientException() {
        Client editedXavier = new ClientBuilder(XAVIER).withAddress(VALID_ADDRESS_BOB)
                .build();
        List<Client> newClients = Arrays.asList(XAVIER, editedXavier);
        AddressBookStub newData = new AddressBookStub(new ArrayList<>(), newClients);

        assertThrows(DuplicateClientException.class, () -> addressBook.resetData(newData));
    }

    @Test
    public void hasClient_nullClient_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasClient(null));
    }

    @Test
    public void hasClient_clientNotInAddressBook_returnsFalse() {
        assertFalse(addressBook.hasClient(XAVIER));
    }

    @Test
    public void hasClient_clientInAddressBook_returnsTrue() {
        addressBook.addClient(XAVIER);
        assertTrue(addressBook.hasClient(XAVIER));
    }

    @Test
    public void hasClient_clientWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addClient(XAVIER);
        Client editedXavier = new ClientBuilder(XAVIER).withAddress(VALID_ADDRESS_BOB)
                .build();
        assertTrue(addressBook.hasClient(editedXavier));
    }

    @Test
    public void setClient_nullTargetClient_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.setClient(null, XAVIER));
    }

    @Test
    public void setClient_nullEditedClient_throwsNullPointerException() {
        addressBook.addClient(XAVIER);
        assertThrows(NullPointerException.class, () -> addressBook.setClient(XAVIER, null));
    }

    @Test
    public void setClient_targetClientNotInList_throwsClientNotFoundException() {
        assertThrows(ClientNotFoundException.class, () -> addressBook.setClient(XAVIER, XAVIER));
    }

    @Test
    public void setClient_editedClientHasSameIdentity_success() {
        addressBook.addClient(XAVIER);
        Client editedXavier = new ClientBuilder(XAVIER).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        addressBook.setClient(XAVIER, editedXavier);
        AddressBook expectedAddressBook = new AddressBook();
        expectedAddressBook.addClient(editedXavier);
        assertEquals(expectedAddressBook, addressBook);
    }

    @Test
    public void removeClient_nullClient_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.removeClient(null));
    }

    @Test
    public void removeClient_clientExists_success() {
        addressBook.addClient(XAVIER);
        addressBook.removeClient(XAVIER);
        AddressBook expectedAddressBook = new AddressBook();
        assertEquals(expectedAddressBook, addressBook);
    }

    @Test
    public void getClientList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getClientList().remove(0));
    }


    /**
     * A stub ReadOnlyAddressBook whose persons list can violate interface constraints.
     */
    private static class AddressBookStub implements ReadOnlyAddressBook {
        private final ObservableList<Person> persons = FXCollections.observableArrayList();
        private final ObservableList<Client> clients = FXCollections.observableArrayList();

        AddressBookStub(Collection<Person> persons, Collection<Client> clients) {
            this.persons.setAll(persons);
            this.clients.setAll(clients);
        }

        @Override
        public ObservableList<Person> getPersonList() {
            return persons;
        }

        @Override
        public ObservableList<Client> getClientList() {
            return clients;
        }
    }

}
