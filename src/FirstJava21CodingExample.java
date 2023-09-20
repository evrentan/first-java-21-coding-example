public class FirstJava21CodingExample {
    void main() {

        StringBuilder catSoundPatternMatching = new StringBuilder();
        catSoundPatternMatching.append("Cat sound: ");
        catSoundPatternMatching.repeat(makeAnimalSound(new Cat()) + " ", 3);

        StringBuilder catSoundInterface = new StringBuilder();
        catSoundInterface.append("Cat sound: ");
        catSoundInterface.repeat(new Cat().makeSound() + " ", 3);

        assert catSoundPatternMatching.toString().contentEquals(catSoundInterface.toString()) : "Cat sounds are not equal";
        System.out.println(String.format("Cat sounds are equal and is %s", catSoundPatternMatching.toString()));

        StringBuilder dogSoundPatternMatching = new StringBuilder();
        dogSoundPatternMatching.append("Dog sound with pattern matching: ");
        dogSoundPatternMatching.repeat(makeAnimalSound(new Dog()) + " ", 3);

        StringBuilder dogSoundInterface = new StringBuilder();
        dogSoundInterface.append("Dog sound with interface: ");
        dogSoundInterface.repeat(new Dog().makeSound() + " ", 3);

        assert dogSoundPatternMatching.toString().contentEquals(dogSoundInterface.toString()) : "Dog sound are not equal";
        System.out.println(String.format("Dog sounds are equal and is %s", dogSoundPatternMatching.toString()));
    }

    sealed interface Animal permits Cat, Dog {
        String makeSound();
    }

    final class Cat implements Animal {
        @Override
        public String makeSound() {
            return "Meow";
        }
    }

    final class Dog implements Animal {
        @Override
        public String makeSound() {
            return "Woof";
        }
    }

    String makeAnimalSound(Animal animal) {
        return switch (animal) {
            case Cat cat -> "Meow";
            case Dog dog -> "Woof";
        };
    }
}