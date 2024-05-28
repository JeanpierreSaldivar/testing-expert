package com.devexperto.testingexpert

/**
 * Created by César Jeanpierre Saldivar on 17/05/2024.
 * @devjeanpierre
 * Lima, Peru.
 **/

data class Movie(val id: Int, val title : String)

interface MoviesLocalDataSource {
    fun isEmpty(): Boolean
    fun saveAll(movie : List<Movie>)
    fun findAll(): List<Movie>
}

interface MoviesRemoteDataSource {
    fun findPopularMovies(): List<Movie>
}

class MoviesRepository(
    private val moviesLocalDataSource : MoviesLocalDataSource,
    private val moviesRemoteDataSource : MoviesRemoteDataSource
) {

    fun findAll() : List<Movie>{
        if(moviesLocalDataSource.isEmpty()){
            val movies = moviesRemoteDataSource.findPopularMovies()
            moviesLocalDataSource.saveAll(movies)
        }
        return moviesLocalDataSource.findAll()
    }
}