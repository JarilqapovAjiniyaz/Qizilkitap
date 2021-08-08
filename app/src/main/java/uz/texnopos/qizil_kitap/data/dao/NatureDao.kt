package uz.texnopos.qizil_kitap.data.dao

import androidx.room.Dao
import androidx.room.Query
import uz.texnopos.qizil_kitap.data.model.nature

@Dao
interface NatureDao {
@Query("SELECT * FROM book WHERE type = :type")
fun getAllNature(type : Int) : List<nature>
}