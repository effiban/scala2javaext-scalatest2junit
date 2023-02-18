package io.github.effiban.scala2javaext.scalatest.transformers

import io.github.effiban.scala2java.spi.transformers.TermApplyInfixToTermApplyTransformer
import io.github.effiban.scala2javaext.scalatest.classifiers.ScalatestMatcherVerbClassifier
import io.github.effiban.scala2javaext.scalatest.transformers.assertions.matchers.MatcherAssertionTransformer

import scala.meta.Term

private[transformers] class ScalatestTermApplyInfixToTermApplyTransformerImpl(matcherAssertionTransformer: MatcherAssertionTransformer,
                                                                              matcherVerbClassifier: ScalatestMatcherVerbClassifier)
  extends TermApplyInfixToTermApplyTransformer {

  override def transform(termApplyInfix: Term.ApplyInfix): Option[Term.Apply] = {
    import matcherVerbClassifier._
    termApplyInfix match {
      case Term.ApplyInfix(actual, verb, _, List(matcher)) if isMatcherVerb(verb) => matcherAssertionTransformer.transform(actual, verb, matcher)
      case _ => None
    }
  }
}

object ScalatestTermApplyInfixToTermApplyTransformer extends ScalatestTermApplyInfixToTermApplyTransformerImpl(
  MatcherAssertionTransformer,
  ScalatestMatcherVerbClassifier
)
