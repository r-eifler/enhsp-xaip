/*
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.hstairs.ppmajal.extraUtils;

/**
 * @author enrico
 */
public class Pair<A, B> {

    private A first;
    private B second;

    public Pair ( ) {
        super();
    }

    public Pair (A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode ( ) {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    @Override
    public boolean equals (Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return ((this.first == otherPair.first
                    || (this.first != null && otherPair.first != null
                    && this.first.equals(otherPair.first)))
                    && (this.second == otherPair.second
                    || (this.second != null && otherPair.second != null
                    && this.second.equals(otherPair.second))));
        }

        return false;
    }

    @Override
    public String toString ( ) {
        return "(" + first + ", " + second + ")";
    }

    public A getFirst ( ) {
        return first;
    }

    public void setFirst (A first) {
        this.first = first;
    }

    public B getSecond ( ) {
        return second;
    }

    public void setSecond (B second) {
        this.second = second;
    }
}
