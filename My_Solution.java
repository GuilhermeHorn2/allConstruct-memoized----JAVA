package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class main_misc {
    private static HashMap<String,String> cache = new HashMap<>();
	public static void main(String[] args) {
	   
		
	String t = "purple";
	String [] w = {"purp","p","ur","le","purpl"};
	ArrayList<String> all = new ArrayList<>();
	System.out.println(allConstruct(t,w,all));
	System.out.println(all);
	System.out.println(clean(all,t));

		
		
	}
	
	private static String allConstruct(String t,String[] w,ArrayList<String> all) {
		//n = w.length and m = t.length
		//O(n^m) -- > O(m*n)
		
		if(t.equals("")){
			return  "";
		}
		if(cache.containsKey(t)) {
			return cache.get(t);
		}
		
		String d = "";
		for(int i = 0;i < w.length;i++) {
			if(t.startsWith(w[i])) {
				String r = t.replaceFirst(w[i], "");
				String s = " "+ w[i]+allConstruct(r,w,all);
				all.add(s);
				d += s;
	        }			
			
		  }
	cache.put(t,d);
       return d;
	}
	
	private static ArrayList clean(ArrayList<String> all,String t) {
		
		ArrayList<String> l = new ArrayList<>();
		
		for(int i = 0;i < all.size();i++){
			String s = "";
			for(int j = 0;j < all.get(i).length();j++) {
				 s +=  all.get(i).substring(j,j+1);
				 if(j == all.get(i).length() -1) {
					 String d = s;
					 s = s.replaceAll(" ","");
					 if(s.equals(t)){
						 d = d.replaceFirst(" ","");
						 l.add(d.replaceAll(" "," + "));
					 }
				 }
			}
		}
		return l;
		
		
	}
	
	
	}
    
	
	
	
	
	
	
	
	
	

	


	
	

	
		
	
	


	

	
	

