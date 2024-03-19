package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    private static class DisplayBuilder {
        private static final String FIELD_SEPARATOR = "; ";
        private static final String FIELD_NAME_VALUE_SEPARATOR = ": ";
        private final StringBuilder stringBuilder = new StringBuilder();

        DisplayBuilder(String objectName) {
            stringBuilder.append(objectName);
        }

        public DisplayBuilder add(String fieldName, Object fieldValue) {
            if (fieldValue == null) {
                return this;
            }
            stringBuilder.append(FIELD_SEPARATOR)
                    .append(fieldName)
                    .append(FIELD_NAME_VALUE_SEPARATOR)
                    .append(fieldValue);
            return this;
        }

        public DisplayBuilder add(Set<Tag> tags) {
            if (tags == null || tags.isEmpty()) {
                return this;
            }
            stringBuilder.append(FIELD_SEPARATOR)
                    .append("Tags")
                    .append(FIELD_NAME_VALUE_SEPARATOR);
            tags.forEach(tag -> stringBuilder.append(tag).append(", "));
            stringBuilder.setLength(stringBuilder.length() - 2); // Remove trailing comma and space
            return this;
        }

        @Override
        public String toString() {
            return stringBuilder.toString();
        }
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final DisplayBuilder builder = new DisplayBuilder(person.getName().fullName);
        builder.add("Phone", person.getPhone())
                .add("Email", person.getEmail())
                .add("Address", person.getAddress())
                .add(person.getTags());
        return builder.toString();
    }

}
