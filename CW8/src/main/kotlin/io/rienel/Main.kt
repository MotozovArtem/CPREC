package io.rienel

import kotlin.jvm.optionals.getOrNull

@OptIn(ExperimentalStdlibApi::class)
fun main() {
//	String a = "asdfa";
//	val a = "asfd"
//	// for (int i = 0; i < a.length(); i++) {/**/}
//	for (c in a) {
//		println("Char: $c")
//	}
//	for (c in 0 until a.length) {
//		println("Char: ${a[c]}")
//		// System.out.println("Char: " + a.charAt(c))
//	}
//	val person = Person(
//		age = 24,
//		surname = "Motozov",
//		name = "Artem",
//	)
//	println(person)
//	val personJava = PersonJava(
//		"Artem",
//		"Motozov",
//		24
//	)
//	println(personJava)
//
//	println(person.fullName)
//	var s: String? = null
//	println(s)
////	if (s != null){
////		s.uppercase()
////	}
////	s?.uppercase()
////	println(s?.uppercase())
//	s?.let {
//		println(it.uppercase())
//	}
//	// String s = "asdf"
//	// s = null;
//
//
//	// List<String> strings = new ArrayList<>();
//	// strings.add("Hello");
//	val strings = mutableListOf("Hello")
//	// List<String> a = List.of("Hello")
//	// a.add("world"); //
//	strings.add("world")
//	println(strings)
	val res = describe("")
	println(res)
	val maps = mutableMapOf<String, Int>(
		"One" to 1,
		"Two" to 2,
		"Three" to 3,
		Pair("Four", 4),
		"Five" to 5,
	)
	println(maps.entries
		.stream()
		.filter { entry -> entry.value == 1 }
		.findAny()
		.getOrNull()
		?.key)
}

fun describe(obj: Any): String =
	when (obj) {
		1          -> "One"
		2          -> "Two"
		3          -> "Three"
		"Hello"    -> "Greeting"
		is Long    -> "Long"
		!is String -> "Not a string"
		else       -> "Unknown"
	}

data class Person(
	var name: String,
	var surname: String,
	var age: Int,
) {
	var inn: String = ""
		get() = field
		set(value) {
			field = value
		}

	val fullName = "$surname $name"
}

/**
 * import java.util.Arrays;
 *
 * public class Main {
 * 	public static void io.rienel.main(String[] args) {
 * 		System.out.println("Hello world!");
 *
 * 		System.out.println("Program arguments: " + Arrays.toString(args));
 * 	}
 * }
 */