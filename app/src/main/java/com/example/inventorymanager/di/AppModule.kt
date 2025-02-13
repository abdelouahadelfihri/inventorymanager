package ro.alexmamo.roomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.inventorymanager.core.Constants.Companion.BOOK_TABLE
import com.example.inventorymanager.data.dao.BookDao
import com.example.inventorymanager.data.network.AppDatabase
import com.example.inventorymanager.data.repository.BookRepositoryImpl
import com.example.inventorymanager.domain.repository.BookRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideBookDao(database: AppDatabase): BookDao = database.bookDao()

    @Provides
    fun provideAuthorDao(database: AppDatabase): AuthorDao = database.authorDao()

    @Provides
    fun providePublisherDao(database: AppDatabase): PublisherDao = database.publisherDao()

    @Provides
    fun provideBookRepository(bookDao: BookDao): BookRepository = BookRepositoryImpl(bookDao)

    @Provides
    fun provideAuthorRepository(authorDao: AuthorDao): AuthorRepository = AuthorRepositoryImpl(authorDao)

    @Provides
    fun providePublisherRepository(publisherDao: PublisherDao): PublisherRepository =
        PublisherRepositoryImpl(publisherDao)
}
