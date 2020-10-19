package seedu.bookmark.logic.parser;

import static seedu.bookmark.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.bookmark.logic.parser.CliSyntax.PREFIX_GENRE;
import static seedu.bookmark.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.bookmark.logic.parser.CliSyntax.PREFIX_READING_PROGRESS;

import java.util.Comparator;
import seedu.bookmark.logic.commands.SortCommand;
import seedu.bookmark.logic.parser.exceptions.ParseException;
import seedu.bookmark.model.book.Book;
import seedu.bookmark.model.book.comparators.BookGenreComparator;
import seedu.bookmark.model.book.comparators.BookNameComparator;
import seedu.bookmark.model.book.comparators.BookReadingProgressComparator;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser implements Parser<SortCommand> {

    private Prefix inputPrefix;

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns a SortCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortCommand parse(String args) throws ParseException {
        Comparator<Book> comparator;
        int prefixCount = 0;

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args,
                        PREFIX_NAME, PREFIX_GENRE, PREFIX_READING_PROGRESS);

        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            prefixCount += 1;
            inputPrefix = PREFIX_NAME;
        }
        if (argMultimap.getValue(PREFIX_GENRE).isPresent()) {
            prefixCount += 1;
            inputPrefix = PREFIX_GENRE;
        }
        if (argMultimap.getValue(PREFIX_READING_PROGRESS).isPresent()) {
            prefixCount += 1;
            inputPrefix = PREFIX_READING_PROGRESS;
        }
        if (prefixCount != 1) { //if more than/ less than 1 input prefix, we throw an error.
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        String trimmedArgs = argMultimap.getValue(inputPrefix).get().trim();
        if (!trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        comparator = comparatorGenerator(inputPrefix);

        return new SortCommand(comparator);
    }

    /**
     * Returns a comparator based on the input prefix
     * @return Comparator based on input prefix
     */
    public Comparator<Book> comparatorGenerator(Prefix inputPrefix) {
        Comparator<Book> comparator = null;
        if (inputPrefix == PREFIX_NAME) {
            comparator = new BookNameComparator();
        } else if (inputPrefix == PREFIX_GENRE) {
            comparator = new BookGenreComparator();
        } else if (inputPrefix == PREFIX_READING_PROGRESS) {
            comparator = new BookReadingProgressComparator();
        }
        return comparator;
    }
}
