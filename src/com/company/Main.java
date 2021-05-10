package com.company;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Recipe r = new Recipe();
        System.out.println(r.toString());
        System.out.println("@@@@@@@@");
        r.makePie();

    }
}
