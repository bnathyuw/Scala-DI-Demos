# Scala DI Demos

Trying out patterns for Dependency Injection in Scala.

This uses a basic Till/Checkout scenario to explore these patterns.

## Contents

* /cake: In this project, I’m trying to get my head round the Cake Pattern, which uses traits to inject dependencies.
* /cocktail: In this project, I’ve made a classic OOP, constructor injection implementation. The final wiring is a simple Cocktail Party constructor.
* /partial_application: This project moves towards a more strictly functional approach. Dependency injection is achieved by using partial function application.
* /function_objects: create function objects, whose constructors set up their dependencies. We have nearly come full circle, as this is strikingly similar to a classic OOP implemention, just with prettier syntax and better enforced SRP. 