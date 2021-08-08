package uz.texnopos.qizil_kitap.data.dao

import androidx.room.Dao
import androidx.room.Query
import uz.texnopos.qizil_kitap.data.model.nature

@Dao
interface NatureDao {
@Query("SELECT * FROM book")
fun getAllNature() : List<nature>
}