import org.scalatest.{FunSuite, Matchers}
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

class JSONEncodingSpec extends FunSuite with Matchers {
  test("Basic JSON creation with Parsing") {
    val ca = new ConcreteA(40, 12.4f)
    val json = ca.asJson
    println(json)
  }

  test("Basic JSON List Creation") {
    val caList = List(new ConcreteA(10, 5.4f),
      new ConcreteA(10, 0.1f),
      new ConcreteA(2, 11.4f))
    val json = caList.asJson
    println(json)
  }
}
