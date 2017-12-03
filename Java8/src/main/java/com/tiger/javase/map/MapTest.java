package com.tiger.javase.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class MapTest {

	Logger log = Logger.getLogger(MapTest.class.getName());

	public static void main(String[] args) {
		MapTest mt = new MapTest();
		mt.testMap();
	}

	private void testMap() {
		log.log(log.getLevel().INFO, "Before testMap.");
		// hash map
		testHashMap();
		// hash table
		testHashTable();
		testConcurrentHashMap();
		testLinkedHashMap();
		// tree map
		testTreeMap();
		log.log(log.getLevel().INFO, "After testMap.");
	}

	/*
	 * 自然排序
	 */
	private void testTreeMap() {
		Map<Integer, Integer> map1 = new TreeMap<>();
		map1.put(1, 1);
		map1.put(2, 2);
		map1.put(5, 5);
		map1.put(4, 4);
		map1.put(3, 3);
		for (Integer integer : map1.keySet()) {

			System.out.println("Before Java8 " + map1.get(integer));
		}
		map1.forEach((k, v) -> System.out.println("Java8 " + v));

		Map<String, String> map2 = new TreeMap<>();
		map2.put("b", "bb");
		map2.put("d", "dd");
		map2.put("a", "aa");
		map2.put("c", "cc");
		map2.put("e", "ee");
		for (String string : map2.keySet()) {
			System.out.println("Before Java8 " + map2.get(string));
		}
		map2.forEach((k, v) -> System.out.println("Java8 " + k + ":" + v));
		map2.forEach((k, v) -> {
			if (k.equals("a")) {
				System.out.println("Java8 " + k + ":" + v);
			}
			if (k == "a") {
				System.out.println("Java8 " + k + ":" + v);
			}
		});

	}

	/*
	 * 顺序排序
	 */
	private void testLinkedHashMap() {
		Map<Integer, Integer> map1 = new LinkedHashMap<Integer, Integer>();
		map1.put(1, 1);
		map1.put(2, 2);
		map1.put(5, 5);
		map1.put(4, 4);
		map1.put(3, 3);
		for (Integer integer : map1.keySet()) {
			System.out.println("Before Java8 " + map1.get(integer));
		}
		map1.forEach((k, v) -> System.out.println("Java8 " + v));
	}

	/*
	 * 并发
	 */
	private void testConcurrentHashMap() {
		ConcurrentHashMap<Integer, Integer> chm = new ConcurrentHashMap<>();
		chm.put(1, 1);
		chm.put(3, 3);
		chm.put(2, 2);
		chm.put(4, 4);
		chm.forEach((k, v) -> System.out.println("Java8" + v));
	}

	private void testHashMap() {
		//
		// testInfiniteLoopJava7();
		// testInfiniteLoopJava8();
		testObjKeyMap();
	}

	final HashMap<String, Integer> map = new HashMap<String, Integer>(2);

	private void testInfiniteLoopJava8() {
		Thread t = new Thread(() -> {
			for (int j = 0; j < 10000; j++) {
				new Thread(() -> {
					String uuid = UUID.randomUUID().toString();
					for (int i = 0; i < 10000; i++) {
						map.put(uuid, 0);
					}
					for (int i = 0; i < 10000; i++) {
						map.get(uuid);
					}
					System.out.println("Thread: " + Thread.currentThread().getName());
				}, "t" + j).start();
			}
		}, "t");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void testInfiniteLoopJava7() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j < 10000; j++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							String uuid = UUID.randomUUID().toString();
							for (int i = 0; i < 10000; i++) {
								map.put(uuid, 0);
							}
							for (int i = 0; i < 10000; i++) {
								map.get(uuid);
							}
							System.out.println("Thread: " + Thread.currentThread().getName());
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}, "t" + j).start();
				}
			}
		}, "t");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void testObjKeyMap() {
		Map<ObjKey, String> map = new HashMap<ObjKey, String>();
		ObjKey ok1 = new ObjKey(1, 11, "a");
		map.put(ok1, "aa");

		System.out.println(map.get(new ObjKey(1, 11, "a")));

		System.out.println(map.get(new ObjKey(2, 11, "a")));

		ObjKey ok2 = new ObjKey(1, 11, "a");
		ok2.setName("b");
		// ok2.setId(3);
		map.put(ok2, "bb");
		System.out.println(map.get(new ObjKey(1, 11, "a")));
		map.forEach((k, v) -> System.out.println("Java8 " + k + ":" + "v"));
	}

	@SuppressWarnings("unused")
	private void testHashTable() {
		@SuppressWarnings("rawtypes")
		Hashtable<Integer, Integer> ht = new Hashtable();
		ht.put(1, 1);
		System.out.println(ht.get(1));
	}
}
