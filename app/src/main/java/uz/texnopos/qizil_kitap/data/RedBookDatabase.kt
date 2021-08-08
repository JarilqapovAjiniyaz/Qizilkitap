package uz.texnopos.qizil_kitap.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.texnopos.qizil_kitap.data.dao.NatureDao
import uz.texnopos.qizil_kitap.data.model.nature

@Database(entities = [nature::class],version = 1)
abstract class RedBookDatabase : RoomDatabase() {
companion object{
private lateinit var INSTANCE : RedBookDatabase
fun getInstance(context: Context) : RedBookDatabase = Room.databaseBuilder(
    context,
    RedBookDatabase::class.java, "book.db"
)
    .createFromAsset("book.db")
    .build()
}
abstract fun dao():NatureDao
}