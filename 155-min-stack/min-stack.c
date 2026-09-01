


typedef struct {
    int *stack;
    int *minStack;
    int top;
    int capacity;
    
} MinStack;


MinStack* minStackCreate() {
    MinStack* obj = (MinStack*)malloc(sizeof(MinStack));

    obj->capacity = 30000;
    obj->top = -1;

    obj->stack = (int*)malloc(obj->capacity * sizeof(int));
    obj->minStack = (int*)malloc(obj->capacity * sizeof(int));

    return obj;
    
}

void minStackPush(MinStack* obj, int value) {
     obj->top++;

    obj->stack[obj->top] = value;

    if (obj->top == 0) {
        obj->minStack[obj->top] = value;
    } else {
        int currentMin = obj->minStack[obj->top - 1];

        if (value < currentMin)
            obj->minStack[obj->top] = value;
        else
            obj->minStack[obj->top] = currentMin;
    }
    
}

void minStackPop(MinStack* obj) {
    obj->top--;
    
}

int minStackTop(MinStack* obj) {
    return obj->stack[obj->top];
    
}

int minStackGetMin(MinStack* obj) {
    return obj->minStack[obj->top];
    
}

void minStackFree(MinStack* obj) {
    free(obj->stack);
    free(obj->minStack);
    free(obj);
    
}

/**
 * Your MinStack struct will be instantiated and called as such:
 * MinStack* obj = minStackCreate();
 * minStackPush(obj, value);
 
 * minStackPop(obj);
 
 * int param_3 = minStackTop(obj);
 
 * int param_4 = minStackGetMin(obj);
 
 * minStackFree(obj);
*/