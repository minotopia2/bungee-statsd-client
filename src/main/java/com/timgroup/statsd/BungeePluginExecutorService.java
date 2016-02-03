package com.timgroup.statsd;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * An executor service that forwards calls to BungeeCord's scheduler.
 *
 * @author <a href="http://xxyy.github.io/">xxyy</a>
 * @since 2016-02-03
 */
public class BungeePluginExecutorService implements ExecutorService {
    private final Plugin plugin;

    public BungeePluginExecutorService(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void shutdown() {
        // We can't shut down Bungee
    }

    @Override
    public List<Runnable> shutdownNow() {
        return Collections.emptyList(); //We can't shutdown Bungee
    }

    @Override
    public boolean isShutdown() {
        return false; //Bungee is always alive
    }

    @Override
    public boolean isTerminated() {
        return false; //Bungee is always alive
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false; //Can't terminate Bungee, sorry
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        throw new UnsupportedOperationException(); //Don't need all these if they're not even used
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Future<?> submit(Runnable task) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void execute(Runnable command) {
        plugin.getProxy().getScheduler().runAsync(plugin, command);
    }
}
