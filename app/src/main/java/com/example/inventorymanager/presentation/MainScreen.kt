import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.vector.ImageVector

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val label: String,
    val count: Int
)

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity)
}

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: android.content.Context): AppDatabase {
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


@Composable
fun DashboardScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu Item 1", modifier = Modifier.padding(16.dp))
                Text("Menu Item 2", modifier = Modifier.padding(16.dp))
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("MyApp", modifier = Modifier.weight(1f))
                            Icon(Icons.Default.AccountCircle, contentDescription = "App Icon")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(8.dp)
                        .verticalScroll(rememberScrollState())
                        .fillMaxSize()
                ) {
                    // Store row
                    Text("Current Store: Store A", modifier = Modifier.padding(8.dp))

                    // First row: Goods and Documents
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        DashboardCard(
                            title = "Goods",
                            icon = Icons.Default.Inventory,
                            count = 15,
                            color = Color.Green,
                            modifier = Modifier.weight(1f)
                        )
                        DashboardCard(
                            title = "Documents",
                            icon = Icons.Default.Description,
                            count = 7,
                            color = Color.LightGray,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Second to Fourth rows: Icon + label only
                    repeat(3) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            DashboardCard(
                                title = "Button A",
                                icon = Icons.Default.Star,
                                modifier = Modifier.weight(1f)
                            )
                            DashboardCard(
                                title = "Button B",
                                icon = Icons.Default.Favorite,
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    // Fifth row: 4 icons only
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(4) {
                            IconCard(
                                icon = Icons.Default.Settings,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun DashboardCard(
    title: String,
    icon: ImageVector,
    count: Int? = null,
    color: Color = Color.LightGray,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, contentDescription = title, modifier = Modifier.size(32.dp))
            Text(title, fontWeight = FontWeight.Bold)
            count?.let {
                Text("Count: $it", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun IconCard(icon: ImageVector, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(80.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(28.dp))
        }
    }
}


@Composable
fun MainScreen(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Your App Name") },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        drawerContent = {
            Text("Drawer Item 1", modifier = Modifier.padding(16.dp))
            Text("Drawer Item 2", modifier = Modifier.padding(16.dp))
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            // Secondary Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Your Secondary Text", fontSize = 20.sp, color = Color.Black)
            }

            // Grid View
            GridView(viewModel)
        }
    }
}

@Composable
fun GridView(viewModel: MainViewModel) {
    val items by viewModel.items.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items.size) { index ->
            GridItemView(item = items[index])
        }
    }
}

@Composable
fun GridItemView(item: ItemEntity) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = Icons.Default.Folder, contentDescription = item.label, modifier = Modifier.size(50.dp))
        Text(text = item.label, fontSize = 16.sp, textAlign = TextAlign.Center)
        Text(text = "Count: ${item.count}", fontSize = 14.sp, color = Color.Gray)
    }
}