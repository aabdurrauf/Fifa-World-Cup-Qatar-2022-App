package com.example.spormusabakatakipuygulamasi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static ArrayList<Country> CountryList = new ArrayList<>();
    public static ArrayList<Group> groups = new ArrayList<>();

    public static void assignCountry(Scanner scanner) throws NumberFormatException{
        // read the country name
        StringBuilder countryName = new StringBuilder(scanner.nextLine());
        countryName.delete(0, 6);
        //System.out.println(countryName);
        // read country ranking
        StringBuilder ranking = new StringBuilder(scanner.nextLine());
        int rank = Integer.parseInt(ranking.delete(0, 9).toString());
        //System.out.println("country ranking: " + rank);
        // read country champion time
        StringBuilder champion = new StringBuilder(scanner.nextLine());
        int champ = Integer.parseInt(champion.delete(0, 11).toString());
        // making new country object
        Country country = new Country(countryName.toString(), rank, champ);
        // read country year of champion
        StringBuilder yearLine = new StringBuilder(scanner.nextLine());
        yearLine.delete(0, 6);
        String[] years = yearLine.toString().split(", ");
        int[] championYears = new int[years.length];
        //System.out.print("champion year: ");
        int n = 0;
        for (String y : years) {
            int year = Integer.parseInt(y);
            championYears[n] = year;
            //System.out.print(year + " ");
            n++;
        }
        country.setChampionYears(championYears);
        // read country coach name
        StringBuilder coach = new StringBuilder(scanner.nextLine());
        coach.delete(0, 7);
        //System.out.println("\ncoach name: " + coach);
        // set coach name to country
        //country.setCoachName(coach.toString());
        // read country players name
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            StringBuilder player = new StringBuilder(scanner.nextLine());
            //player.delete(player.indexOf("(")-1,player.indexOf(")")+1);
            country.addPlayer(new Players(player.substring(0, player.indexOf("(")-1),
                    player.substring(player.indexOf("("))));
        }
        /*// print players name
        System.out.println("players: ");
        for(Players player : country.getPlayers()){
            System.out.print(player.getName() + " ");
            System.out.println(player.getPosition());
        }*/
        CountryList.add(country);
        scanner.close();
    }
    public static void assignGroup(Group group, Country country){
        group.addCountry(country);
    }
    public static void main(String[] args) throws FileNotFoundException {
        /*Scanner scn = new Scanner(System.in);
        // which file to read data from
        System.out.print("enter country: ");
        String country = scn.nextLine();
        try{
            Scanner scanner = new Scanner(new File("Resources/" + country + ".txt"));
            assignCountry(scanner);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found: " + country + ".txt");
        }
        catch (NumberFormatException e){
            System.out.println("Illegal access: " + country + ".txt");
        }*/
        File directory = new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\data_resources");
        File[] fileList = directory.listFiles();
        //System.out.println("List files: ");
        Scanner scanner;
        assert fileList != null;
        for(File file : fileList){
            /*System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getAbsolutePath());
            System.out.println("File size: " + file.getTotalSpace());*/
            try{
                scanner = new Scanner(file);
                assignCountry(scanner);
                /*// read and print files' information
                String input;
                StringBuffer sb = new StringBuffer();
                while (scanner.hasNextLine()) {
                    input = scanner.nextLine();
                    sb.append(input+" ");
                }
                System.out.println("Contents of the file: "+sb.toString());*/
            }
            catch(IOException e){
                System.out.println("IOEXception in file: " + file.getName());
            }
            catch (NumberFormatException e) {
                System.out.println("Illegal access: " + file.getName());
            }
        }
        // adding country to group
        for (int i = 65; i < 73; i++){
            groups.add(new Group(i));
        }
        for (int i = 0; i < 4; i++){
            assignGroup(groups.get(0), CountryList.get(i));
        }
        for (int i = 4; i < 8; i++){
            assignGroup(groups.get(1), CountryList.get(i));
        }
        /*
        System.out.println("table ranking: ");
        groups.get(0).showGroupRanking();
        groups.get(0).playMatch(groups.get(0).getCountryList().get(0), groups.get(0).getCountryList().get(1));
        */
        Scanner scan = new Scanner(System.in);
        int menu_input = 1;

        while (menu_input != 0) {
            System.out.println("\n*****************************");
            System.out.println("DÜNYA KÜPASI TAKİP UYGULAMASI");
            System.out.println("********* ANA MENÜ **********");
            System.out.println("*****************************");
            System.out.println("""
                    1. Maçlar
                    2. Haberler
                    3. Gruplar
                    4. Ülkeler
                    0. Çıkış""");
            System.out.println("Seçim giriniz: ");

            try{
                menu_input = scan.nextInt();
            }
            catch (InputMismatchException e){
                menu_input = -1;
                hata();
            }
            finally {
                scan.nextLine();
            }

            if (menu_input == 1){
                System.out.println("maclar burada goruntulenecektir");
            }
            else if(menu_input == 2){
                System.out.println("Haberler");
                System.out.println("""
                        1. Erling Haaland yeni bir Ferrari almak için İtalya'da
                        2. 2022 Dünya Kupası gol krallığı: Kylian Mbappe veya Enner Valencia?
                        3. Efsane TRT Spikeri Levent Özçelik, Vincent Aboubakar'a 'Maradona' dedi
                        4. Fransa, Benzema olmadan daha mı mutlu?"""); // https://www.goal.com/tr/haber/fransa-benzema-olmadan-daha-mi-mutlu-tchouameni-fenerbahce-nin-eski-yildizi-lugano-nun-iddialarina-yanit-verdi/bltbe39af68ed6157c4
                int haber_menu = scan.nextInt();
                Scanner newsScanner = new Scanner(new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\News\\news" + haber_menu + ".txt"));
                while (newsScanner.hasNextLine()) {
                    System.out.println(newsScanner.nextLine());
                }
            }
            if (menu_input == 3){
                System.out.println("1. Tüm Grubun Sıralaması Göster\n2. Belirli Grubun Sıralaması Gözter");
                menu_input = scan.nextInt();
                if (menu_input == 1){
                    for (Group group : groups) {
                        group.showGroupRanking();
                        System.out.println("\n");
                    }
                }
                else if (menu_input == 2){
                    System.out.println("Grup seçiniz (A-H >> 1-8): ");
                    int grup = scan.nextInt();
                    groups.get(grup-1).showGroupRanking();
                }
                else{
                    hata();
                }
            }
            else if(menu_input == 4){
                System.out.println("Ülke seçiniz:");
                String countryName = scan.nextLine();
                for (Country cn : CountryList){
                    if (countryName.equals(cn.getCountryName())){
                        System.out.println("1. Tüm bilgiler\n2. Takım kadroları");
                        int player_menu = scan.nextInt();
                        if (player_menu == 1){
                            System.out.println(cn.getCountryName());
                            System.out.println("country ranking: " + cn.getRank());
                            System.out.println("champions: " + cn.getChampions());
                            if (cn.getChampions() > 0){
                                System.out.println("champions year: ");
                                for (int i : cn.getChampionYears()){
                                    System.out.print(i + " ");
                                }
                                System.out.println("");
                            }
                            System.out.println("coach name: " + cn.getCoach().getName());
                            cn.displayPlayers();
                            break;
                        }
                        else if (player_menu == 2){
                            System.out.println(cn.getCountryName());
                            cn.displayPlayers();
                            break;
                        }
                        else{
                            hata();
                        }
                    }
                }
            }
        }
        scan.close();
    }
    public static void hata(){
        System.out.println("HATALI GİRİŞ!!!\n");
    }
}