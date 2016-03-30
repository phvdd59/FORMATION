package vdd.allan;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import vdd.frogriverone.FrogRiverOne;

public class TestFrogRiverOne {

	FrogRiverOne frogRiverOne;
	
	@Before
	public void before(){
		frogRiverOne= new FrogRiverOne();
		
	}
	@Test
	public void test() {
	//	fail("Not yet implemented");
		int[] a={2,5,4,1,6,8,2,3,7,4,1,2};
		int reponse= frogRiverOne.solution(8, a);
		assertEquals(8,reponse);
	}
	@Test
	public void single(){
		int[] a={1};
		int reponse= frogRiverOne.solution(1, a);
		assertEquals(0,reponse);
	}
	@Test
	public void simple(){
		int[] a={5,5,5,5,5};
		int reponse= frogRiverOne.solution(5, a);
		assertEquals(-1,reponse);
	}
	@Test
	public void normal(){
		int[] a={2,5,4,1,6,8,2,3,7,4,1,2,12,4,7,9,10,11,13};
		int reponse= frogRiverOne.solution(13,a);
		assertEquals(18,reponse);
	}
	@Test
	public void extremFrog(){
		int[]a=new int [100000];
		for (int i = 0; i < a.length; i++) {
			a[i]=i+1;
		//	System.out.println(a[i]+" "+i);
		}
		int reponse= frogRiverOne.solution(100000,a);
		assertEquals(99999,reponse);
	}
	@Test
	public void extremFrogInverse(){
		int[]a=new int [100000];
		for (int i = 0; i < a.length; i++) {
			a[i]=i+1;
		//	System.out.println(a[i]+" "+i);
		}
		int reponse= frogRiverOne.solution(100000,a);
		assertEquals(99999,reponse);
	}
	@Test
	public void smallRandom1(){
		boolean[] nb=new boolean[3];
		ArrayList<Integer> list=new ArrayList<Integer>();
		boolean tout=false;
		while(!tout){
	
			int val=(int)(Math.random()*nb.length);
			list.add(val);
			nb[val]=true;
			tout=true;
			for (int i = 0; i < nb.length; i++) {
				if(!nb[i]){
					tout=false;
					break;
				}
			}
		}
		int [] a=new int[list.size()];
		for (int i = 0; i < a.length; i++) {
			a[i]=list.get(i)+1;
		}
		int x=a.length-1;
		assertEquals(x,frogRiverOne.solution(nb.length, a));
	}
	@Test
	public void permut(){
		int[]a={1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i < 39; i++) {
			int G=(int)(Math.random()*9);
			int H=(int)(Math.random()*9);
			int temp=0;
			temp=a[G];
			a[G]=a[H];
			a[H]=temp;
		//	System.out.println(a[i]+" "+i);
		}
		int x=a.length;
		int reponse= frogRiverOne.solution(x,a);
		assertEquals(x-1,reponse);
	}
}
