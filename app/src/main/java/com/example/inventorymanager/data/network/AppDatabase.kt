package com.example.inventory.data.network

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inventorymanager.domain.model.masterdata.Item
import com.example.inventorymanager.domain.model.ingoings.PurchaseOrder
import com.example.inventorymanager.domain.model.ingoings.PurchaseOrderLine
import com.example.inventorymanager.data.dao.masterdata.ItemDao
import com.example.inventorymanager.data.dao.ingoings.OrderDetailDao
import com.example.inventorymanager.data.dao.ingoings.OrderDao


@Database(entities = [Item::class, PurchaseOrder::class, PurchaseOrderLine::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ItemDao
    abstract fun orderDao(): OrderDao
    abstract fun orderDetailsDao(): OrderDetailDao

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
