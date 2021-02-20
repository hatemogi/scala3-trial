import org.junit.Test
import org.junit.Assert._
import cats._, cats.implicits._

class EqTest:
  /* cats.Eq[A] :: 같은 타입의 값만 동치 비교 가능 */
  @Test def eq: Unit =
    assertTrue("cats에서는 같은 타입만 허용", 1 === 1)
    assertFalse("기본 ==는 Object끼리의 비교허용", "1" equals 1)

  /* cats.Ord[A] :: 같은 타입의 값끼리만 순서 비교가능 */
  @Test def ord: Unit = 
    assertEquals("cats에서는 같은 타입끼리만 비교 허용", 1 compare 2, -1)
    assertEquals("cats의 min, max에 Ord활용", (1 min 2, 1 max 2), (1, 2))
    assertFalse("기본 비교 연산자는 타입이 달라도 가능", 1 > 2.0)

  /* cats.Show[A] :: 정확히 지정한 타입으로 String 표시 */
  @Test def show: Unit =
    assertEquals("Object.toString과 비슷한 show", 1.show, "1")
    assertEquals("Object.toString과 비슷한 show", "hello".show, "hello")
    assertNotEquals("Object.toString는 타입안정성이 깨짐", (new {}).toString, "hello")

  // Show[Person] 인스턴스 쉽게 만들기 #1
  @Test def easyShow: Unit = 
    case class Person(name: String)
    implicit val personShow = Show.show[Person](_.name)
    assertEquals(Person("Alice").show, "Alice")

  // Show[Person] 인스턴스 쉽게 만들기 #2
  @Test def easyShowFromToString: Unit =   
    case class Car(model: String)
    implicit val carShow = Show.fromToString[Car]
    assertEquals(Car("Avante").show, "Car(Avante)")