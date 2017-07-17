package com.hk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Trie t = new Trie();

        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if("add".equals(op)) {
                t.add(contact);
            } else if("find".equals(op)) {
                System.out.println(t.find(contact));
            }
        }
    }

    static class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void add(String in) {

            char[] chars = in.toCharArray();

            TrieNode temp = root;

            for(int i = 0; i < chars.length; i++) {

                TrieNode x = temp.childsContains(chars[i]);

                if(x == null) {
                    TrieNode newNode = new TrieNode();
                    newNode.content = chars[i];
                    temp.childs.add(newNode);
                    temp = newNode;
                } else {
                    x.count++;
                    temp = x;
                }
            }
        }

        int find(String in) {
            int count = 0;
            char[] chars = in.toCharArray();

            TrieNode temp = root;

            for(int i = 0; i < chars.length; i++) {

                TrieNode x = temp.childsContains(chars[i]);

                if(x == null) {
                    return 0;
                } else {
                    temp = x;
                }
            }

            if(!temp.equals(root)) {
                count = temp.count;
            }

            return count;
        }
    }

    static class TrieNode {

        char content;
        int count = 1;
        List<TrieNode> childs;

        TrieNode() {
            childs = new ArrayList<>();
        }

        TrieNode childsContains(char c) {
            for(TrieNode n : childs) {
                if(n.content == c) {
                    return n;
                }
            }

            return null;
        }
    }
}
