I just want to place some useful resources of Java learing, which will be convenient for me to review and maybe help others.

# the Fist Record
I upload a practice in Java MOOC of University of Helsinki located in Programming 1 part 4 section 3. It uses OOP to analyze statistics files, both of which worth learning.
On the one hand, I should transfer my mind to solve prolems in object perspective, including the objects usage in list. On the other hand, I can encapsulate the process of reading file to make the program more understandable.

# ExtractAPrivateIntermediateMethod
### The Problem

Initially, the logic for finding the shortest person was present in two different public methods: `shortest()` and `take()`. This created redundant code. If the logic for finding the shortest person ever needed to change, it would have to be updated in two separate places, increasing the risk of bugs and making maintenance more difficult.

### The Solution: `findShortestPerson()`

To solve this, the common logic was extracted into a single **private helper method**:

```java
private Person findShortestPerson() {
    // ... logic to find and return the shortest person
}
```
