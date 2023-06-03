package Unidad1;

public class abc 
{
	public void pop() {
        if (this.isEmpty()) {
            System.out.println("La cola esta vacia");
            return;
        }
        if (this.size == 2) {
            this.data[this.size - 1] = null;
            this.downgradeSize();
            return;
        }

        int currentPosition = this.INITIAL_SIZE;
        int lastPosition = this.size - 1;

        PriorityNode lastNode = this.data[lastPosition];

        this.data[currentPosition] = lastNode;
        this.data[lastPosition] = null;

        int leftChildPosition = 2 * currentPosition;
        int rightChildPosition = 2 * currentPosition + 1;

        PriorityNode leftChild = this.data[leftChildPosition];
        PriorityNode rightChild = this.data[rightChildPosition];

        while (rightChild != null || leftChild != null) {
            leftChildPosition = 2 * currentPosition;
            rightChildPosition = 2 * currentPosition + 1;

            leftChild = this.data[leftChildPosition];
            rightChild = this.data[rightChildPosition];

            boolean hasTwoChildren = leftChild != null && rightChild != null;

            if (!hasTwoChildren) break;

            if (leftChild == null) {
                if (!(rightChild.getPriority() < lastNode.getPriority())) {
                    this.data[rightChildPosition] = lastNode;
                    this.data[currentPosition] = rightChild;
                    currentPosition = rightChildPosition;
                    continue;
                }
            }

            if (rightChild == null) {
                if (!(leftChild.getPriority() < lastNode.getPriority())) {
                    this.data[leftChildPosition] = lastNode;
                    this.data[currentPosition] = leftChild;
                    currentPosition = leftChildPosition;
                    continue;
                }
            }


            boolean lastNodeHasMorePriority =
                    lastNode.getPriority() < leftChild.getPriority() &&
                    lastNode.getPriority() < rightChild.getPriority();

            if (lastNodeHasMorePriority) {
                break;
            }

            if (rightChild.getPriority() < leftChild.getPriority()) {
                this.data[rightChildPosition] = lastNode;
                this.data[currentPosition] = rightChild;
                currentPosition = rightChildPosition;

                continue;
            }

            this.data[leftChildPosition] = lastNode;
            this.data[currentPosition] = leftChild;
            currentPosition = leftChildPosition;
        }

        this.downgradeSize();

    }
}
