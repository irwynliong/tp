package insurebook.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import insurebook.address.commons.exceptions.DataLoadingException;
import insurebook.address.model.ReadOnlyAddressBook;
import insurebook.address.model.ReadOnlyUserPrefs;
import insurebook.address.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataLoadingException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyAddressBook> readAddressBook() throws DataLoadingException;

    @Override
    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

}
