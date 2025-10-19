import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Entity
import com.example.inventorymanager.core.Constants.Companion.SALES_RETURN_LINE_TABLE

@Entity(
    tableName = SALES_RETURN_LINE_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = SalesReturn::class,
            parentColumns = ["salesReturnId"],
            childColumns = ["salesReturnId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["productId"],
            childColumns = ["itemId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["warehouseId"],
            childColumns = ["warehouseId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["salesReturnId"]),
        Index(value = ["itemId"]),
        Index(value = ["warehouseId"])
    ]
)
data class SalesReturnLine(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val salesReturnId: Long,
    val itemId: Long,
    val quantity: Double,
    val warehouseId: Long
)