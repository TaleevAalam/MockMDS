package org.biometric.provider;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		HashMap<Integer, Emp> hS = new HashMap<>();
		Emp e3 = new Emp("wasif", 14);
		Emp e1 = new Emp("taleev", 23);
		Emp e2 = new Emp("atif", 17);

		hS.put(14, e3);
		hS.put(23, e1);
		hS.put(17, e2);
		
		//now i wanna sort based on the age of the employee object
		
		List<Entry<Integer, Emp>> lS = new LinkedList(hS.entrySet());

		for(Entry<Integer, Emp> in : hS.entrySet()) {
			System.out.println(in.getValue().toString());
		}	
		
		System.out.println("---------------------------------");
		
		Collections.sort(lS, (o1,o2)-> {
				return o1.getValue().age==o2.getValue().age?0:o1.getValue().age>o2.getValue().age?-1:1;
		});
	

		for(Entry<Integer, Emp> l : lS) {
			System.out.println(l.getValue().toString());
		}
		
//
//		Entry<Integer, Emp> iM =  lS.stream().filter(x->x.getValue().age==23).findAny().orElseGet(()->{				
//				Entry<Integer, Emp> eM = lS.get(0);
//				lS.add(eM);
//				return eM;
//		});
		
		
		
		
	System.out.println("---------------------");
	
	for(Entry<Integer, Emp> l : lS) {
		System.out.println(l.getValue().toString());
	}
	
//
//		
//		 HashMap<Integer,Emp> sortedHashMap = new LinkedHashMap<Integer, Emp>();
//
//		 for(Entry<Integer, Emp> s : lS) {
//			 sortedHashMap.put(s.getKey(), s.getValue());
//		 }
//		 
//		for(Entry<Integer, Emp> l : sortedHashMap.entrySet()) {
//			System.out.println(l.getValue().toString());
//		}

	       
//		Map<Integer, Emp> hM = new LinkedHashMap<Integer, Emp>();
//		
//		hM  = lS.stream().collect(Collectors.toMap(p->p.getKey(), p->p.getValue()));
//		
//		for(Entry<Integer, Emp> x : hM.entrySet()) {
//			System.out.println(x.getValue().toString());
//		}
		
		
	}
	
	
	static class Emp{
		String name;
		int age;
		
		public Emp(String name, int age) {
			this.name=name;
			this.age=age;
		}

		@Override
		public String toString() {
			return "Emp [name=" + name + ", age=" + age + "]";
		}
	}
}
