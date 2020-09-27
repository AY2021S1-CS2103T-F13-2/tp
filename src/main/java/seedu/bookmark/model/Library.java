package seedu.bookmark.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.bookmark.model.book.Book;
import seedu.bookmark.model.book.UniqueBookList;

/**
 * Wraps all data at the bookmark level
 * Duplicates are not allowed (by .isSameBook comparison)
 */
public class Library implements ReadOnlyLibrary {

    private final UniqueBookList persons;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniqueBookList();
    }

    public Library() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public Library(ReadOnlyLibrary toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<Book> books) {
        this.persons.setBooks(books);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyLibrary newData) {
        requireNonNull(newData);

        setPersons(newData.getBookList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasPerson(Book book) {
        requireNonNull(book);
        return persons.contains(book);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addPerson(Book p) {
        persons.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setPerson(Book target, Book editedBook) {
        requireNonNull(editedBook);

        persons.setBook(target, editedBook);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(Book key) {
        persons.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return persons.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Book> getBookList() {
        return persons.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Library // instanceof handles nulls
                && persons.equals(((Library) other).persons));
    }

    @Override
    public int hashCode() {
        return persons.hashCode();
    }
}
