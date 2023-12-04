import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tri.ui.theme.TriTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    private val generatedNumbers = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriTheme {
                // App content
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    // Title
                    Text(
                        text = "Sorting Game",
                        style = TextStyle(
                            fontSize = 24.sp,
                            shadow = Shadow(
                                color = Color.Blue, blurRadius = 3f
                            )
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    // Centered and styled LazyRow
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Gray, shape = RoundedCornerShape(8.dp)),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        // Generate 5 items in the list
                        items(5) {
                            ListItem(generatedNumbers)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(generatedNumbers: MutableList<Int>) {
    var randomNumber: Int

    // Generate a random number different from the ones already generated
    do {
        randomNumber = Random.nextInt(1, 1001)
    } while (randomNumber in generatedNumbers)

    // Add the number to the list of generated numbers
    generatedNumbers.add(randomNumber)

    // Display the number in the Text component with a border style
    Text(
        text = "$randomNumber",
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
    )
}

@Preview
@Composable
fun ListItemPreview() {
    val generatedNumbers = mutableListOf<Int>()
    ListItem(generatedNumbers)
}
