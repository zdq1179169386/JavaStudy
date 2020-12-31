package Sort;

public abstract class Sort {
    protected Integer[] array;
    protected int cmpCount;//比较次数
    protected int swapCount;//交换次数

    public void sort(Integer[] array) {
        if (array == null || array.length <= 2) return;
        this.array = array;
        sort();
    }
    protected abstract void sort();

    //比较两个索引
    protected int cmp(int i1,int i2) {
        cmpCount++;
        return array[i1] - array[i2];
    }
    //比较两个元素
    protected int cmpElement(Integer v1,Integer v2) {
        cmpCount++;
        return v1 - v2;
    }
    //交换
    protected void swap(int i1,int i2) {
        swapCount++;
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
