package com.plcoding.cleanarchitecturenoteapp.feature_note.data.Repository

import com.plcoding.cleanarchitecturenoteapp.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl (
    private val dao: NoteDao
        ) : NoteRepository {

    override fun getNote(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNotById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}