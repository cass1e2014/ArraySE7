/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among
 * them, there may exist one celebrity. The definition of a celebrity is that
 * all the other n - 1people know him/her but he/she does not know any of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not
 * one. The only thing you are allowed to do is to ask questions like:
 * "Hi, A. Do you know B?" to get information of whether A knows B. You need to
 * find out the celebrity (or verify there is not one) by asking as few
 * questions as possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B. Implement a function int findCelebrity(n), your function should
 * minimize the number of calls to knows.
 * 
 * Note: There will be exactly one celebrity if he/she is in the party. Return
 * the celebrity‘s label if there is a celebrity in the party. If there is no
 * celebrity, return -1.
 * 
 * @author cassie9082
 * 
 */
public class FindTheCelebrity {
	//Known API
	boolean knows(int a, int b){
		return true;
	}
	
	/*
	 * 遍历数组两次，第一次遍历找到第一个也是最后一个后面元素都认识的candidate,
	 * 第二次遍历确认前面元素都认识这个candidate并且candidate不认识其他任何一个人。
	 */
	public int findCelebrity(int n) {
		int candidate = 0;
		for(int i = 1; i < n; i++){
			if(!knows(i, candidate)){
				candidate = i;
			}
		}
		
		for(int j = 0; j < n; j++){
			if(j != candidate && !knows(j, candidate) || knows(candidate, j)){
				return -1;
			}
		}
		return candidate;
	}
}
