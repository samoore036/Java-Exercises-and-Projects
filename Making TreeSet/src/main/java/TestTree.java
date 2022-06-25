/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mooshahe
 */
import java.util.*;
public class TestTree {
    public void go() {
        Comparator<Book> comparator = Comparator
                .comparing(Book::getTitle);
        Set<Book> tree = new TreeSet<>(comparator);
        tree.add(new Book("How"));
        tree.add(new Book("Why"));
        tree.add(new Book("Who"));
        tree.add(new Book("What"));
        tree.add(new Book("When"));
        System.out.println(tree);
    }
}
