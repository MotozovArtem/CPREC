package io.rienel;

import io.rienel.model.Cat;
import io.rienel.model.Dog;
import io.rienel.model.Fish;
import io.rienel.model.Man;
import io.rienel.model.Speekable;
import io.rienel.model.Terminator;

import java.util.ArrayList;
import java.util.List;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.23
 */
public class InterfaceExample {
    public static void main(String[] args) {
        List<Speekable> speekables = new ArrayList<>();
        speekables.add(new Terminator());
        speekables.add(new Man());
        speekables.add(new Dog());
        speekables.add(new Cat());
        speekables.add(new Fish());
//        speekables.add(new Speekable() {
//            @Override
//            public String sayLine() {
//                return "АРТЕМ ГОВОРИТ МИРУ МИР";
//            }
//        });
//        speekables.add(()-> {
//            return "Вау, вот это лямбды";
//        });
//        speekables.add(()-> "Можно еще проще?");
        for (Speekable speekable: speekables) {
            System.out.println(speekable.sayLine());
        }
    }
}
