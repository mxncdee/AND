package com.univaq.mwt.headlines.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.univaq.mwt.headlines.model.Article;
import com.univaq.mwt.headlines.model.ArticlesCache;
import com.univaq.mwt.headlines.util.Constants;

@Database(entities = {Article.class, ArticlesCache.class}, version = 1, exportSchema = false)
@TypeConverters(AppConverters.class)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, Constants.DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ArticlesCacheDao articlesCacheDao();

    public abstract BookmarksDao bookmarksDao();
}