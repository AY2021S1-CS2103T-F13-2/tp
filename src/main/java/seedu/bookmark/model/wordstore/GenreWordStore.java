package seedu.bookmark.model.wordstore;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class GenreWordStore extends WordStore {

    ArrayList<Word> genreWordStore;

    public GenreWordStore() {
        this.genreWordStore = new ArrayList<>();
    }

    @Override
    public boolean contains(String toCheck) {
        requireNonNull(toCheck);
        return genreWordStore.stream().anyMatch(word -> word.getWord().equals(toCheck));
    }

    @Override
    public void addWords(List<String> words) {
        for (String word : words) {
            wordAdder(word);
        }
    }

    @Override
    public void deleteWords(List<String> words) {
        for (String word : words) {
            wordDeleter(word);
        }
    }

    @Override
    public ArrayList<Word> getWordStore() {
        return this.genreWordStore;
    }

    @Override
    public void wordAdder(String targetWord) {
        requireNonNull(targetWord);
        boolean added = contains(targetWord);
        if (added) {
            genreWordStore.stream().filter(word -> word.getWord()
                    .equals(targetWord)).findFirst().get().addCount();
        } else {
            Word newWord = new Word(targetWord);
            this.addWord(newWord);
        }
    }

    @Override
    public void wordDeleter(String targetWord) {
        requireNonNull(targetWord);
        Word existingWord = genreWordStore.stream().filter(word -> word.getWord()
                .equals(targetWord)).findFirst().get();
        if (existingWord.getCount() == 1) {  //only got 1 instance which is the deleted book
            this.deleteWord(existingWord);
        } else {
            existingWord.minusCount();
        }
    }

    private void addWord(Word word) {
        this.genreWordStore.add(word);
    }

    private void deleteWord(Word word) {
        this.genreWordStore.remove(word);
    }


}
