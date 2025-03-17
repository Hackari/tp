package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's website in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidWebsite(String)}.
 */
public class Website {

    // Error message for invalid website format
    public static final String MESSAGE_CONSTRAINTS =
            "Websites start with 'http://' or 'https://', followed by a valid domain name";

    // Regex for validating website format
    public static final String VALIDATION_REGEX = "^(https?://)?([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}(/[\\w-]*)*$";

    // The website URL value
    public final String value;

    /**
     * Constructs a {@code Website}.
     *
     * @param website A valid website.
     * @throws NullPointerException     if the website is null.
     * @throws IllegalArgumentException if the website is invalid.
     */
    public Website(String website) {
        requireNonNull(website, "Website cannot be null");
        checkArgument(isValidWebsite(website), MESSAGE_CONSTRAINTS);
        value = website;
    }

    /**
     * Returns true if a given string is a valid website.
     */
    public static boolean isValidWebsite(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        // Return true if the objects are the same instance
        if (other == this) {
            return true;
        }

        // Check if the other object is an instance of Website
        if (!(other instanceof Website)) {
            return false;
        }

        // Compare values for equality
        Website otherWebsite = (Website) other;
        return value.equals(otherWebsite.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
