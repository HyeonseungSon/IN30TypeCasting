/*
test 입니다. Branch 이름 변경 test 입니다.

Type Casting (형변환)
 - 변수에 담긴 값이나 객체를 다른 형태로 변환하는 것을 의미합니다.
 - Kotlin 은 모든 값을 객체로 관리하기 때문에 Kotlin 에서의 형변환은 다른 Class Type 의 객체로 변환하는 것을 의미합니다.
 - 자식 Class Type 으로의 변환
 - 부모 Class Type 으로의 변환
 - 다른 자료현 Type 으로의 변환
 - null 허용과 null 불허용 간의 변환

 Smart Casting
  - 특정 조건을 만족하면 자동으로 형변환이 발생하는 개념입니다.
  - Smart Casting 기능 덕분에 형변환에 대해 개발자가 크게 신경쓰지 않아도 됩니다.
  - 형변환은 객체의 Class Type 이 아닌 객체의 주솟값을 가지고 있는 참조 변수의 Type 이 변경되는 것입니다.

객체 Type 변환
 - 객체의 Type 변환은 상속관계나 구현한 Interface Type 에 해당합니다.
 - 부모 Class Type 으로의 형변환
 - 자식 Class Type 으로의 형변환
 - 구현한 Interface Type 으로의 형변환
 - Interface 를 구현한 Class Type 으로의 형변환

as 연산자
 - 객체를 지정된 Class 형태로 변환하는 연산자입니다.
 - 참조변수 as Class Type
 - 만약 객체가 지정된 Class Type 과 관계가 없을 경우 오류가 발생됩니다.
 - 형변환이 발생한 참조 변수는 변환된 Type 을 유지합니다.

is 연산자
 - 형변환이 가능하다면 변환을 하고 true 를 반환합니다.
 - if 문으로 구성하여 사용하면 if 내에서만 변환된 Type 을 사용하고
  if 문을 벗어나면 변환되기 전의 Type 으로 다시 변경됩니다.

Any Type
 - Kotlin 은 모든 Class 가 직접 혹은 간접적으로 Any Class 를 상속받습니다.
 - 따라서 모든 객체의 주솟값은 Any Type 참소 변수에 담을 수 있습니다.
 - Any Type 과 is 연산자를 활용하여 다양한 Type 의 객체에 대응할 수 있는 Code 를 만들 수 있습니다.

기본 Type 의 형변환
 - Kotlin 에서는 기본 Type 을 관리하는 객체의 Type 을 변경하는 Method 를 제공합니다.
 - 참조 변소의 Type 이 변경되는 것이 아닌 새로운 객체가 생성되어 반환됩니다.
 - toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar()
 */

fun main() {

    val obj1:SubClass1 = SubClass1()
    val obj2:SubClass2 = SubClass2()

    /*
    Smart Casting 발생 (자식 Class 형에서 부모 Class 형으로 형변환 발생)
     - 부모 Class (SuperClass1) Type 의 참조변수 (super1) 에 SubClass1 객체 (obj1) 를 담았습니다.
     - SubClass1 Type 의 obj1 은 자동으로 형변환이 발생되어 SuperClass1 Type 의 참조변수인 Super1 에 담겨졌습니다.
     */
    val super1:SuperClass1 = obj1 // obj1 : SubClass1 (Type : SuperClass1 을 상속받은 자식 Class)

    /*
    Smart Casting 발생
     : Inter1 Interface 를 구현한 SubClass2 형에서 Inter1 Interface 형으로 형변환 발생 )
     */
    val inter1:Inter1 = obj2 // obj2 : SubClass2 (Type : Inter1 을 구현한 Class)

    /*
    (아래 내용이 맞는지 잘 모르겠습니다.)
    obj1 은 SubClass1 을 객체화한 Property 입니다.
    super1 의 Type 은 SuperClass1 이며, SubClass1 을 객체화한 obj1 을 객체화한 Property 입니다.
    obj3 은 SubClass1 을 객체화한 또다른 Property 입니다.
    obj1 과 obj3 는 같은 SubClass1 를 객체화하였습니다. Type 또한 동일합니다.
    하지만 엄연히 다른 객체입니다.
    그렇기에 obj1 을 객체화한 SuperClass1 Type 의 super1 이 또 다른 객체인 obj3 에 객체화 될 수 없는 것입니다.
    아래 Interface 또한 같은 이유로 객체화가 불가능합니다.
    Type 은 같지만 다른 객체입니다.
     */
    // 부모 Class 는 자식 Class 에 객체화를 할 경우 자동으로 형변환이 발생되지 않습니다.
    // val obj3:SubClass1 = super1 // 오류 발생
    // Interface 는 Interface 를 구현한 Class 에 객체화를 할 경우 자동으로 형변환이 발생되지 않습니다.
    // val obj4:SubClass2 = inter1 // 오류 발생

    println("------------------------------")

    /*
    super1 은 자식 Class 인 SubClass1 로 생성한 객체의 주솟값이 들어가 있습니다.
    하지만 super1 객체 자체는 부모 Class 인 SuperClass1 Type 으로 객체화 되어 있기 때문에
    접근할 수 있는 범위는 부모 Class 인 SuperClass1 의 범위 까지 입니다.
    그래서 자식 Class 의 내부에 생성된 subMethod1 에는 접근할 수 없습니다.
    Interface 또한 같은 이유입니다.
    =>  요약 : 부모 Type 의 Class 는 부모 Class 의 영역에만 접근할 수 있습니다.
    그래서 자식 Class 내부에 생성된 subMethod1 에는 접근할 수 없습니다.
     */
    // super1.subMethod1()
    // inter1.subMethod2()

    // as : 지정된 Class Type 으로 강제 형변환하는 연산자
    super1 as SubClass1
    inter1 as SubClass2

    // as 연산자를 이용하여 Type 을 강제 변환하였습니다. 형변환으로 자식 Class 에 접근이 가능합니다.
    super1.subMethod1()
    inter1.subMethod2()

    /*
    어떠한 관계 (상속 또는 구현 등) 도 없는 Class 간에는 형변환이 불가능합니다.
     */
    // inter1 as SubClass1

    println("------------------------------")

    val obj3:SubClass1 = SubClass1()

    val chk1 = obj3 is SuperClass1
    println("chk1 : $chk1") // 출력값 : true

    // 형이 맞지 않기 때문에 오류가 발생합니다.
    // val chk2 = obj3 is Inter1

    val super3:SuperClass1 = obj3
    val chk3 = super3 is SubClass1
    println("chk3 : $chk3") // 출력값 : true

    /*
    is 연산자는 형변환이 가능한지 확인하는 연산자 입니다.
    형변환을 진행하는 연산자는 아닙니다. (as 연산자는 형변환을 진행합니다.)
    그래서 super3 의 Type 은 아직 SuperClass1 입니다.
    따라서 자식 Class 의 내부에 구현된 subMethod 를 실행할 수 없습니다.
     */
    // super3.subMethod1()

    if(super3 is SubClass1){
        // super3 as SubClass1 // as 연산자가 없어도 if 문 내부에서는 형변환이 발생된 상황이기 때문에 정상 출력이 가능합니다.
        // is 연산자 값이 true 라면 형변환이 가능한 상황이므로 Smart Casting 발생
        super3.subMethod1()
    }
    // if 문을 벗어나게 되면 Smart Casting 이 자동해제 되므로 아래 코드는 실행될 수 없습니다.
    // super3.subMethod1()

    println("------------------------------")

    val obj10:SubClass1 = SubClass1()
    val obj11:SubClass2 = SubClass2()

    anyMethod(obj10)
    anyMethod(obj11)
    anyMethod(100)
    anyMethod("문자열")

    println("------------------------------")

    val number1:Int = 100
    val number2:Long = number1.toLong()
    println("number2 : $number2")

    val str1:String = "100"
    val number3:Int = str1.toInt()
    println("number3 : $number3")

    // String 형에서 Int 형으로 변환은 불가능합니다. 오류가 발생됩니다.
    //val str2:String = "안녕하세요"
    //val number4:Int = str2.toInt()
    //println("number4 : $number4")
}

open class SuperClass1
interface Inter1

class SubClass1 : SuperClass1() {
    fun subMethod1() {
        println("SubClass1 의 subMethod1 입니다.")
    }
}
class SubClass2 : Inter1 {
    fun subMethod2() {
        println("SubClass2 의 subMethod2 입니다.")
    }
}
fun anyMethod(obj:Any){
    if(obj is SubClass1){
        obj.subMethod1()
    } else if(obj is SubClass2){
        obj.subMethod2()
    } else if(obj is Int){
        println("정수입니다")
    } else if(obj is String){
        println("문자열 입니다")
    }
}















