package com.locations.domain.di

import com.locations.domain.usecase.VenueDetailsUseCase
import com.locations.domain.usecase.VenueDetailsUseCaseImpl
import com.locations.domain.usecase.VenueListUseCase
import com.locations.domain.usecase.VenueListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    internal abstract fun bindVenueListUseCaseImpl(venueListUseCaseImpl: VenueListUseCaseImpl): VenueListUseCase

    @Binds
    internal abstract fun bindVenueDetailsUseCaseImpl(venueDetailsUseCaseImpl: VenueDetailsUseCaseImpl): VenueDetailsUseCase
}