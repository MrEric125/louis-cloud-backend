package com;

import javax.script.ScriptEngineManager;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/28
 * Description:
 */
public class TaskExecution {

    private static final int NTHREADS = 100;
    public static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public  void runTest(String[] args) throws IOException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Runnable socket = () -> {

            };
            exec.execute(socket);
        }

    }
}
