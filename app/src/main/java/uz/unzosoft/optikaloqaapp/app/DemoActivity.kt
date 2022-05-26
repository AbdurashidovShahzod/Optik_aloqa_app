package uz.unzosoft.optikaloqaapp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import uz.unzosoft.optikaloqaapp.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding
    private val TAG = "DemoActivityLog"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "Starting coroutine in thread ${Thread.currentThread().name}")
            val networkCall1 = doNetworkCall1()
            withContext(Dispatchers.Main) {
                Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
                binding.tv.text = networkCall1
            }
        }
    }
}

suspend fun doNetworkCall1(): String {
    delay(3000L)
    return "This is the answer 1"
}

suspend fun doNetworkCall2(): String {
    delay(3000L)
    return "This is the answer 2"
}

/**
Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")


fun main(args: Array<String>): Unit = runBlocking {
repeat(100) {
launch {
val doWork = doWork("Abdurashidov Shahzod")
println(doWork + it.toString())
}
}
}
 */


//fun main(args: Array<String>): Unit = runBlocking {
//
//    val coroutine:List<Deferred<String>> = List(100){
//        async(start = CoroutineStart.LAZY) {
//            doWork("Abdurashidov Shahzod $it")
//        }
//    }
//    coroutine.forEach { println(it.await()) }
//
//}
//
//
//suspend fun doWork(str: String): String {
//    delay(Random().nextInt(5000).toLong())
//    return "Coroutine ishlayabdi ---->>> $str"
//}