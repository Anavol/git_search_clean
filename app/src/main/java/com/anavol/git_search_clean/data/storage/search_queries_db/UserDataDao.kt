package com.anavol.git_search_clean.data.storage.search_queries_db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.anavol.git_search_clean.data.storage.search_queries_db.UserData

@Dao
interface UserDataDao {

    @Query("SELECT * FROM userData")
    suspend fun getAll(): List<UserData>

    @Insert(onConflict = REPLACE)
    suspend fun insert(userData: UserData): Long

    @Query("DELETE from userData")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteUser(user: UserData): Int
}