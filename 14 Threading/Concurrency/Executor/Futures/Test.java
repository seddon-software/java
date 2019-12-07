////////////////////////////////////////////////////////////
//
//    Futures
//
////////////////////////////////////////////////////////////

package Concurrency.Executor.Futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {
	public static void main(String[] args) {
		MyClass m1 = new MyClass(1, 10);
		MyClass m2 = new MyClass(11, 20);
		MyClass m3 = new MyClass(21, 30);
		MyClass m4 = new MyClass(31, 40);
		MyClass m5 = new MyClass(41, 50);
		ExecutorService pool = Executors.newFixedThreadPool(2);
		FutureTask<Integer> ft1 = new FutureTask<Integer>(m1);
		FutureTask<Integer> ft2 = new FutureTask<Integer>(m2);
		FutureTask<Integer> ft3 = new FutureTask<Integer>(m3);
		FutureTask<Integer> ft4 = new FutureTask<Integer>(m4);
		FutureTask<Integer> ft5 = new FutureTask<Integer>(m5);
		pool.execute(ft1);
		pool.execute(ft2);
		pool.execute(ft3);
		pool.execute(ft4);
		pool.execute(ft5);
		pool.shutdown();

		try {
			int result = ft1.get() + ft2.get() + ft3.get() + ft4.get()
					+ ft5.get();
			System.out.println(result);
		} catch (ExecutionException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}

class MyClass implements Callable<Integer> {

	private int min;
	private int max;

	public MyClass(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public Integer call() {
		int sum = 0;
		for(int i = min; i <= max; i++) {
			sum += i * i;
		}
		int delay = 0;
		try {
			delay = (int) (10000 * Math.random());
			Thread.sleep(delay);
			System.out.println("Thread finished");
		} catch (InterruptedException e) {
			System.err.println(e);
		}
		return sum;
	}
}
