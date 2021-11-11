package QueueAndStack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，
 * 并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 */
public class minStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if(!minStack.isEmpty()){
            if(minStack.peek() > node){
                minStack.push(node);
            }else{
                minStack.push(minStack.peek());
            }
        }else{
            minStack.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
