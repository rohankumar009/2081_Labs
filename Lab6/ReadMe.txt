// Case 2: If the head node needs to be removed
if (head.getIndex() == index) {
    head = head.getNext();
    return;
}

To remove the head node, we simply update the head pointer to point to the next node in the list
(i.e., head.getNext()). This effectively removes the current head node from the list,
and the next node becomes the new head.






// Case 3: Removing a non-head node
Node current = head;
Node previous = null;

while (current != null) {
    if (current.getIndex() == index) {
        previous.setNext(current.getNext());
        return;
    }

    previous = current;
    current = current.getNext();
}

This case handles the scenario where the node to be removed is not the head node.
We need to traverse the linked list to find the node with the specified index and remove it.

We initialize two pointers: current and previous. The current pointer starts at the head node,
and the previous pointer is initially set to null.

We then iterate through the linked list using a while loop, moving the current pointer forward until
we find the node with the specified index or reach the end of the list.

Inside the loop, we check if the index of the current node matches the specified index. If it does,
we update the next pointer of the previous node to skip over the current node,
effectively removing it from the list. We do this by setting previous.setNext(current.getNext()).
This line updates the next pointer of the previous node to point to the node after the current node,
 essentially removing the current node from the list.
