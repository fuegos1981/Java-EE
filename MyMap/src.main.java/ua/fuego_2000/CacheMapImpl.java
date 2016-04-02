package ua.fuego_2000;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class CacheMapImpl<KeyType, ValueType> implements CacheMap<KeyType, ValueType> {

	private Map<KeyType, ValueType> map;
	private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			thread.setDaemon(true);
			return thread;
		}
	});

	public CacheMapImpl() {
		map = new HashMap<>();

	}

	private long timeout;

	@Override
	public void setTimeToLive(long timeToLive) {
		// TODO Auto-generated method stub
		this.timeout = timeToLive;
		clearExpired();

	}

	@Override
	public long getTimeToLive() {
		// TODO Auto-generated method stub
		return timeout;
	}

	@Override
	public ValueType put(KeyType key, ValueType value) {
		// TODO Auto-generated method stub

		map.put(key, value);
		return value;
	}

	@Override
	public void clearExpired() {

		scheduler.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {

				clear();
				Clock.setTime(0);

			}
		}, Clock.getTime(), getTimeToLive(), TimeUnit.MILLISECONDS);

	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);

	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public ValueType get(Object key) {
		return map.get(key);
	}

	@Override
	public boolean isEmpty() {

		return map.isEmpty();
	}

	@Override
	public ValueType remove(Object key) {
		return map.remove(key);
	}

	@Override
	public int size() {

		return map.size();
	}

}
