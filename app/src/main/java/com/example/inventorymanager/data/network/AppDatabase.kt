package com.example.inventory.data.network

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inventorymanager.domain.model.Product
import com.example.inventory.domain.model.Order
import com.example.inventory.domain.model.OrderDetails
import com.example.inventory.data.dao.ProductDao
import com.example.inventory.data.dao.OrderDetailsDao
import com.example.inventory.data.dao.OrderDao


@Database(entities = [Product::class, Order::class, OrderDetails::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun orderDao(): OrderDao
    abstract fun orderDetailsDao(): OrderDetailsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
