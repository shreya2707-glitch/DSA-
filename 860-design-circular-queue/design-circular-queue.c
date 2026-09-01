#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int *queue;
    int front;
    int rear;
    int size;
    int capacity;
} MyCircularQueue;

MyCircularQueue* myCircularQueueCreate(int k) {
    MyCircularQueue* obj = malloc(sizeof(MyCircularQueue));

    obj->queue = malloc(k * sizeof(int));
    obj->front = 0;
    obj->rear = 0;
    obj->size = 0;
    obj->capacity = k;

    return obj;
}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value) {
    if (obj->size == obj->capacity)
        return false;

    obj->queue[obj->rear] = value;
    obj->rear = (obj->rear + 1) % obj->capacity;
    obj->size++;

    return true;
}

bool myCircularQueueDeQueue(MyCircularQueue* obj) {
    if (obj->size == 0)
        return false;

    obj->front = (obj->front + 1) % obj->capacity;
    obj->size--;

    return true;
}

int myCircularQueueFront(MyCircularQueue* obj) {
    if (obj->size == 0)
        return -1;

    return obj->queue[obj->front];
}

int myCircularQueueRear(MyCircularQueue* obj) {
    if (obj->size == 0)
        return -1;

    return obj->queue[(obj->rear - 1 + obj->capacity) % obj->capacity];
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj) {
    return obj->size == 0;
}

bool myCircularQueueIsFull(MyCircularQueue* obj) {
    return obj->size == obj->capacity;
}

void myCircularQueueFree(MyCircularQueue* obj) {
    free(obj->queue);
    free(obj);
}

/*
Comments / Explanation:

1. queue stores all the elements in an array.

2. front points to the first element of the queue.

3. rear points to the next empty position where a new
   element will be inserted.

4. size stores the current number of elements.

5. capacity stores the maximum size of the queue.

6. In enQueue(), if the queue is full, return false.
   Otherwise insert the value at rear and move rear forward.

7. In deQueue(), if the queue is empty, return false.
   Otherwise move front forward and decrease size.

8. The % operator makes the queue circular:
      rear = (rear + 1) % capacity
      front = (front + 1) % capacity

9. Rear() uses:
      (rear - 1 + capacity) % capacity
   because rear always points to the next empty position.

10. isEmpty() checks if size == 0.

11. isFull() checks if size == capacity.

Time Complexity:
   enQueue()  -> O(1)
   deQueue()  -> O(1)
   Front()    -> O(1)
   Rear()     -> O(1)
   isEmpty()  -> O(1)
   isFull()   -> O(1)

Space Complexity:
   O(k)
*/