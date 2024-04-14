package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a policy associated with a person.
 * Guarantees: immutable; policyName is valid as declared in {@link #isValidPolicyName(String)}
 */
public class Policy {

    public static final String POLICY_NAME_MESSAGE_CONSTRAINTS = "Policy name should not be blank";
    public static final String POLICY_NUMBER_MESSAGE_CONSTRAINTS = "Policy number should not be blank";
    public static final String POLICY_TYPE_MESSAGE_CONSTRAINTS = "Policy type should only contain alphanumeric "
            + "characters and spaces, and it should not be blank";
    public static final String PREMIUM_TERM_MESSAGE_CONSTRAINTS = "Premium term has to be one of the following "
            + "options, and it should not be blank "
            + "\n [\"Single\", \"Monthly\", \"Quarterly\", \"Semi-annually\", \"Annually\"]";
    public static final String PREMIUM_MESSAGE_CONSTRAINTS = "Premium should only contain alphanumeric "
            + "characters and spaces, and it should not be blank";
    public static final String BENEFIT_MESSAGE_CONSTRAINTS = "Benefit should only contain alphanumeric "
            + "characters and spaces, and it should not be blank";


    public static final String POLICY_NUMBER_VALIDATION_REGEX = "[^\\s].*";
    public static final String POLICY_NAME_VALIDATION_REGEX = "[^\\s].*";
    public static final String ALPHANUMERIC_VALIDATION_REGEX = "^[a-zA-Z0-9 ]+$";
    public static final Set<String> ACCEPTED_PREMIUM_TERMS =
            new HashSet<>(Arrays.asList("SINGLE", "MONTHLY", "QUARTERLY", "SEMI-ANNUALLY", "ANNUALLY"));

    public final String policyName;
    public final String policyType;
    public final String policyNumber;
    public final String premiumTerm;
    public final String premium;
    public final String benefit;

    /**
     * Constructs a Policy object with the given parameters.
     *
     * @param policyName   The name of the policy.
     * @param policyType   The type of the policy.
     * @param policyNumber The policy number.
     * @param premiumTerm  The premium term.
     * @param premium      The premium amount.
     * @param benefit      The benefits associated with the policy.
     */
    public Policy(String policyName, String policyType, String policyNumber, String premiumTerm,
                  String premium, String benefit) {
        requireAllNonNull(policyName);

        this.policyName = policyName;
        this.policyType = policyType;
        this.policyNumber = policyNumber;
        this.premiumTerm = premiumTerm;
        this.premium = premium;
        this.benefit = benefit;
    }

    /**
     * Returns true if a given string is a valid policy name.
     *
     * @param field The policy name to validate.
     * @return True if the policy name is valid, false otherwise.
     */
    public static boolean isValidPolicyName(String field) {
        return field.matches(POLICY_NAME_VALIDATION_REGEX);
    }
    public static boolean isValidPolicyNumber(String field) {
        return field.matches(POLICY_NUMBER_VALIDATION_REGEX);
    }

    public static boolean isValidTypeOrPremiumOrBenefit(String field) {
        return field.matches(ALPHANUMERIC_VALIDATION_REGEX);
    }

    /**
     * Checks if a given string is a valid policy number.
     *
     * @param field The policy number to validate.
     * @return True if the policy number is valid, false otherwise.
     */
    public static boolean isValidPremiumTerm(String field) {
        return ACCEPTED_PREMIUM_TERMS.contains(field);
    }

    public String getName() {
        return this.policyName;
    }

    public String getType() {
        return this.policyType;
    }

    public String getId() {
        return this.policyNumber;
    }

    public String getTerm() {
        return this.premiumTerm;
    }

    public String getPremium() {
        return this.premium;
    }

    public String getBenefit() {
        return this.benefit;
    }

    @Override
    public String toString() {
        return "[Policy Name: "
                + policyName + ","
                + " Policy Type: "
                + policyType + ","
                + " Policy ID: "
                + policyNumber + ","
                + " Premium Term: "
                + premiumTerm + ","
                + " Premium: "
                + premium + ","
                + " Benefit: "
                + benefit + "]";
    }

}
