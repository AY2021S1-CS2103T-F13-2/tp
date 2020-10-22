package seedu.bookmark.testutil;

import javafx.scene.LightBase;
import seedu.bookmark.model.Library;
import seedu.bookmark.model.WordBank;
import seedu.bookmark.model.book.Book;
import seedu.bookmark.model.wordstore.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypicalWords {
    public static final String HARRY = "harry";
    public static final String POTTER = "potter";
    public static final String AND = "and";
    public static final String CHAMBER = "chamber";
    public static final String SECRETS = "secrets";


    //correctly spelt
    public static final Word CORRECT_HARRY = new Word("harry");
    public static final Word CORRECT_POTTER = new Word("potter");
    public static final Word CORRECT_AND = new Word("and");
    public static final Word CORRECT_CHAMBER = new Word("chamber");
    public static final Word CORRECT_SECRETS = new Word("secrets");

    //incorrectly spelt
    public static final Word INCORRECT_HARRY = new Word("hbrry");
    public static final Word INCORRECT_POTTER = new Word("p0tter");
    public static final Word INCORRECT_AND = new Word("ans");
    public static final Word INCORRECT_CHAMBER = new Word("chnmber");
    public static final Word INCORRECT_SECRETS = new Word("sekrets");

    //distance set
    public static final Word DISTANCE_HARRY = new Word("harry", 1);
    public static final Word DISTANCE_POTTER = new Word("potter", 1);
    public static final Word DISTANCE_AND = new Word("and", 1);
    public static final Word DISTANCE_CHAMBER = new Word("chamber", 1);
    public static final Word DISTANCE_SECRETS = new Word("secrets", 1);

    private TypicalWords() {} //prevents instantiation

    /**
     * Returns an {@code WordBank} with all the typical books converted into words.
     */
    public static WordBank getTypicalWordBank() {
        Library lib = new Library();
        for (Book book : TypicalBooks.getTypicalBooks()) {
            lib.addBook(book);
        }
        return new WordBank(lib);
    }

    public static WordBank getEmptyWordBank() {
        Library lib = new Library();
        return new WordBank(lib);
    }

    public static List<Word> getTypicalWords() {
        return new ArrayList<>(Arrays.asList(CORRECT_HARRY, CORRECT_POTTER, CORRECT_AND,
                CORRECT_CHAMBER, CORRECT_SECRETS));
    }

    public static List<String> getTypicalStrings() {
        return new ArrayList<>(Arrays.asList(HARRY, POTTER, AND,
                CHAMBER, SECRETS));
    }




}
