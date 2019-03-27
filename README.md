# Java 8 Functional Programming

## Abstract

With its 8th Release, Java becomes a functional programming language, like Lisp, Clojure and others. Like Scala, Java 8 and above is an object-oriented and functional programming language.

As opposed to a an imperative programming language, a functional programming language is more declarative. In imperative programming style, programs are composed from elements that "do" something. "Doing" something generally implies an initial state, a transition and an end state. This is called *state mutations*. Hence, traditional imperative style programs are described as a series of mutations, separated with conditions testings.  

On the other hand, functional programs are composed of elements that "are" something, they don't "do" something. The difference might not seem important, but is is. In other words, as opposed to imperative style programming, in the functional programming there aren't mutations and there aren't side effects.

Java 8 and above is, in the same time, an imperative style and a functional programming language. This project aims at illustrating several Java 8 and above functional new features like:   

* lambda functions
* the new stream API
* paralel data processing
* using optional as a better alternative to null
* new date and time api
* default methods
* the module system
* the reactive programming

## Build

The build process uses Apache Maven. Simply do:

```
mvn clean install
```
This will run some unit and integration tests. 


