package com.univaq.mwt.headlines.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.univaq.mwt.headlines.model.Article;
import com.univaq.mwt.headlines.repository.BookmarksRepository;

import java.util.List;

public class BookmarksViewModel extends ViewModel {

    private BookmarksRepository repository;
    private LiveData<List<Article>> bookmarks;

    BookmarksViewModel(@NonNull BookmarksRepository repository) {
        this.repository = repository;
    }

    public void init() {
        if (bookmarks != null)
            return;
        bookmarks = repository.getAllBookmarks();
    }

    public LiveData<List<Article>> getBookmarks() {
        return bookmarks;
    }

    public void insert(Article article) {
        repository.addBookmark(article);
    }

    public void delete(Article article) {
        repository.deleteBookmark(article);
    }
}
