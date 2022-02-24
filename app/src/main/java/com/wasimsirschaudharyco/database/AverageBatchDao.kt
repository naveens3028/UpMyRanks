package com.wasimsirschaudharyco.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wasimsirschaudharyco.model.onBoarding.AverageBatchTests

@Dao
interface AverageBatchDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAvg(sectionItem: AverageBatchTests)

    @Query("SELECT * FROM AverageBatch")
    fun getAll(): MutableList<AverageBatchTests>

}