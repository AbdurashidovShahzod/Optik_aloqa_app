package uz.unzosoft.optikaloqaapp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import uz.unzosoft.optikaloqaapp.databinding.ActivityDemoBinding
import kotlin.system.measureTimeMillis

class DemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding
    private val TAG = "DemoActivityLog"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.IO).launch {
            val time = measureTimeMillis {
                val answer1 = async { doNetworkCall1() }
                val answer2 = async { doNetworkCall2() }

                Log.d(TAG, "Answer 1 =>>>>> ${answer1.await()}")
                Log.d(TAG, "Answer 2 =>>>>> ${answer2.await()}")
            }
            Log.d(TAG, "Time worked $time.ms")
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

/**
 *  val block: suspend CoroutineScope.() -> Unit = { }
val job = GlobalScope.launch(Dispatchers.Default) {
repeat(10){
delay(1000L)
Log.d(TAG, "Coroutine job started==>>>$it  ${Thread.currentThread().name}")
}
}
runBlocking {
delay(2000L)
job.cancel(CancellationException("Cancel exception"))
Log.d(TAG, "Coroutine run blocking cancel  ${Thread.currentThread().name}")
}
 */