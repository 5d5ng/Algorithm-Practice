package programmers;

import java.util.Arrays;
import java.util.Stack;

public class 기능개발 {

	public static void main(String[] args) {
		기능개발 app = new 기능개발();
		int [] p = {93,30,55};
		int [] sp = {1,30,5};
		int []res = app.solution(p, sp);
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}

	public int[] solution(int[] progresses, int[] speeds) {
		int limit = progresses.length;
		int[] answer = new int[limit];
		int [] done = new int [limit];
		int index = 0, cnt =0;
		Stack<Integer> stack = new Stack<>();

		while(!isFinish(done)) {

			for(int i=limit-1 ;i>=0;i--) {
				stack.add(i);		
				progresses[i] += speeds[i];


			}
			while(!stack.isEmpty() && progresses[stack.peek()]>=100) {
				if(done[stack.peek()]==0)
					cnt++;
				done[stack.pop()]=1;
			}

			stack.clear();
			if(cnt!=0) answer[index++]=cnt;

			cnt = 0;
		}
		
		int [] ans = Arrays.stream(answer).filter(i->i!=0).toArray(); 
//		= new int[index];
//		for(int i=0;i<index;i++) {
//			ans[i] = answer[i];
//		}
		return ans;
	}
	boolean isFinish(int [] done) {
		for(int i=0;i<done.length;i++) {
			if(done[i]==0) return false;
		}
		return true;
	}


}
