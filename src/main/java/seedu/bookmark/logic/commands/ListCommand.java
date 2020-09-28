package seedu.bookmark.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.bookmark.model.Model.PREDICATE_SHOW_ALL_BOOKS;

import seedu.bookmark.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredBookList(PREDICATE_SHOW_ALL_BOOKS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
