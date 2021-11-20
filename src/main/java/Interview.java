public class Interview
{
    //Java intro
    /*
    Whenever, a program is written in JAVA, the javac compiles it.
    The result of the JAVA compiler is the .class file or the bytecode and not the machine native code (unlike C compiler).
    The bytecode generated is a non-executable code and needs an interpreter to execute on a machine. This interpreter is the JVM and thus the Bytecode is executed by the JVM.
    And finally program runs to give the desired output.

    In the case of Java, it is the magic of Bytecode that makes it platform independent.
    This adds to an important feature in the JAVA language termed as portability. Every system has its own JVM which gets installed automatically when the jdk software is installed. For every operating system separate JVM is available which is capable to read the .class file or byte code.
    An important point to be noted is that while JAVA is platform-independent language, the JVM is platform-dependent. Different JVM is designed for different OS and byte code is able to run on different OS.
    */

    //Varargs (variable arguments)
    /*
    ...
    There can be only one variable argument in a method.
    Variable argument (varargs) must be the last argument.
     */

    //Date and Time
    /*
    LocalDate, LocalTime, LocalDateTime
    //Formatting
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
     */

    //Static class
    /*
    Inner classes can be Static.
    A static nested class may be instantiated without instantiating its outer class.
    Inner classes can access both static and non-static members of the outer class. A static class can access only the static members of the outer class.
     */

    //Testing - JUnit
    /*
    FIRST principle:
    [F]ast
    [I]solated (Never ever write tests which depend on other test cases.)
    [R]epeatable (A repeatable test is one that produces the same results each time you run it. In these cases, feel free to use mock objects.)
    [S]elf-validating (Each test must be able to determine that the output is expected or not. It must determine it is failed or pass. There must be no manual interpretation of results.)
    [T]imely


    AssertJ
    AssertJ – an open source community-driven library used for writing fluent and rich assertions in Java tests.
    AssertJ provides a rich set of assertions, truly helpful error messages, improves test code readability and is designed to be super easy to use within your favorite IDE.

    f.e:
    assertThat(frodo)
      .isNotEqualTo(sauron)
      .isIn(fellowshipOfTheRing);

    assertThat(frodo.getName())
      .startsWith("Fro")
      .endsWith("do")
      .isEqualToIgnoringCase("frodo");

    assertThat(fellowshipOfTheRing)
      .hasSize(9)
      .contains(frodo, sam)
      .doesNotContain(sauron);

    Object assertion
    assertThat(fido).isEqualTo(fidosClone);
    assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidosClone);

    Boolean assertion
    assertThat("".isEmpty()).isTrue();

    Iterable/Array Assertions
    assertThat(list)
      .isNotEmpty()
      .contains("1")
      .doesNotContainNull()
      .containsSequence("2", "3");

    Character Assertions
    assertThat(someCharacter)
      .isNotEqualTo('a')
      .inUnicode()
      .isGreaterThanOrEqualTo('b')
      .isLowerCase();

    Class Assertions
    assertThat(Runnable.class).isInterface();
    assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);

    File assertions
    assertThat(someFile)
       .exists()
       .isFile()
       .canRead()
       .canWrite();

    Map assertions
    assertThat(map)
      .isNotEmpty()
      .containsKey(2)
      .doesNotContainKeys(10)
      .contains(entry(2, "a"));

    Exception handling
    assertThatThrownBy(() -> {
        List<String> list = Arrays.asList("String one", "String two");
        list.get(2);
    }).isInstanceOf(IndexOutOfBoundsException.class)
      .hasMessageContaining("Index: 2, Size: 2");

    assertThatExceptionOfType(IndexOutOfBoundsException.class)
      .isThrownBy(() -> {
          // ...
    }).hasMessageMatching("Index: \\d+, Size: \\d+");


    TDD
    Test-Driven Development (TDD) is a software development process which includes test-first development.
    It means that the developer first writes a fully automated test case before writing the production code to fulfil that test and refactoring.
    1. Firstly, add a test.
    2. Run all the tests and see if any new test fails.
    3. Update the code to make it pass the new tests.
    4. Run the test again and if they fail then refactor again and repeat.
     */

    //Java - Advanced Features
    /*
    Composition
    In Composition, one class includes another class and is dependent on it so that it cannot functionally exist without another class.
    In Java, the ‘final’ keyword is used to represent Composition.

    Polymorphism
    Polymorphism in Java is the ability of an object to take many forms.

    Annotations
    Java annotations are a mechanism for adding metadata information to our source code.
    Although we can attach them to packages, classes, interfaces, methods, and fields, annotations by themselves have no effect on the execution of a program.

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.Type)
    public @interface JsonSerializable {
    }

    @Target(ElementType.Type) - Class level
    @Target(ElementType.METHOD) - Method level
    @Target(ElementType.FIELD) - Field level

    Get class annotation
    Class<?> clazz = object.getClass();
    if (clazz.isAnnotationPresent(JsonSerializable.class)) {
        ...
    }

    Get method annotation
    Class<?> clazz = object.getClass();
    for (Method method : clazz.getDeclaredMethods()) {
        if (method.isAnnotationPresent(Init.class)) {
            method.setAccessible(true);
            method.invoke(object);
        }
    }

    Get field annotation
    Class<?> clazz = object.getClass();
    Map<String, String> jsonElementsMap = new HashMap<>();
    for (Field field : clazz.getDeclaredFields()) {
        field.setAccessible(true);
        if (field.isAnnotationPresent(JsonElement.class)) {
            jsonElementsMap.put(getKey(field), (String) field.get(object));
        }
    }

    IO/NIO
    IO: Stream oriented, Blocking IO
    NIO: Buffer oriented, Nin cs blocking IO, Selectors

    Stream oriented:
        Java IO being stream oriented means that you read one or more bytes at a time, from a stream.
        What you do with the read bytes is up to you.
        They are not cached anywhere. Furthermore, you cannot move forth and back in the data in a stream.
        If you need to move forth and back in the data read from a stream, you will need to cache it in a buffer first.

    Buffer oriented:
        Java NIO's buffer oriented approach is slightly different.
        Data is read into a buffer from which it is later processed.
        You can move forth and back in the buffer as you need to.
        This gives you a bit more flexibility during processing.

    Selectors:
        Java NIO's selectors allow a single thread to monitor multiple channels of input.
        This selector mechanism makes it easy for a single thread to manage multiple channels.

    //Volatile
    The Java volatile keyword guarantees visibility of changes to variables across threads. This may sound a bit abstract, so let me elaborate.
    */
}
