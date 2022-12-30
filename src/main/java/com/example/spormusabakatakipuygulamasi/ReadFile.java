package com.example.spormusabakatakipuygulamasi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public static ArrayList<Country> CountryList = new ArrayList<>();
    public static ArrayList<Group> groups = new ArrayList<>();

    public static void readFile(){
        File directory = new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\countries");
        File[] fileList = directory.listFiles();

        Scanner scanner = null;
        assert fileList != null;
        for(File file : fileList){
            try{
                scanner = new Scanner(file);
                assignCountry(scanner);
            }
            catch(IOException e){
                System.out.println("IOEXception in file: " + file.getName());
            }
        }
        // making groups A-H
        for (int i = 65; i < 73; i++){
            groups.add(new Group(i));
        }
        for (int grup = 0; grup < 8; grup++) {
            for (int i = 0; i < 4; i++){
                assignGroup(groups.get(grup), CountryList.get(i+(4*grup)));
            }
        }
        scanner.close();
    }
    public static void assignCountry(Scanner scanner) throws NumberFormatException{
        // read the country name
        StringBuilder countryName = new StringBuilder(scanner.nextLine());
        countryName.delete(0, 6);

        // read country ranking
        StringBuilder ranking = new StringBuilder(scanner.nextLine());
        int rank = Integer.parseInt(ranking.delete(0, 9).toString());

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

        int n = 0;
        for (String y : years) {
            int year = Integer.parseInt(y);
            championYears[n] = year;
            n++;
        }
        country.setChampionYears(championYears);
        // read country coachName name
        StringBuilder coachName = new StringBuilder(scanner.nextLine());
        coachName.delete(0, 7);
        // set coachName name to country
        Coach coach = new Coach(coachName.toString());
        coach.setCountry(country);
        country.setCoach(coach);
        //country.setCoachName(coachName.toString());
        // read country players name
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            StringBuilder player = new StringBuilder(scanner.nextLine());
            //player.delete(player.indexOf("(")-1,player.indexOf(")")+1);
            Players playerObj = new Players(player.substring(0, player.indexOf("(")-1),
                    player.substring(player.indexOf("(")));
            playerObj.setCountry(country);
            country.addPlayer(playerObj);
        }
        CountryList.add(country);
        scanner.close();
    }
    public static void assignGroup(Group group, Country country){
        group.addCountry(country);
    }

    public static ArrayList<Matches> groupMatches = new ArrayList<>();
    public static ArrayList<Matches> knockOutMatches = new ArrayList<>();

    public static void readMatchFile(String matchType, ArrayList<Matches> matchList, String file_name){
        File file = new File(file_name);
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        String matchDate = null;
        while (scanner != null && scanner.hasNextLine()) {
            StringBuilder nextLine = new StringBuilder(scanner.next());
            try {
                Integer.parseInt(nextLine.toString());
                nextLine.append(scanner.nextLine());
                matchDate = nextLine.toString();
            } catch (NumberFormatException e) {
                Country teamA = new Country();
                Country teamB = new Country();

                int[] scoreInt = new int[2];
                boolean flag = false;
                StringBuilder nextWord = new StringBuilder(scanner.next());
                for (int i = 0; i < nextWord.length(); i++) {
                    if (nextWord.charAt(i) == '-'){
                        flag = true;
                    }
                }
                if (!flag){
                    nextLine.append(" ").append(nextWord);
                    nextWord = new StringBuilder(scanner.next());
                }
                for (Country country : CountryList) {
                    if (nextLine.toString().equals(country.getCountryName())) {
                        teamA = country;
                        break;
                    }
                }
                try {
                    String[] score2 = nextWord.toString().split("-");
                    scoreInt[0] = Integer.parseInt(score2[0]);
                    scoreInt[1] = Integer.parseInt(score2[1]);
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }

                StringBuilder nextTeam = new StringBuilder(scanner.nextLine());
                nextTeam.delete(0,1);
                for (Country country : CountryList) {
                    if (nextTeam.toString().equals(country.getCountryName())) {
                        teamB = country;
                        break;
                    }
                }
                String scoreboard = matchDate + "\n\t    " + scoreInt[0] + "-" + scoreInt[1];
                Matches match = new Matches(matchType, teamA, teamB, matchDate, scoreInt, scoreboard);
                matchList.add(match);
            }
        }
        scanner.close();
    }
    public static void addGroupMatches(Group group) {
        for (Matches matches : groupMatches) {
            for (Country country : group.getCountryList()){
                if (matches.getTeamA().equals(country.getCountryName())){
                    group.addMatch(matches);
                }
            }
        }
    }

    public static void readPlayerFile(){
        File directory = new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\players\\player_info");
        File[] fileList = directory.listFiles();

        Scanner scanner = null;
        assert fileList != null;
        for(File file : fileList){
            try{
                scanner = new Scanner(file);
                assignPlayer(scanner);
            }
            catch(IOException e){
                System.out.println("IOEXception in file: " + file.getName());
            }
        }
        scanner.close();
    }
    public static void assignPlayer(Scanner scanner) throws IOException{
        String countryName = scanner.nextLine();
        for (Country country : CountryList){
            if (countryName.equals(country.getCountryName())){
                String name = scanner.nextLine();
                for (Players player : country.getPlayers()){
                    if (name.equals(player.getName())){
                        player.setCountry(country);
                        player.setName(name);
                        player.setShirtNumber(scanner.nextInt());
                        player.setAge(scanner.nextInt());
                        scanner.nextLine();
                        player.setHeight(scanner.nextLine());
                        player.setClub(scanner.nextLine());
                        player.setGoals(scanner.nextInt());
                        player.setAssist(scanner.nextInt());
                        player.setYellowCard(scanner.nextInt());
                        player.setRedCard(scanner.nextInt());
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void readCoachFile(){
        File directory = new File("D:\\Programming\\Java\\SporMusabakaTakipUygulamasi\\src\\main\\resources\\players\\coach_info");
        File[] fileList = directory.listFiles();

        Scanner scanner = null;
        assert fileList != null;
        for(File file : fileList){
            try{
                scanner = new Scanner(file);
                assignCoach(scanner);
            }
            catch(IOException e){
                System.out.println("IOEXception in file: " + file.getName());
            }
        }
        scanner.close();
    }
    public static void assignCoach(Scanner scanner) throws IOException{
        String countryName = scanner.nextLine();
        for (Country country : CountryList){
            if (countryName.equals(country.getCountryName())){
                country.getCoach().setCountry(country);
                scanner.nextLine();
                country.getCoach().setNationality(countryName);
                country.getCoach().setAge(scanner.nextInt());
                scanner.nextLine();
                country.getCoach().setTakim(scanner.nextLine());
                while (scanner.hasNextLine()){
                    country.getCoach().addKupalar(scanner.nextLine());
                }
                break;
            }
        }
    }
}