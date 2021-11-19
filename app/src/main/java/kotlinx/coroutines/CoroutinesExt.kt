package kotlinx.coroutines

/**
 * Usado para usos intensivos de CPU, como ordenação de listas, parse de JSON, DiffUtils, etc;
 */
fun CoroutineScope.onCpu(function: suspend CoroutineScope.() -> Unit) {
    launch(Dispatchers.Default) {
        function()
    }
}

/**
 * Usa a thread de UI (user interface).
 * Portanto, só é recomendado usar quando realmente precisar interagir com a interface de usuário;
 */
fun CoroutineScope.onMain(function: suspend CoroutineScope.() -> Unit) {
    launch(Dispatchers.Main) {
        function()
    }
}

/**
 * Usado para operações de input/output.
 * Geralmente é usado quando precisa esperar uma resposta,
 * como por exemplo: requisições para um servidor, leitura e/ou escrita num banco de dados, etc;
 */
fun CoroutineScope.onIO(function: suspend CoroutineScope.() -> Unit) {
    launch(Dispatchers.IO) {
        function()
    }
}

/**
 * Para operações que não precisam de uma thread específica.
 * É recomendado usar quando não consome tempo de CPU nem atualiza dados compartilhados,
 * é executada na mesma thread de quem a chamou,
 * mas só se mantém nessa thread até o primeiro ponto de suspensão.
 */
fun CoroutineScope.onCurrent(function: suspend CoroutineScope.() -> Unit) {
    launch(Dispatchers.Unconfined) {
        function()
    }
}

/**
 * TODO DESC
 */
fun <T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}