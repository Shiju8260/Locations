package com.locations.data.di

import com.locations.data.repository.VenueDetailsRepositoryImpl
import com.locations.data.repository.VenueListRepositoryImpl
import com.locations.domain.repository.VenueDetailsRepository
import com.locations.domain.repository.VenueListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideVenueListRepository(repo: VenueListRepositoryImpl): VenueListRepository = repo
    @Provides
    fun provideVenueDetailsRepository(repo: VenueDetailsRepositoryImpl): VenueDetailsRepository = repo
}