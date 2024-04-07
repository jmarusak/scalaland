package com.maly.scalaland

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.scalactic.{Equality, TolerantNumerics, TypeCheckedTripleEquals}

class SimulatePlanIT extends AnyWordSpec with Matchers with TypeCheckedTripleEquals {

  implicit val doubleEquality: Equality[Double] =
    TolerantNumerics.tolerantDoubleEquality(0.0001)
  
  "SimulatePlanApp.strMain" should {
    "calculate capital at retirement and at death" in {
      val prompt = "0.04 25 40 3000 2000 10000".split(" ").toArray
      val (capitalAtRetirement, capitalAfterDeath) = SimulatePlanApp.strMain(prompt)

      capitalAtRetirement should ===(541267.1990)
      capitalAfterDeath should ===(309867.5316)
    }
  }
}