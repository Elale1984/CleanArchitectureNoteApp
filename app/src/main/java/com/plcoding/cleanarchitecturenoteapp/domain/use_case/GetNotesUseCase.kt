package com.plcoding.cleanarchitecturenoteapp.domain.use_case

import androidx.room.FtsOptions
import com.plcoding.cleanarchitecturenoteapp.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending
    ): Flow<List<Note>> {
        return repository.getNote().map { notes ->
            when   (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { this.color }
                    }
                }
                is OrderType.Descending -> {

                }
            }
        }

    }
}