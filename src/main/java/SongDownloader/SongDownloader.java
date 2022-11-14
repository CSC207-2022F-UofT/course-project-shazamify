package SongDownloader;

import java.util.Scanner;

public class SongDownloader {

    public static void main(String[] args) {
//        Single video or playlist link
//        https://www.youtube.com/watch?v=gWo12TtN9Kk
        System.out.println("Enter youtube link: ");
        Scanner sc = new Scanner(System.in);
        String link = sc.nextLine();

        YTdlp p = new YTdlp(link);
        p.download();
    }
}
