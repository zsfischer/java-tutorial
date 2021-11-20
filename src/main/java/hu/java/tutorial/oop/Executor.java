package hu.java.tutorial.oop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The Concurrency API introduces the concept of an ExecutorService as a higher level replacement for working with threads directly.
 * Executors are capable of running asynchronous tasks and typically manage a pool of threads, so we don't have to create new threads manually.
 * All threads of the internal pool will be reused under the hood for revenant tasks, so we can run as many concurrent tasks as we want throughout the life-cycle of our application with a single executor service.
 * https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
 */
public class Executor
{
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        //Callable and Futures
        /**
         * Callables are functional interfaces just like runnables but instead of being void they return a value.
         */
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        /**
         * Since submit() doesn't wait until the task completes, the executor service cannot return the result of the callable directly.
         * Instead the executor returns a special result of type Future which can be used to retrieve the actual result at a later point in time.
         */
        executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        //Calling the method get() blocks the current thread and waits until the callable completes
        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);

        //Keep in mind that every non-terminated future will throw exceptions if you shutdown the executor:
//        executor.shutdownNow();
//        future.get();


        /**
         * Any call to future.get() will block and wait until the underlying callable has been terminated.
         * In the worst case a callable runs forever - thus making your application unresponsive.
         */
        executor = Executors.newFixedThreadPool(1);
        future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        //Ez a rész hibát dob, hiszen 1 másodperces időtullépést adtunk meg, de alapból a Future-ben 2 másodperces 'alvás' van.
//        future.get(1, TimeUnit.SECONDS);

        /**
         * invokeAll()
         * Executors support batch submitting of multiple callables at once via invokeAll().
         * This method accepts a collection of callables and returns a list of futures.
         */
        executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        executor.invokeAll(callables)
                .stream()
                .map(future1 -> {
                    try {
                        return future1.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

        /**
         * invokeAny()
         * Instead of returning future objects this method blocks until the first callable terminates and returns the result of that callable.
         */
        executor = Executors.newWorkStealingPool();

        callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String result1 = executor.invokeAny(callables);
        System.out.println(result1);

        shutDownExecutor(executor);
    }

    private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    private static void shutDownExecutor(ExecutorService executor) {
        /**
         * Executors have to be stopped explicitly - otherwise they keep listening for new tasks.
         * An ExecutorService provides two methods for that purpose: shutdown() waits for currently running tasks to finish while shutdownNow() interrupts all running tasks and shut the executor down immediately.
         */
        //Preferred way of shutting down executors
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
