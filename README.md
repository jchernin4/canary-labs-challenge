# canary-labs-challenge

## Language used: Java

## How to run:

1) Run Tests

`./gradlew test`

2) Compile & Run

`./gradlew run --console plain -q`

This will hide any other output and run my program.

3) Enter command
You will be prompted to enter a command. Your options are:

select, filter, and sort.

Examples:
select FirstName,LastName
filter GPA > 2.25
sort GPA desc

## Design Choices
I decided to make an CsvOperation interface, since this ensures that all operations are consistent in structure, and it also makes it easier to create new operations in the future by just creating a new class that implements the CsvOperation interface. This was also chosen for the Strategy pattern, using CsvOperation as a way to run any strategy (or operation in this project) dynamically at runtime. We see this in the Main class, which selects which CsvOperation to run given the user's input. All these CsvOperation derivatives have an "execute" method, which means that we can blindly call this method without knowing which operation was selected.

I also decided to use Gradle as a build tool, as it let me easily install JUnit, which I used for writing tests and because I was already familiar with this tool.

One of the other major design choices I made was to separate the headers from the data values, treating data as a 2D array. This makes the code cleaner overall, with the headers only needing to be split once in Main instead of doing it in every CsvOperation. This 2D array is set up so that the first index represents which entry is being selected, and the second index is which cell in that entry to retrieve. This makes accessing values quick and easy throughout the solution.

Finally, I decided to make each operation validate its parameters separately. This is because some operations have different requirements, like how SelectOperation has to make sure that all of the passed headers exist instead of just one. This makes the Main class cleaner, distributing these checks into each class instead of keeping them all in one big switch statement in Main.

## Future Extensions
In the future, I think it would be useful to implement nested queries (for example, `select FirstName,LastName | filter GPA > 2.25`) for more complex operations with multiple steps. It would also be useful to implement more features found in SQL, such as a limit operator that only displays the first X results, or aggregate methods like sum and average for summary statistics. Finally, I could expand the current filters, such as adding >= and <= as valid comparisons for the FilterOperation.