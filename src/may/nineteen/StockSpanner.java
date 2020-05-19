package may.nineteen;

import java.util.Stack;

class StockSpanner {
    Stack<Integer> prices, spans;
    public StockSpanner() {
        prices = new Stack<Integer>();
        spans = new Stack<Integer>();
    }
    
    public int next(int price) {
        int s = 1;
        
        while(!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            s = s + spans.pop();
        }
        
        prices.push(price);
        spans.push(s);
        return s;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */