import java.util.Objects;

public class Pair<E> {
    private E element_1, element_2;

    public Pair(E element_1, E element_2) {
        this.element_1 = element_1;
        this.element_2 = element_2;
    }
    public Pair(Pair<E> other ) {
        this.element_1 = other.element_1;
        this.element_2 = other.element_2;
    }

    public E getFirst() {
        return this.element_1;
    }
    public E getSecond() {
        return this.element_2;
    }
    public void setFirst(E frist) {
        this.element_1 = frist;
    }
    public void setSecond(E second) {
        this.element_2 = second;
    }

    public void swap() {
        E temp = this.element_1;
        this.element_1 = this.element_2;
        this.element_2 = temp; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?> other = (Pair<?>) obj;
        return (element_1 != null ? element_1.equals(other.element_1) : other.element_1 == null) &&
                (element_2 != null ? element_2.equals(other.element_2) : other.element_2 == null);
    }

    @Override
    public String toString() {
        return "Pair<" + this.element_1 + ", " + this.element_2 +'>';
    }

    public static void main(String[] args) {
        Pair<Integer> pair1 = new Pair<>(1, 2);
        Pair<Integer> pair2 = new Pair<>(1, 2);
        System.out.println("Variable pair1 hat den Wert: " + pair1);
        System.out.println("Variable pair2 hat den Wert: " + pair2);
        System.out.println("Syntaktische Gleichheit von pair1 und pair2 ist: " + (pair1==pair2));
        System.out.println("Semantische Gleichheit von pair1 und pair2 ist: " + pair1.equals(pair2));
        Pair<Integer> pair1b = pair1;
        Pair<Integer> pair2b = new Pair<>(pair2);
        pair1.swap();
        pair2.setFirst(10);
        System.out.println("Nach swap() hat Variable pair1 den Wert: " + pair1);
        System.out.println("Nach setFirst(10) hat Variable pair2 den Wert: " + pair2);
        System.out.println("Die zuvor erstellte Kopie pair1b hat den Wert: " + pair1b);
        System.out.println("Die zuvor erstellte Kopie pair2b hat den Wert: " + pair2b);
        /*
        Die erwartete Ausgabe ist:
Variable pair1 hat den Wert: Pair<1, 2>
Variable pair2 hat den Wert: Pair<1, 2>
Syntaktische Gleichheit von pair1 und pair2 ist: false
Semantische Gleichheit von pair1 und pair2 ist: true
Nach swap() hat Variable pair1 den Wert: Pair<2, 1>
Nach setFirst(10) hat Variable pair2 den Wert: Pair<10, 2>
Die zuvor erstellte Kopie pair1b hat den Wert: Pair<2, 1>
Die zuvor erstellte Kopie pair2b hat den Wert: Pair<1, 2>
         */
    }
}

