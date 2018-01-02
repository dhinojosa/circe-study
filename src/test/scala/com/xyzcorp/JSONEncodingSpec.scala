/*
 * Copyright (c) 2018 Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 * Author: Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.xyzcorp

import io.circe.generic.auto._
import io.circe.syntax._
import org.scalatest.{FunSuite, Matchers}

class JSONEncodingSpec extends FunSuite with Matchers {
  test("Case 1: Basic JSON creation with Parsing") {
    val ca = new ConcreteA(40, 12.4f)
    val json = ca.asJson
    json.toString() should be ("""{
                                 |  "a" : 40,
                                 |  "b" : 12.4
                                 |}""".stripMargin)
  }

  test("Case 2: Basic JSON List Creation") {
    val caList = List(new ConcreteA(10, 5.4f),
      new ConcreteA(10, 0.1f),
      new ConcreteA(2, 11.4f))

    val result = caList.asJson
    val expected =
      """[
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

    result.toString should be(expected)
  }

  test(
    """Case 3: Basic JSON with primitives and List with a
      | no space rendering""") {
    val intList = List(1, 2, 3, 4)
    val result = intList.asJson.noSpaces
    result should be("[1,2,3,4]")
  }
}
