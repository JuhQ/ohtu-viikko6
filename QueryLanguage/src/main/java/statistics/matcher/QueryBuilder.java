/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

/**
 *
 * @author juhatauriainen
 */
public class QueryBuilder {

    private ArrayList<Matcher> matcherLista;
    boolean isOneOf;

    public QueryBuilder() {
        this.matcherLista = new ArrayList<>();
        isOneOf = false;
    }

    public QueryBuilder playsIn(String team) {
        this.matcherLista.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcherLista.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcherLista.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        for (Matcher matcher : matchers) {
            this.matcherLista.add(matcher);
        }
        isOneOf = true;
        return this;
    }

    public Matcher build() {
        Matcher[] lista = this.matcherLista.toArray(new Matcher[0]);

        this.matcherLista = new ArrayList<>();

        if (isOneOf) {
            isOneOf = false;
            return new Or(lista);
        }

        return new And(lista);
    }
}
