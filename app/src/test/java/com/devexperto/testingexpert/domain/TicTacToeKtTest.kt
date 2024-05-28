package com.devexperto.testingexpert.domain

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by César Jeanpierre Saldivar on 15/05/2024.
 * @devjeanpierre
 * Lima, Peru.
 */
class TicTacToeKtTest {
    @Test
    fun `At the begining of the game, the board is empty`() {
        val ticTacToe = TicTacToe()

        assertTrue(ticTacToe.board.flatten().all { it== Empty })
    }

    @Test
    fun `The first player is X`() {
        val ticTacToe = TicTacToe()
            .move(0,0)

        assertEquals(X, ticTacToe.board[0][0])
    }

    @Test
    fun `The second player is O`() {
        val ticTacToe = TicTacToe()
            .move(0,0)
            .move(0,1)

        assertEquals(O, ticTacToe.board[0][1])
    }

    @Test
    fun `An occupied cell cannot be played`() {
        val ticTacToe = TicTacToe()
            .move(0,0)
            .move(0,0)

        assertEquals(X, ticTacToe.board[0][0])
    }

    @Test
    fun `The game ends when all cells in a row are taken by a player`() {
        val ticTacToe = TicTacToe()
            .move(0,0)
            .move(1,0)
            .move(0,1)
            .move(1,2)
            .move(0,2)

        assertEquals(X, ticTacToe.findWinner())
    }

    @Test
    fun `The game ends when all cells in a column are taken by a player`() {
        val ticTacToe = TicTacToe()
            .move(0,0)
            .move(0,1)
            .move(1,0)
            .move(1,1)
            .move(2,0)

        assertEquals(X, ticTacToe.findWinner())
    }

    @Test
    fun `The game ends when all cells in a diagonal are taken by a player`() {
        val ticTacToe = TicTacToe()
            .move(0,0)
            .move(2,1)
            .move(1,1)
            .move(1,0)
            .move(2,2)

        assertEquals(X, ticTacToe.findWinner())
    }

    @Test
    fun `The game ends in Draw when all cells are taken by a player`() {
        val ticTacToe = TicTacToe()
            .move(0,0)
            .move(0,1)
            .move(1,0)
            .move(1,1)
            .move(0,2)
            .move(1,2)
            .move(2,1)
            .move(2,0)
            .move(2,2)

        assertEquals(Draw, ticTacToe.findWinner())
    }

    @Test
    fun `When asked for a winner an there is no winner, it return null`() {
        val ticTacToe = TicTacToe()
            .move(0,0)

        assertEquals(null, ticTacToe.findWinner())
    }

    @Test
    fun `When 0 wins, the game ends`() {
        val ticTacToe = TicTacToe()
            .move(0,0)
            .move(0,1)
            .move(1,2)
            .move(1,1)
            .move(2,0)
            .move(2,1)


        assertEquals(O, ticTacToe.findWinner())
    }
}