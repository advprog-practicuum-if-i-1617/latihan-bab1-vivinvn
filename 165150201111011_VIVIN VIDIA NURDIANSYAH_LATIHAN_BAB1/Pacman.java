package pacman;

import java.util.Scanner;

public class Pacman {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        pacmanclass game = new pacmanclass();
        String tombol;
        int point = 0, langkah = 0;
        game.setAwal();
        int[][] kotak = new int[10][10];
        kotak[1][7] = 2;
        kotak[3][1] = 2;
        kotak[4][7] = 2;
        kotak[8][1] = 2;
        System.out.println("〠 〠 〠 〠 GAME PAKMAN PAKMAN NAN 〠 〠 〠 〠");
        do {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (kotak[i][j] != 2) {
                        kotak[i][j] = 0;
                        if (i == 0 || i == 9 || j == 0 || j == 9 || i == 2 && j == 1 || i == 2 && j == 2 || i == 6 && j == 8 || i == 6 && j == 7 || i == 6 && j == 6 || i == 6 && j == 5) {
                            kotak[i][j] = 1;
                        }
                    }
                }
            }
            if (kotak[game.getY()][game.getX()] == 2) {
                kotak[game.getY()][game.getX()] = 3;
                point = point + 1;
            }
            kotak[game.getY()][game.getX()] = 3;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (kotak[i][j] == 1) {
                        System.out.print("#");
                    } else if (kotak[i][j] == 0) {
                        System.out.print(" ");
                    } else if (kotak[i][j] == 2) {
                        System.out.print("*");
                    } else if (kotak[i][j] == 3) {
                        System.out.print("☻");
                    }
                }
                System.out.println(" ");
            }
            System.out.print("Perintah Gerak\t\t\t : ");
            tombol = input.nextLine();
            switch (tombol) {
                case "a":
                    game.setKiri();
                    if (game.getX() == 0) {
                        game.setKanan();
                    } else if (kotak[game.getY()][game.getX()] == 1) {
                        game.setKanan();
                    }
                    break;
                case "s":
                    game.setTurun();
                    if (game.getY() == 9) {
                        game.setNaik();
                    } else if (kotak[game.getY()][game.getX()] == 1) {
                        game.setNaik();
                    }
                    break;
                case "d":
                    game.setKanan();
                    if (game.getX() == 9) {
                        game.setKiri();
                    } else if (kotak[game.getY()][game.getX()] == 1) {
                        game.setKiri();
                    }
                    break;
                case "w":
                    game.setNaik();
                    if (game.getY() == 0) {
                        game.setTurun();
                    } else if (kotak[game.getY()][game.getX()] == 1) {
                        game.setTurun();
                    }
                    break;
            }
            langkah = langkah + 1;
            System.out.println("Point Anda\t\t\t : " + point);
            if (langkah > 30) {
                break;
            }
        } while (point < 4);
        if (langkah > 30) {
            System.out.println("ANDA KALAH GAME!!");
            System.out.println("Langkah Yang Anda Tempuh\t : " + langkah);
        } else if (langkah <= 30) {
            System.out.println("ANDA MEMENANGKAN GAME!!");
            System.out.println("Langkah Yang Anda Tempuh\t : " + langkah);
        }
    }
}
