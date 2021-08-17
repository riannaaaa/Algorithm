package 剑指;

import java.util.Stack;

public class offer09{
    /*
    * 用两个栈实现队列
    */
    //笔记：stack都有什么方法？反思：push pop add...
    //     分类四种情况就行（两个stack空or非空）
    class CQueue {
        public CQueue() {
        }
        Stack first = new Stack();
        Stack second = new Stack();
        public void appendTail(int value) {
            first.add(value);
        }
        public int deleteHead() {
            int num =0;
            if(first.empty()&& second.empty()){ return -1;}
            else if(!first.empty()&&second.empty()){
                while (!first.empty()){
                    num = ( int )first.pop();
                    second.push(num);
                }
            }
            num =(int) second.pop();
            return num;
        }
    }
 /* Your CQueue object will be instantiated and called as such:
  CQueue obj = new CQueue();
  obj.appendTail(value);
  int param_2 = obj.deleteHead();
 */
}
