package mike.sample.coroutines

import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.system.measureTimeMillis

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/11/3
 * @description:
 */

//fun main() {
//    GlobalScope.launch { // 在后台启动一个新的协程并继续
//        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
//        println("World!") // 在延迟后打印输出
//    }
//    println("Hello,") // 协程已在等待时主线程还在继续
//    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
//
//    runBlocking {     // 但是这个表达式阻塞了主线程
//        delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
//    }
//}

//fun main() = runBlocking { // 开始执行主协程
//    GlobalScope.launch { // 在后台启动一个新的协程并继续
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,") // 主协程在这里会立即执行
//    delay(2000L)      // 延迟 2 秒来保证 JVM 存活
//}
//suspend fun main() {
//    val job = GlobalScope.launch { // 启动一个新协程并保持对这个作业的引用
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello,")
//    job.join() // 等待直到子协程执行结束
//}

//fun main() = runBlocking { // this: CoroutineScope
//    launch {
//        delay(200L)
//        println("Task from runBlocking")
//    }
//
//    coroutineScope { // 创建一个协程作用域
//        launch {
//            delay(500L)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
//    }
//
//    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
//}

//fun main() = runBlocking { // this: CoroutineScope
//    val job = launch {
//        repeat(1000) { i ->
//            println("job: I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
//    delay(1300L) // 延迟一段时间
//    println("main: I'm tired of waiting!")
////    job.cancelAndJoin()
//    job.cancel() // 取消该作业
//    job.join() // 等待作业执行结束
//    println("main: Now I can quit.")
//}

//fun main() = runBlocking {
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
//        while (isActive) { // cancellable computation loop
//            // print a message twice a second
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                println("job: I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
//    }
//    delay(1300L) // delay a bit
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // cancels the job and waits for its completion
//    println("main: Now I can quit.")
//}

//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("job: I'm sleeping $i ...")
//                delay(500L)
//            }
//        } finally {
//            println("job: I'm running finally")
//        }
//    }
//    delay(1300L) // 延迟一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该作业并且等待它结束
//    println("main: Now I can quit.")
//}


//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("job: I'm sleeping $i ...")
//                delay(500L)
//            }
//        } finally {
//            withContext(NonCancellable) {
//                println("job: I'm running finally")
//                delay(1000L)
//                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
//            }
//        }
//    }
//    delay(1300L) // 延迟一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该作业并等待它结束
//    println("main: Now I can quit.")
//}

//fun main() = runBlocking {
//    withTimeout(1300L) {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
//}

//fun main() = runBlocking {
//    withTimeoutOrNull(1300L) {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
//}

var acquired = 0

class Resource {
    init {
        acquired++
    } // Acquire the resource

    fun close() {
        acquired--
    } // Release the resource
}

//fun main() {
//    runBlocking {
//        repeat(100_000) { // Launch 100K coroutines
//            launch {
//                val resource = withTimeout(60) { // Timeout of 60 ms
//                    delay(50) // Delay for 50 ms
//                    Resource() // Acquire a resource and return it from withTimeout block
//                }
//                resource.close() // Release the resource
//            }
//        }
//    }
//    // Outside of runBlocking all coroutines have completed
//    println(acquired) // Print the number of resources still acquired
//}

//fun main() {
//    runBlocking {
//        repeat(100_000) { // Launch 100K coroutines
//            launch {
//                var resource: Resource? = null // Not acquired yet
//                try {
//                    withTimeout(60) { // Timeout of 60 ms
//                        delay(50) // Delay for 50 ms
//                        resource = Resource() // Store a resource to the variable if acquired
//                    }
//                    // We can do something else with the resource here
//                } finally {
//                    resource?.close() // Release the resource if it was acquired
//                }
//            }
//        }
//    }
//    // Outside of runBlocking all coroutines have completed
//    println(acquired) // Print the number of resources still acquired
//}

//fun main() = runBlocking<Unit> {
////    val time = measureTimeMillis {
////        val one = doSomethingUsefulOne()
////        val two = doSomethingUsefulTwo()
////        println("The answer is ${one + two}")
////    }
//
////    val time = measureTimeMillis {
////        val one = async { doSomethingUsefulOne() }
////        val two = async { doSomethingUsefulTwo() }
////        println("The answer is ${one.await() + two.await()}")
////    }
//
//    val time = measureTimeMillis {
//        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
//        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
//        // 执行一些计算
////        one.start() // 启动第一个
////        two.start() // 启动第二个
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time ms")
//}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    throw Exception()
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

// 注意，在这个示例中我们在 `main` 函数的右边没有加上 `runBlocking`
//fun main() {
//    val time = measureTimeMillis {
//        // 我们可以在协程外面启动异步执行
//        val one = somethingUsefulOneAsync()
//        val two = somethingUsefulTwoAsync()
//        // 但是等待结果必须调用其它的挂起或者阻塞
//        // 当我们等待结果的时候，这里我们使用 `runBlocking { …… }` 来阻塞主线程
//        runBlocking {
//            println("The answer is ${one.await() + two.await()}")
//        }
//    }
//    println("Completed in $time ms")
//}
//
//fun somethingUsefulOneAsync() = GlobalScope.async {
//    doSomethingUsefulOne()
//}
//
//// somethingUsefulTwoAsync 函数的返回值类型是 Deferred<Int>
//fun somethingUsefulTwoAsync() = GlobalScope.async {
//    doSomethingUsefulTwo()
//}

fun main() = runBlocking<Unit> {

    val mainScope = MainScope()
    coroutineScope {

    }
    launch {  }

    val context = Dispatchers.Default + CoroutineName("test")
    launch(context) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
    println("My job is ${coroutineContext[Job]}")
}

