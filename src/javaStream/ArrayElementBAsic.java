package javaStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
public class ArrayElementBAsic {
	public static void main(String[] args) 
	{
/*	 Test1 
 * public void test1()
	{
		ArrayList<String> name=new ArrayList<String>();
		name.add("Amit");
		name.add("Anshu");
		name.add("Divyansh");
		name.add("Megha");
		name.add("Aher");
		int count=0;
		for(int i=0;i<name.size();i++)
		{
			
			String actual=name.get(i);
			if (actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
	}
	*/
	//StreamFilter
		//print name start with A
	{
		ArrayList<String> name=new ArrayList<String>();
		name.add("Amit");
		name.add("Anshu");
	
		name.add("Aher");
		name.add("Jadhav");
		
		long c = name.stream().filter(s->s.startsWith("A")).count();
	//	System.out.println(c);
		
	Long d = Stream.of("Amit","Anshu","Divyansh","Megha","Aher").filter(s->
	{
		s.startsWith("A");
		return true;
	}).count();
	//System.out.println(d);
	//print all name having length more than 4
//	name.stream().filter(t->t.length()>4).forEach(t->System.out.println(t));
	//limit result to 1
	//name.stream().filter(t->t.length()>4).limit(1).forEach(t->System.out.println(t));
	
	}
	
	//StreamMap
	//print names end with a with uppercase
	//Stream.of("Amit","Anshu","Divyansh","Megha","Aher").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	//print name start with a with uppercase in sorted order
	List<String> name1 = Arrays.asList("Amit","Anshu","Divyansh","Megha","Aher");
	//name1.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
	
	
	ArrayList<String> name=new ArrayList<String>();
	name.add("Amit");
	name.add("Anshu");
	name.add("Divyansh");
	name.add("Megha");
	name.add("Aher");
	
	//Stream<String> name3=Stream.concat(name.stream(),name1.stream());
	//name3.sorted().forEach(s->System.out.println(s));
	//boolean flag = name3.anyMatch(s->s.equalsIgnoreCase("Megha"));
//	Assert.assertTrue(flag);
	
	List<String> ls = Stream.of("Amit","Anshu","Divyanshu","Megha","Aher").filter(s->s.endsWith("u")).map(s->s.toUpperCase())
	.collect(Collectors.toList());
	System.out.println(ls.get(0));
	ls.stream().forEach(s->System.out.println(s));
	
	List<Integer> num = Arrays.asList(1,2,4,2,6,4,8,5,9,4);
	//num.stream().distinct().forEach(s->System.out.println(s));
	List<Integer> li = num.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(li.get(2));
	}
}

