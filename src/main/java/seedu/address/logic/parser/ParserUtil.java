package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Meeting;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Policy;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String meeting} into an {@code Meeting}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code meeting} is invalid.
     */
    public static Meeting parseMeeting(String meeting) throws ParseException {
        requireNonNull(meeting);
        String trimmedMeeting = meeting.trim();
        if (!Meeting.isValidMeeting(trimmedMeeting)) {
            throw new ParseException(Meeting.MESSAGE_CONSTRAINTS);
        }
        if (!Meeting.isFutureMeeting(trimmedMeeting)) {
            throw new ParseException(Meeting.FUTURE_MEETING_MESSAGE_CONSTRAINTS);
        }
        return new Meeting(trimmedMeeting);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses a {@code String policyName} into a {String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code policyName} is invalid.
     */
    public static String parsePolicyName(String policyName) throws ParseException {
        requireNonNull(policyName);
        String trimmedPolicyName = policyName.trim();
        if (!Policy.isValidPolicyName(trimmedPolicyName)) {
            throw new ParseException(Policy.POLICY_NAME_MESSAGE_CONSTRAINTS);
        }
        return policyName;
    }

    /**
     * Parses a {@code String policyType} into a {String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code policyType} is invalid.
     */
    public static String parsePolicyType(String policyType) throws ParseException {
        requireNonNull(policyType);
        String trimmedPolicyType = policyType.trim();
        if (!Policy.isValidTypeOrPremiumOrBenefit(trimmedPolicyType)) {
            throw new ParseException(Policy.POLICY_TYPE_MESSAGE_CONSTRAINTS);
        }
        return policyType;
    }

    /**
     * Parses a {@code String policyNumber} into a {String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code policyNumber} is invalid.
     */
    public static String parsePolicyNumber(String policyNumber) throws ParseException {
        requireNonNull(policyNumber);
        String trimmedPolicyNumber = policyNumber.trim();
        if (!Policy.isValidPolicyNumber(trimmedPolicyNumber)) {
            throw new ParseException(Policy.POLICY_NUMBER_MESSAGE_CONSTRAINTS);
        }
        return policyNumber;
    }

    /**
     * Parses a {@code String premiumTerm} into a {String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code premiumTerm} is invalid.
     */
    public static String parsePremiumTerm(String premiumTerm) throws ParseException {
        requireNonNull(premiumTerm);
        String trimmedPremiumTerm = premiumTerm.trim();
        if (!Policy.isValidPremiumTerm(trimmedPremiumTerm)) {
            throw new ParseException(Policy.PREMIUM_TERM_MESSAGE_CONSTRAINTS);
        }
        return premiumTerm;
    }

    /**
     * Parses a {@code String premium} into a {String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code premium} is invalid.
     */
    public static String parsePremium(String premium) throws ParseException {
        requireNonNull(premium);
        String trimmedPremium = premium.trim();
        if (!Policy.isValidTypeOrPremiumOrBenefit(trimmedPremium)) {
            throw new ParseException(Policy.PREMIUM_MESSAGE_CONSTRAINTS);
        }
        return premium;
    }

    /**
     * Parses a {@code String benefit} into a {String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code benefit} is invalid.
     */
    public static String parseBenefit(String benefit) throws ParseException {
        requireNonNull(benefit);
        String trimmedBenefit = benefit.trim();
        if (!Policy.isValidTypeOrPremiumOrBenefit(trimmedBenefit)) {
            throw new ParseException(Policy.BENEFIT_MESSAGE_CONSTRAINTS);
        }
        return benefit;
    }

}
