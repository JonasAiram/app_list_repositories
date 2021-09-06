package com.applistrepositories.domain

import com.applistrepositories.data.model.Repo
import com.applistrepositories.data.repositories.RepoRepository
import com.applistrepositories.presentation.MainViewModel
import com.applistrepositories.util.UseCase
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
    ) : UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }

    fun clearRepoList(): List<Repo> {
        return emptyList()
    }

}