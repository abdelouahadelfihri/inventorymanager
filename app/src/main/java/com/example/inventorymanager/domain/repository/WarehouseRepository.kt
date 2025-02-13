package com.example.inventorymanager.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.inventorymanager.domain.model.Book
typealias Books = List<Book>

interface WarehouseRepository {
    fun getBooksFromRoom(): Flow<Books>

    suspend fun getBookFromRoom(id: Int): Book

    suspend fun addBookToRoom(book: Book)

    suspend fun updateBookInRoom(book: Book)

    suspend fun deleteBookFromRoom(book: Book)
}