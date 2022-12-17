package io.rienel

fun main() {
	println("Hello world")
	// String s = "World"
	var s = "World"
	val a = String(s.toCharArray())
	println(s)
	if (a === s) {
		println("Same objects")
	}
	if (a == s) {
		println("Equals string")
	}
	val world = if (s == "World") "Hello" else "Goodbye"
	// String world = s.equals("World") ? "Hello" : "Goodbye"
	println(world)
	// for (Character c: s) {
	// 	System.out.println("Char: " + c)
	// }
	for (c in s ){
		println("Char: $c")
	}
	// for (int i = 0 ; i < s.length(); i++) { }
	for (c in 0 until s.length step 2) {
		println("Char: ${s[c]}")
	}
	var v: String? = "VVVVVV"
//	v = null
	if (v != null) {
		v.lowercase()
	}
//	v?.lowercase()
//	v!!.lowercase()
//	v?.let {
//		it.lowercase()
//	}
//	 Optional<String> v = Optional.of("VVVVVVV");
//	 v.ifPresent((String it)-> {
//	 		it.toLowerCase();
//	 })
	println(describe(1))
	println(describe(2))
	println(describe("Hello"))
	println(describe(""))
	val p = Person(
		name = "Artem",
		surname = "Motozov",
		age = 24
	)
	println(p)
//	 List<String> strings = new ArrayList<>();
//	 strings.add("Hello");
//	 List<String> strings = List.of();
//	 strings.add("HelloImmutable"); //
	val strings = mutableListOf("Hello")
	strings.add("World")
	strings.stream()
		.filter { it.length > 3 }
		.toList()
	println(strings)

	val mappedInteger = mutableMapOf<String, Int>(
		"One" to 1,
		Pair("Two", 2),
		"Three" to 3,
	)
	println(mappedInteger)
}

fun describe(obj: Any): String =
	when (obj) {
		1 -> "One"
		"Hello" -> "Greeting"
		is Long -> "Long"
		!is String -> "Not a string"
		else -> "Unknown"
	}

data class Person(
	var name: String = "Artem",
	var surname: String = "Motozov",
	var age: Int = 24,
) {
	val fullName = "$surname $name"
}

/**
 * import java.util.Arrays;
 *
 * public class Main {
 * 	public static void main(String[] args) {
 * 		System.out.println("Hello world!");
 * 		System.out.println("Program arguments: " + Arrays.toString(args));
 * 	}
 * }
 */