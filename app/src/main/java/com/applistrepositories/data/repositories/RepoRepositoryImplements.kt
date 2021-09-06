package com.applistrepositories.data.repositories

import com.applistrepositories.util.RemoteException
import com.applistrepositories.data.service.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImplements(private val service: GitHubService) : RepoRepository {

    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepos(user)
            emit(repoList)
        } catch (e: HttpException){
            throw RemoteException(e.message ?: "Não foi possivel fazer a busca no momento")
        }
    }
}