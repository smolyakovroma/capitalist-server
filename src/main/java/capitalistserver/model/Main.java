package capitalistserver.model;

import capitalistserver.model.builds.CityHall;
import capitalistserver.model.builds.Debris;
import capitalistserver.model.builds.House;
import capitalistserver.model.builds.Road;
import capitalistserver.model.cityManagment.Tender;
import capitalistserver.model.cityManagment.TenderStatus;
import capitalistserver.model.cityManagment.TenderType;
import capitalistserver.model.territory.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("GAME BEGIN!");
        generateTerritory();


    }

    private static void startGame(Country country) {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<Region> regions = country.getRegions();
            for (Region region : regions) {
                List<Sector> sectors = region.getSectors();
                for (Sector sector : sectors) {
                    if (sector.getSectorType() == SectorType.CITY) {
                        CityHall cityHall = (CityHall) sector.getCityHall();
                        final double rent = 2d;
                        int totalTenants = 0;
                        int totalRoads = 0;
                        int totalHouses = 0;
                        List<Cell> cells = sector.getCells();
                        for (Cell cell : cells) {
                            if (cell.getBuild() != null) {
                                if(cell.getBuild() instanceof House){
                                    cityHall.setBudget(cityHall.getBudget() + ((House) cell.getBuild()).getCurrentTenants() * rent);
                                    ((House) cell.getBuild()).increaseTenants(0);
                                    totalHouses++;
                                    totalTenants += ((House) cell.getBuild()).getCurrentTenants();
                                } else if(cell.getBuild() instanceof Road){
                                    cityHall.setBudget(cityHall.getBudget() - ((Road) cell.getBuild()).getSpeed() * rent);
                                    totalRoads++;
                                }
                            }
                        }

                        System.out.println("BUDGET STATUS: "+cityHall.getBudget());
                        System.out.println("TOTAL TENANTS: "+totalTenants+" HOUSES: "+totalHouses+" ROADS: "+totalRoads);

                        if(totalHouses*10 == totalTenants){
                            int currentTenders = 0;

                            for (Tender tender : cityHall.getTenders()) {
                                if(tender.getTenderStatus()== TenderStatus.POSTED){
                                    currentTenders++;
                                }
                            }

                            if(currentTenders < totalHouses/10){
                                System.out.println("NEED HOUSES: " +(totalHouses/10-currentTenders));
                                for (int i = currentTenders; i < totalHouses/10; i++) {
                                    cityHall.getTenders().add(new Tender(TenderType.BUILD, new House(), 1000));
                                }
                            }
                        }
                        System.out.println("------------TENDERS---------------");
                        for (Tender tender : cityHall.getTenders()) {
                            System.out.println(tender);
                        }

                    }
                }
            }

        }
    }

    public static void generateTerritory() {
        //region 3x3 in center small city and 8 sector 10x10
        Random random = new Random();
        Country russia = new Country("RUSSIA");
        Region testiland = new Region("Testiland", 0, 0);
        testiland.setRows(3);
        russia.getRegions().add(testiland);
        ArrayList<Sector> sectors = new ArrayList<Sector>();
        for (int k = 0; k < 3; k++) {
            for (int p = 0; p < 3; p++) {
//                if (k != 1 && p != 1) {
                Sector sector = new Sector(("Sector " + k + "x" + p), k, p, SectorType.LAND);
                sectors.add(sector);
                sector.setRows(10);
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        Cell cell = new Cell(i, j, CellType.FIELD);
                        sector.getCells().add(cell);
                    }
                }
//                }
            }
        }
        testiland.setSectors(sectors);
        //add city
        Sector testville = new Sector("Testville 1x1", 1, 1, SectorType.CITY);
        testville.setRows(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cell cell = new Cell(i, j, CellType.BUILD);
                testville.getCells().add(cell);
                boolean hall = false;
                switch (random.nextInt(4)) {
                    case 0:
                        cell.setBuild(new House());
                        break;
                    case 1:
                        if (!hall) {
                            cell.setBuild(new CityHall());
                            testville.setCityHall(cell.getBuild());
                            hall = true;
                        } else {
                            cell.setBuild(new Debris());
                        }
                        break;
                    case 2:
                        cell.setBuild(new Road());
                        break;
                    case 3:
                        cell.setBuild(null);
                        break;
                }
            }
        }
        testiland.getSectors().remove(4);
        testiland.getSectors().add(4, testville);
        aboutRegion(testiland);
        aboutSector(testiland.getSectors().get(0));
        aboutSector(testiland.getSectors().get(4));
        startGame(russia);
    }

    public static void aboutRegion(Region region) {
        System.out.println("----------------------------------------------");
        List<Sector> sectors = region.getSectors();
        int c = 0;
        for (Sector sector : sectors) {
            System.out.print(sector.toString() + " / ");
            c++;
            if (c == region.getRows()) {
                c = 0;
                System.out.println();
            }
        }
    }

    public static void aboutSector(Sector sector) {
        System.out.println("----------------------------------------------");
        List<Cell> cells = sector.getCells();
        int c = 0;
        for (Cell cell : cells) {
            System.out.print(cell.toString() + " / ");
            c++;
            if (c == sector.getRows()) {
                c = 0;
                System.out.println();
            }
        }
    }
}
