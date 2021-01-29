package com.univaq.mwt.headlines.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.univaq.mwt.headlines.data.db.AppDatabase;
import com.univaq.mwt.headlines.data.db.BookmarksDao;
import com.univaq.mwt.headlines.repository.BookmarksRepository;
import com.univaq.mwt.headlines.util.AppExecutor;

public class BookmarksViewModelFactory implements ViewModelProvider.Factory {
    private BookmarksRepository mRepository;

    public BookmarksViewModelFactory(Application application) {
        BookmarksDao bookmarksDao = AppDatabase.getDatabase(application).bookmarksDao();
        AppExecutor executor = new AppExecutor();

        mRepository = BookmarksRepository.getInstance(bookmarksDao, executor);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BookmarksViewModel(mRepository);
    }
}
