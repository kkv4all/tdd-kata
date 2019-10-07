# Test Driven Development though Kata

## Introduction

The **Test Driven Development** (TDD) is a software engineering practice that requires unit tests to be written before the code they are supposed to validate. Coming from the Agile world in which it is a basic practice of the Extreme programming (XP) method, TDD is nowadays recognized as a discipline in its own right that is also used outside the agile context.

**Each iteration in TDD has Three Stages:**

- **RED** First write a unit test in failure. The impossibility of compiling is a failure.

- **GREEN** Write as soon as possible the production code sufficient to pass this unit test even if it means allowing the “worst” solutions. Of course if a clean and simple solution appears immediately, it must be realized but otherwise it is not serious the code will be improved incrementally during the refactoring phases. The aim here is to obtain as soon as possible the green bar of success of the unit tests.

- **REFACTOR** This phase is often neglected but is essential because it eliminates possible code duplication but also makes it possible to make changes in architecture, factorization, presentation… This refactoring concerns both the production code and the test code and must not modify the external behavior of the program, which is materialized by a test execution bar that remains green.


## FIRST Principles of Good Unit Tests

**Acronym FIRST stand for below test features:**

- **F**ast -Unit tests should be fast otherwise they will slow down your development/deployment time
- **I**solated - Never ever write tests which depend on other test cases.
- **R**epeatable - A repeatable test is one that produces the same results each time you run it.
- **S**elf-validating - There must be no manual interpretation of results.
- **T**imely - You’re better off focusing on writing unit tests in a timely fashion.

## Tips for writing great unit tests

- Test only one code unit at a time.
- Make each test independent to all the others.
- Name your unit tests clearly and consistently.
- Write tests for methods that have the fewest dependencies first, and work your way up.
- Aim for each unit test method to perform exactly one assertion.
- Create separate unit tests that target exceptions.
- Ensure that test code is separated from production code.
- Don’t make unnecessary assertions.
- Don’t unit-test configuration settings.
- Do not use static members in a test class.
- Do not rely on indirect testing.
- Do not print anything out in unit tests.
- Put assertion parameters in the proper order.
- Use the most appropriate assertion methods.

## Principles to Keep in Mind

- **SOLID Principles** — **S**ingle Responsibility principle, **O**pen and Close principle, **L**iskov substitution principle, **I**nterface segregation principle, **D**ependency inversion principle
- **KISS principle** — **K**eep **I**t **S**imple, **S**tupid
- **YAGNI principle** — **Y**ou **A**in’t **G**onna **N**eed **I**t
- **DRY principle** — **D**on’t **R**epeat **Y**ourself

## Three Rules of TDD

1. You may not write production code unless you've first written a failing unit test.
2. You may not write more of a unit test than is sufficient to fail.
3. You may not write more production code than is sufficient to make the failing unit test pass.


## TDD Approaches
There are two camps are commonly referred to as the Detroit School of TDD (or Classicist, state based testing, Inside-out, black-box testing) and the London School of TDD (or Mockist, Interaction testing, Outside-in testing, white-box testing).
``` 
 _____________________________________________________________________________________________________________________________________
|                             Classicist                             |                             Mockist                            |
 --------------------------------------------------------------------------------------------------------------------------------------
| Like working with real objects                                     | Prefer working with fake objects                               |
| State verification                                                 | Behavior verification                                          |
| Use mocks to test collaborations                                   | Use mocks all the time                                         |
| Will hard code collaboration                                       | Will mock collaborations                                       |
| TDD from middle out                                                | TDD from the outside in                                        |
| Use Object Mothers/Factories for test setup                        | Will mock only what they need for test collaboration           |
| Test tend to be more coarse grained – approaching more integration | Tests tend to be very fine grained – may miss integrations     |
| style tests                                                        |                                                                |
| Classists don’t couple tests to implementation                     | Mockists do                                                    |
| Classists don’t like to think of implementation when writing test  | Mockists do                                                    |
| Don’t mind creating query methods to support testing               | Mockists typically don’t have to                               |
| Classists style can encourage Asking Not Telling design            | Mockists style encourages Tell Don’t Ask                       |
--------------------------------------------------------------------------------------------------------------------------------------
```
## What is Kata?
   Kata is a Japanese word meaning _"form"_, and in the martial arts it describes a choreographed pattern of movements used to train yourself to the level of muscle memory.
   
- Originally coined by Dave Thomas, co-author of Book [The Pragmatic Programmer: From Journeyman to Master| ]. 
- The idea is the same as in martial arts, practice and repetition to sharpen the skills.
- One of the reason TDD id hard for new learner is to implement it in real code right way after learning.
- This idea is very explicit about the baby-step nature of the changes you make to the code.

    By using the small but precise nature of the kata to practice these skills, you can get over this roadblock in a safe way where you understand that the purpose for the baby steps is to learn the movements.

## Kata Examples in Code
- FizzBuzz Kata
- Stack Implementation Kata
- Roman Numerals
- Bank Kata
- Trip Service (Legacy Code Refactor)

**_More TDD Kata Examples may be added_
## References
- JUnit Best Practices Guidelines: https://howtodoinjava.com/best-practices/unit-testing-best-practices-junit-reference-guide/
- 8 Signs of Bad Unit Test: https://howtodoinjava.com/best-practices/8-signs-of-bad-unit-test-cases/
- Test Driven Development:  https://hackernoon.com/introduction-to-test-driven-development-tdd-61a13bc92d92
- Testing and Refactoring Legacy Code By Sandro Mancuso (YouTube Link): https://youtu.be/_NnElPO5BU0
- Kata Catalogue by Coding Dojo: http://codingdojo.org/kata/
