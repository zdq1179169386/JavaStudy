package Sort;

public class HeapSort extends Sort {
    private int heapSize;
    @Override
    protected void sort() {
        //原地建堆
        heapSize = array.length;
        for (int i = (heapSize>>1) - 1; i >= 0 ; i--) {
            siftDown(i);
        }
        while (heapSize > 1){
            //交换第一个和最后一个的元素
            swap(0,heapSize - 1);
            //size 减 1
            heapSize--;
            //对索引 0 的元素进行下滤
            siftDown(0);
        }
    }
    //下滤
    private void siftDown(int index) {
        Integer element = array[index];
        int half = heapSize >> 1;
        while (index < half) { // index必须是非叶子节点
            // 默认是左边跟父节点比
            int childIndex = (index << 1) + 1;
            Integer child = array[childIndex];

            int rightIndex = childIndex + 1;
            // 右子节点比左子节点大
            if (rightIndex < heapSize &&
                    cmpElement(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }

            // 大于等于子节点
            if (cmpElement(element, child) >= 0) break;
            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }
}
