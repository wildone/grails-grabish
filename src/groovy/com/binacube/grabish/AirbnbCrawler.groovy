package com.binacube.grabish

import geb.Browser
import geb.Page
import geb.Module

class CrawlerModule extends Module {
	
	   // a parameterised value set when the module is included
	   def buttonValue
	
	   // the content DSL
	   static content = {
	
		   // name the search input control �field�, defining it with the jQuery like navigator
		   field { $("input", name: "q") }
	
		   // the search button declares that it takes us to the results page, and uses the
		   // parameterised buttonValue to define itself
		   button(to: GoogleResultsPage) {
			   $("input", value: buttonValue)
		   }
	   }
   }
	
class GoogleHomePage extends Page {

   // pages can define their location, either absolutely or relative to a base
   static url = "http://google.com/ncr"

   // �at checkers� allow verifying that the browser is at the expected page
   static at = { title == "Google" }

   static content = {
	   // include the previously defined module
	   search { module GoogleSearchModule, buttonValue: "Google Search" }
   }
}
	
class GoogleResultsPage extends Page {
   static at = { title.endsWith "Google Search" }
   static content = {
	   // reuse our previously defined module
	   search { module GoogleSearchModule, buttonValue: "Search" }

	   // content definitions can compose and build from other definitions
	   results { $("li.g") }
	   result { i -> results[i] }
	   resultLink { i -> result(i).find("a.l") }
	   firstResultLink { resultLink(0) }
   }
}
