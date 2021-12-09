package com.plcoding.cleanarchitecturenoteapp.domain.repository

import com.plcoding.cleanarchitecturenoteapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNote(): Flow<List<Note>>

    suspend fun getNotById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}