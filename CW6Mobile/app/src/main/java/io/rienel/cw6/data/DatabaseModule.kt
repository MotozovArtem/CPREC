package io.rienel.cw6.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.rienel.cw6.data.dao.ClientDao
import io.rienel.cw6.data.dao.OfferDao
import io.rienel.cw6.data.dao.OfficeDao
import io.rienel.cw6.data.dao.PositionDao
import io.rienel.cw6.data.dao.StuffDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

	@Provides
	@Singleton
	fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
		return Room.databaseBuilder(
			appContext,
			AppDatabase::class.java,
			AppDatabase.DATABASE_NAME
		).build()
	}

	@Provides
	@Singleton
	fun provideClientDao(appDatabase: AppDatabase): ClientDao {
		return appDatabase.clientDao()
	}

	@Provides
	@Singleton
	fun provideOfferDao(appDatabase: AppDatabase): OfferDao {
		return appDatabase.offerDao()
	}

	@Provides
	@Singleton
	fun provideOfficeDao(appDatabase: AppDatabase): OfficeDao {
		return appDatabase.officeDao()
	}

	@Provides
	@Singleton
	fun provideStuffDao(appDatabase: AppDatabase): StuffDao {
		return appDatabase.stuffDao()
	}

	@Provides
	@Singleton
	fun providePositionDao(appDatabase: AppDatabase): PositionDao {
		return appDatabase.positionDao()
	}
}