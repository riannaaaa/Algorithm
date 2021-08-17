import java.util.*

//fun main(args: Array<String>){ println("Hello World!")}

fun main(args: Array<String>) {
//    Test2()
//    var charA: Char = 'a'
//    var charB: Char = 'B'
//    var charNum: Char = '1'
//    var result: Char
//    var arrayListTwo = arrayOf(1,3,5,7,9)
//    println(arrayListTwo.withIndex())
//    val a = 1
//    val b = 5
//    printNumbers(2)
// 操作符实现
//    val s = 3 in a .. b     // true,因为3在区间[1,5]之内
//    println("s = $s")
//    for (index in a .. b){
//        print("index = $index \t")
//    }

// 操作符重载方式实现
//    val t = 3 in a.rangeTo(b) //true,因为3在区间[1,5]之内
//    println("t = $t")
//    for (index in a.rangeTo(b)){
//        print("index = $index \t")
//    }
//    var intarr = intArrayOf(2,3,4)
//    var arrTest:Array<Int?> = arrayOf(1,2,null,3,null,5,6,null)
//    println(twoSum(intarr ,7))
    var obj = CQueue()
    println(obj.appendTail(5))
    println(obj.appendTail(2))
    println(obj.deleteHead())
    println(obj.deleteHead())

}

//    fun twoSum(nums: IntArray, target: Int): IntArray {
//        var map = Hashtable<Int,Int>()
//        for (i in nums.indices){//0,1,2
//            if (map.containsValue((target-nums[i])))//3,2,1
//            {   var a = nums.indexOf((target-nums[i]))//
//                return intArrayOf(a as Int,i)}
//            map.put(i,nums[i])//index,value
//        }
//
//        return intArrayOf(0,0) //IntArray Array<Int>
//    }


fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashTable = Hashtable<Int, Int>()
    for(i in nums.indices){
        if(hashTable.containsKey(target - nums[i])) {
            return intArrayOf(hashTable[target - nums[i]] as Int, i)
        }
        println(hashTable[nums[i]])
        hashTable[nums[i]] = i
    }
    return intArrayOf(-1, -1)

}
fun replaceSpace(s: String): String {
    var string = StringBuilder()
    for (c in s) {
        if (c==' '){
            string.append("%20")
        }
        else string.append(c)
    }
    return string.toString()
}
fun printNumbers(n: Int): IntArray {
    val power =Math.pow(10.0, n.toDouble())-1
    val arr = IntArray(power.toInt())
    var index = 0
    while (index<=power){
        arr[index]=index+1
        index++
    }
    return arr
}//


fun fib(n: Int): Int {
    val first = 0
    val second = 1
    val arr = arrayOfNulls<Int>(n+1)
    for (i in arr){
//        arr[i]=  arr[i-1]+arr[i-2] as Int
    }
    return 0
}
class CQueue() {
    val s_in =  Stack<Int>()
    val s_out =  Stack<Int>()
    fun appendTail(value: Int) {
        s_in.push(value)

    }

    fun deleteHead(): Int {
        if(s_out.empty()){
            if(s_in.empty())
                return -1

            for (index in 0..s_in.size-1){
                var one = s_in.pop()
                println(one)
                s_out.push(one)
            }
        }
        var o = s_out.pop()
        return o

    }
}



fun check(c: Char) : Int {
    val a:Int = 88
    println(c.toInt())
    if (c.toInt() == 88) { // 错误：类型不兼容
        println(a.toChar())
    }
    return 5
}
class Test2{

    // 声明可空变量

    var var_a : Int? = 0
    val vala : Int? = null
    var charA: Char = 'a'
    var result: Char = '\u0000'

    init {
        var_a = 10 shl(2)
        // val_a = 0 为val类型不能更改。

        println("var_a => $var_a \t  ")
    }
    var array1= arrayOfNulls<Int>(3)
    var arrayListTwo = arrayOf(1,3,5,7,9)

}


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
