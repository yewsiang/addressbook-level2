package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import seedu.addressbook.commands.CommandResult;

public class Formatter {
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    public static String formatPromptUserCommand() {
    	return LINE_PREFIX + "Enter command: ";
    }
    public static String formatEchoUserCommand(String fullInputLine) {
    	return LINE_PREFIX + "[Command entered:" + fullInputLine + "]\n";
    }
    
    public static String formatWelcomeMessage(String version, String storageFilePath) {
    	String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    	return concatMessage(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }
    
    public static String formatGoodbyeMessage() {
    	return concatMessage(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }
    
    public static String formatInitFailedMessage() {
    	return concatMessage(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }
    
    public static String formatResultToUser(CommandResult result) {
    	return concatMessage(result.getFeedback(), DIVIDER);
    }
    
    public static String formatShowToUserAsIndexedList(List<String> list) {
    	return concatMessage(getIndexedListForViewing(list));
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
    public static String concatMessage(String... message) {
    	String concatenatedMessage = "";
    	for (String m : message) {
    		concatenatedMessage += (LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX) + "\n");
    	}
    	return concatenatedMessage;
    }   
}