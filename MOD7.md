# Summary

## Describe your unit testing approach for each of the three features.

- To what extent was your approach aligned to the software requirements? Support your claims with specific evidence.
  - I mapped each requirement to one or more tests for Task, Contact, and Appointment. I checked ID length limits, nulls, field bounds, duplicate IDs, and the basic create, update, and delete flows in the services.
- Defend the overall quality of your JUnit tests. In other words, how do you know your JUnit tests were effective based on the coverage percentage?
  - JaCoCo shows full line coverage for Appointment, Task, and all services, and nearly full for Contact. That tells me the tests exercise both the happy paths and the validation failures.

## Describe your experience writing the JUnit tests.

- How did you ensure that your code was technically sound? Cite specific lines of code from your tests to illustrate.
  - I wrote failure first tests that assert exceptions for bad inputs, then added happy path assertions. In TaskTest I create tasks with nulls or too long fields and expect IllegalArgumentException. In AppointmentTest I guard against past or null dates. In ContactServiceTest I confirm duplicate adds are rejected.
- How did you ensure that your code was efficient? Cite specific lines of code from your tests to illustrate.
  - Service operations are constant time with HashMap. My tests call updates and deletes directly without loops and confirm no errors when updating or deleting nonexistent IDs, which shows the code exits early instead of doing extra work.

# Reflection

## Testing Techniques

- What were the software testing techniques that you employed in this project? Describe their characteristics using specific details.
  - I used unit tests with boundary analysis, happy path checks, and negative testing using expected exceptions. I also verified service behavior like duplicate detection and safe no operation updates.
- What are the other software testing techniques that you did not use for this project? Describe their characteristics using specific details.
  - I didn’t use integration tests, parameterized tests, property based testing, or mutation testing. Those cover cross component interactions, data driven input suites, randomized exploration, and assertion strength.
- For each of the techniques you discussed, explain the practical uses and implications for different software development projects and situations.
  - Integration tests would matter once we add a database or API. Parameterized tests would compactly cover many input variants. Mutation testing would stress our assertions and catch weak checks in the validations.

## Mindset

- Assess the mindset that you adopted working on this project. In acting as a software tester, to what extent did you employ caution? Why was it important to appreciate the complexity and interrelationships of the code you were testing? Provide specific examples to illustrate your claims.
  - I took a cautious approach by turning each requirement into one or more tests and by starting with edge cases like future only appointment dates to avoid time related defects.
- Assess the ways you tried to limit bias in your review of the code. On the software developer side, can you imagine that bias would be a concern if you were responsible for testing your own code? Provide specific examples to illustrate your claims.
  - I limited bias by writing both happy and failure paths and by adding tests for nonexistent IDs. I also tried to break my constructors with oversize strings and nulls to avoid assuming my own code is correct.
- Finally, evaluate the importance of being disciplined in your commitment to quality as a software engineering professional. Why is it important not to cut corners when it comes to writing or testing code? How do you plan to avoid technical debt as a practitioner in the field? Provide specific examples to illustrate your claims.
  - Discipline prevents subtle regressions. I avoid shortcuts by keeping validations in the domain classes and by enforcing duplicate checks in the services with tests in AppointmentServiceTest and ContactServiceTest. I plan to add new boundary tests whenever requirements change so debt doesn’t pile up.

