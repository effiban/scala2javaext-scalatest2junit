package io.github.effiban.scala2javaext.scalatest.transformers

import io.github.effiban.scala2java.test.utils.matchers.CombinedMatchers.eqTreeList
import io.github.effiban.scala2javaext.scalatest.testsuites.UnitTestSuite
import org.mockito.ArgumentMatchersSugar.eqTo

import scala.meta.{XtensionQuasiquoteInit, XtensionQuasiquoteTerm}

class ScalaTest2JUnitFileNameTransformerTest extends UnitTestSuite {

  private val classNameTransformer = mock[ClassNameTransformer]

  private val fileNameTransformer = new ScalaTest2JUnitFileNameTransformer(classNameTransformer)

  test("transform") {
    when(classNameTransformer.transform(eqTo("MySpec"), eqTreeList(List(init"AnyFunSpec")))).thenReturn("MyTest")

    fileNameTransformer.transform("MySpec", List(init"AnyFunSpec")) shouldBe "MyTest"
  }
}
