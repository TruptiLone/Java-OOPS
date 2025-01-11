//Arrays can be return type
/* A method that returns an array object
 * @param flag A boolean value for which array to return
 * @returns An integer Array object
 *
 */
public class ArrayReturn {
    public int[] returnsArray(boolean flag){
        int[] array1 = {1,2,3,4,5,6,7,8,9,10};
        int[] array2 = {10,20,30,40,50};
        if(flag){
            return array1;
        }else {
            return array2;
        }
    }

    public static void main(String[] args) {
        ArrayReturn a = new ArrayReturn();
        System.out.println(a.returnsArray(true).length);
        System.out.println(a.returnsArray(false).length);

    }

}
/* x object type of calss ArrayReturns
returnsArray method of class that return array either array1 or array2
a.returnsArray(true).length : returning array length
 */