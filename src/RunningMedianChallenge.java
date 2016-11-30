/**
 * Created by Marc on 2016-11-26.
 */
/*
Context & Instructions:
Given an input stream of n integers, you must perform the following task
for each i-th integer:
1. Add the i-th integer to a running list of integers.
2. Find the median of the updated list (i.e., for the first element
through the i-th element).
3. Print the list's updated median on a new line. The printed value must
be a double-precision number scaled to 1 decimal place (i.e., 12.3 format).

Input Format:
The first line contains a single integer, n, denoting the number of
integers in the data stream. Each line i of the n subsequent lines contains
an integer, Ai, to be added to your list.

Output Format:
After each new integer is added to the list, print the list's updated
median on a new line as a single double-precision number scaled to 1
decimal place (i.e., 12.3 format).

Constraints:
1 <= n <= 10^5
0 <= Ai <= 10^5

Input/Output Sample:
6
12  -> 12.0
4   -> 8.0
5   -> 5.0
3   -> 4.5
8   -> 5.0
7   -> 6.0
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedianChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();
        int n = in.nextInt();
        for (int a_i = 0; a_i < n; a_i++) {
            // do printing here of running median

            // this just ensures we alternate between insertions
            if((a_i & 1) != 1){
                maxHeap.add(in.nextInt());

            } else {
                minHeap.add(in.nextInt());
            }

            if(a_i >= 1 && maxHeap.peek() > minHeap.peek()){
                int topMax = maxHeap.poll();
                int topMin = minHeap.poll();
                maxHeap.add(topMin);
                minHeap.add(topMax);
            }

            // this indicates we've inserted into maxheap, thus we have odd amount of elements
            if((a_i & 1) != 1){
                System.out.println(maxHeap.peek() / 1.0);
            }
            // case where we have even number of elements
            else {
                System.out.println( (maxHeap.peek() + minHeap.peek()) / 2.0);
            }


            /*** Initial solution - not efficient ***
             Arrays.sort(a, 0, a_i+1);
             // if odd, since array index starts at 0, we would have an even amount of #,
             // thus need to get average of two elements in middle
             if((a_i & 1) == 1){
             System.out.println((a[a_i/2] + a[(a_i/2)+1])/2.0);
             }
             else {
             System.out.println(a[a_i/2]/1.0);
             }
             */
        }
    }
}

    // Heap data structures used for solution
    abstract class Heap{
        int capacity;
        int size;
        int[] items;

        Heap(){
            this.capacity = 10;
            this.size = 0;
            this.items = new int[capacity];
        }

        public int getLeftChildIndex(int parentIndex){  // for index 1, LC is 3
            return (parentIndex * 2) + 1;
        }

        public int getRightChildIndex(int parentIndex){ // for index 1, RC is 4
            return (parentIndex * 2) + 2;
        }

        public int getParentIndex(int childIndex){ // for index 3 & 4, parent is 1
            return (childIndex - 1) / 2;
        }

        public boolean hasLeftChild(int parentIndex){
            return getLeftChildIndex(parentIndex) < size;
        }

        public boolean hasRightChild(int parentIndex){
            return getRightChildIndex(parentIndex) < size;
        }

        public boolean hasParent(int childIndex){
            return getParentIndex(childIndex) >= 0;
        }

        public int getLeftChild(int parentIndex){
            return items[getLeftChildIndex(parentIndex)];
        }

        public int getRightChild(int parentIndex){
            return items[getRightChildIndex(parentIndex)];
        }

        public int getParent(int childIndex){
            return items[getParentIndex(childIndex)];
        }

        public int peek(){
            isEmpty("peek()");
            return items[0];
        }

        public int poll(){
            isEmpty("poll()");
            int temp = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return temp;
        }

        public void swap(int indexOne, int indexTwo){
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }

        public void add(int element){
            ensureCapacity();
            items[size] = element;
            size++;
            heapifyUp();
        }

        public void ensureCapacity(){
            if(size == capacity){
                capacity = capacity * 2;
                items = Arrays.copyOf(items, capacity);
            }
        }

        public void isEmpty(String methodName){
            if(size == 0){
                throw new IllegalStateException("Cannot perform " + methodName + " on empty heap");
            }
        }

        public abstract void heapifyDown();
        public abstract void heapifyUp();
    }


    class MaxHeap extends Heap {

        public void heapifyDown() {
            // while left child exist and a child is bigger than parent, swap with the smallest of the child that is bigger than parent
//            isEmpty("heapifyDown()");
            if(this.size > 0) {
                int currentIndex = 0;
                while (hasLeftChild(currentIndex)) {
                    int biggerChildIndex = getLeftChildIndex(currentIndex);

                    if (hasRightChild(currentIndex) && getRightChild(currentIndex) > getLeftChild(currentIndex)) {
                        biggerChildIndex = getRightChildIndex(currentIndex);
                    }

                    if (items[currentIndex] > items[biggerChildIndex]) {
                        break;
                    } else {
                        swap(currentIndex, biggerChildIndex);
                    }
                    currentIndex = biggerChildIndex;
                }
            }
        }


        public void heapifyUp() {
            // while parent exist and is smaller than child, swap
            int index = size - 1;
            while(hasParent(index) && getParent(index) < items[index]){
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
    }


    class MinHeap extends Heap {

        public void heapifyDown(){
            // while left child exist and a child is smaller than parent, swap with the smallest child
            if(this.size > 0) {

                int currentIndex = 0;
                while (hasLeftChild(currentIndex)) {
                    int smallerChildIndex = getLeftChildIndex(currentIndex);

                    if (hasRightChild(currentIndex)
                            && getRightChild(currentIndex) < getLeftChild(currentIndex)
                            ) {
                        smallerChildIndex = getRightChildIndex(currentIndex);
                    }

                    if (items[currentIndex] < items[smallerChildIndex]) {
                        break;
                    } else {
                        swap(currentIndex, smallerChildIndex);
                    }
                    currentIndex = smallerChildIndex;
                }
            }
        }

        public void heapifyUp(){
            // while parent exist and is bigger than child, swap
            int index = size - 1;
            while( hasParent(index) && getParent(index) > items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
    }
