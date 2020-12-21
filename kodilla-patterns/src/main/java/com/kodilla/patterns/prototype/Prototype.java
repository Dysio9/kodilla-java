package com.kodilla.patterns.prototype;

public class Prototype<T> implements Cloneable {

    @Override
    protected T clone() throws CloneNotSupportedException {
        return (T)super.clone();
    }
}


//    Klasy zrealizowane według wzorca "Prototype":
//
//        Implementują interfejs Cloneable, poprzez rozszerzenie dopisanej klasy, która go implementuje, dzięki czemu oznaczone są jako możliwe do klonowania (Cloneable to tzw. marker-interface).
//        Udostępniają metodę shallowCopy() do "płytkiego" klonowania.
//        Udostępniają metodę deepCopy() do "głębokiego" klonowania.
