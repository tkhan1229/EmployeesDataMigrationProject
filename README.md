# Employees Data Migration Project

Employees Data Migration Project is a Java program that uses a CSV These sort methods are compared against each other though a metric measurement of performance speed in milliseconds. 
The sorting algorithms used are as follows:
- Binary Tree Sort
- Bubble Sort
- Quick Sort
- Insertion Sort
- Merge Sort 
- Selection Sort

[Sort Manager](https://i.ibb.co/1Xb1v7f/Screenshot-2020-08-28-at-16-01-23.png)

## Installation

Clone the repository and open the program folder using a Java IDE such as IntelliJ to compile the classes.

## How It Works
1. Compile and run project.
2. Open the console and view the menu.
3. Select the sorting algorithm and insert size of random array.
4. The program will list the unordered array, sorted array and performance time.

## Usage

```java
Printers.preSortArray(arrayToSort); //returns random generated array of chosen size
Printers.printReturnedArray(sort.sortArray(arrayToSort)); //returns sorted array using a sorting algorithm 
SpeedChecker.timer(sort, arrayToSort); //assesses performance speed of sorting algorithm 
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
