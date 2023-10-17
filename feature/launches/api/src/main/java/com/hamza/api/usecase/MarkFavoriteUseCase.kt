package com.hamza.api.usecase

import com.hamza.api.Launches

interface MarkFavoritesUseCase {
    suspend operator fun invoke(item: Launches)
}
