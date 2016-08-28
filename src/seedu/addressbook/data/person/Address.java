package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {
	private class Block {
		public String value;
		public Block(String value) {
			this.value = value;
		}
	}
	private class Street {
		public String value;
		public Street(String value) {
			this.value = value;
		}
	}
	private class Unit {
		public String value;
		public Unit(String value) {
			this.value = value;
		}
	}
	private class PostalCode {
		public String value;
		public PostalCode(String value) {
			this.value = value;
		}
	}
	
    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    public static final int ADDRESS_BLOCK = 0;
    public static final int ADDRESS_STREET = 1;
    public static final int ADDRESS_UNIT = 2;
    public static final int ADDRESS_POSTAL_CODE = 3;

    // public final String value;
    /** [LO-ImplementClass] T3 Splitting address into several other classes */
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        // this.value = address;
        
        this.block = new Block(getBlock(address));
        this.street = new Street(getStreet(address));
        this.unit = new Unit(getUnit(address));
        this.postalCode = new PostalCode(getPostalCode(address));
    }
    public String getBlock(String address) {
    	String[] splittedString = address.split(",");
    	return splittedString[ADDRESS_BLOCK];
    }
    public String getStreet(String address) {
    	String[] splittedString = address.split(",");
    	return splittedString[ADDRESS_STREET];
    }
    public String getUnit(String address) {
    	String[] splittedString = address.split(",");
    	return splittedString[ADDRESS_UNIT];
    }
    public String getPostalCode(String address) {
    	String[] splittedString = address.split(",");
    	return splittedString[ADDRESS_POSTAL_CODE];
    }
    

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.value + "," + street.value + "," + unit.value + "," + postalCode.value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && toString().equals(((Address) other).toString()));
                // && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}