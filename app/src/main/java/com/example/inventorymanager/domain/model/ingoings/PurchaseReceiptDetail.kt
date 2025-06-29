import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index
import java.util.Date
import com.example.inventorymanager.domain.model.ingoings.PurchaseReceipt
import com.example.inventorymanager.domain.model.masterdata.Item
import com.example.inventorymanager.core.Constants.Companion.PURCHASE_RECEIPT_DETAIL_TABLE

@Entity(
    tableName = PURCHASE_RECEIPT_DETAIL_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = PurchaseReceipt::class,
            parentColumns = ["purchaseReceiptId"],
            childColumns = ["purchaseReceiptId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["productId"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["purchaseReceiptId"]),
        Index(value = ["productId"])
    ]
)
data class PurchaseReceiptDetail(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val purchaseReceiptId: Int,
    val productId: Int,
    val quantity: Double,
    val unitPrice: Double,
    val discount: Double = 0.0,
    val total: Double,
    val storageBin: String?,
    val receivedDate: Date
)