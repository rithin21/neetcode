class MinStack {
public:
    vector<int>stack_o;
    stack<int>min_stack;
    MinStack() {
        
        
    }
    
    void push(int val) {
        stack_o.push_back(val);
        if(min_stack.empty())
        {
            min_stack.push(val);
        }
        else
        {
            if(val<=min_stack.top())
            {
                min_stack.push(val);
            }
        }   
    }
    
    void pop() {
        if(stack_o.back()==min_stack.top())
        {
            min_stack.pop();
        }   
        stack_o.pop_back();
        
    }
    
    int top() {
        return stack_o.back();   
    }
    
    int getMin() {
        return min_stack.top();   
    }
};
