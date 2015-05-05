package shoppingbasket.features

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.AfterClass
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
   features = Array("features"),
   glue = Array("shoppingbasket/features"),
   format = Array("pretty")
 )
class FeatureTests