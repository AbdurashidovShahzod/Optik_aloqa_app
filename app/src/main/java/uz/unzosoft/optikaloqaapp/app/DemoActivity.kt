package uz.unzosoft.optikaloqaapp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import uz.unzosoft.optikaloqaapp.R
import java.util.*

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
    }
}

/**
fun main(args: Array<String>): Unit = runBlocking {
    repeat(100) {
        launch {
            val doWork = doWork("Abdurashidov Shahzod")
            println(doWork + it.toString())
        }
    }
}
 */


fun main(args: Array<String>): Unit = runBlocking {

    val coroutine:List<Deferred<String>> = List(100){
        async(start = CoroutineStart.LAZY) {
            doWork("Abdurashidov Shahzod $it")
        }
    }
    coroutine.forEach { println(it.await()) }

}


suspend fun doWork(str: String): String {
    delay(Random().nextInt(5000).toLong())
    return "Coroutine ishlayabdi ---->>> $str"
}