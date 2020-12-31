public class Main {
    public static void main(String[] args) {
        test3();
    }

    static void test1() {
        int[] array = {44,10,11,23,55,34,35};
        int index = 1;
        for (int end = array.length - 1; end > 0 ; end--) {
            System.out.println(index);
            index++;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin-1] > array[begin]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin-1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "_");
        }
    }
    //如果数组已经是完全有序的优化
    static void test2() {
        int[] array = {44,10,11,23,55,34,35};
        int index = 1;
        for (int end = array.length - 1; end > 0 ; end--) {
            System.out.println(index);
            index++;
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin-1] > array[begin]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin-1] = temp;
                    //如果进了if判断，那就不是有序的,需要做交换
                    sorted = false;
                }
            }
            //如果是有序的，就结束循环
            if (sorted) break;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "_");
        }
    }

    //如果数组已经是部分有序的优化
    static void test3() {
        int[] array = {44,10,11,23,55,34,35};
        int index = 1;
        for (int end = array.length - 1; end > 0 ; end--) {
            System.out.println(index);
            index++;
            //sortedIndex 的初始值在数组完全有序是有用，完全有序，直接结束循环
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin-1] > array[begin]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin-1] = temp;
                    //记录数组尾部，部分有序数组的第一个元素的索引
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "_");
        }
    }
    //选择排序
    static void test4() {
        int[] array = {44,10,11,23,55,34,35};
        for (int end = array.length - 1; end > 0 ; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[maxIndex] <= array[begin]) {
                    maxIndex = begin;
                }
            }
            int temp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "_");
        }
    }
}
