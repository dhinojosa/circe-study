import org.scalatest.{FunSuite, Matchers}
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

class JSONEncodingSpec extends FunSuite with Matchers {
  test("Case 1: Basic JSON creation with Parsing") {
    val ca = new ConcreteA(40, 12.4f)
    val json = ca.asJson
    println(json)
  }

  test("Case 2: Basic JSON List Creation") {
    val caList = List(new ConcreteA(10, 5.4f),
      new ConcreteA(10, 0.1f),
      new ConcreteA(2, 11.4f))

    val result = caList.asJson
    val expected = """[
                     |  {
                     |    "a" : 10,
                     |    "b" : 5.4
                     |  },
                     |  {
                     |    "a" : 10,
                     |    "b" : 0.1
                     |  },
                     |  {
                     |    "a" : 2,
                     |    "b" : 11.4
                     |  }
                     |]""".stripMargin

    result.toString should be (expected)
  }

  test("""Case 3: Basic JSON with primitives and List with a
      | no space rendering""") {
    val intList = List(1,2,3,4)
    val result = intList.asJson.noSpaces
    result should be ("[1,2,3,4]")
  }
}
