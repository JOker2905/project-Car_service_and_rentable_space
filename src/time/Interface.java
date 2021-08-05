package time;

import exceptions.ProblematicTenantException;
import person.Tenant;
import space.rentablespace.ConsumerWarehouse;
import space.rentablespace.RentableSpace;
import space.rentablespace.ServiceWarehouse;
import tenancy.TenancyCases;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Interface {

    TimeLapse timeLapse=new TimeLapse(new Date(2000,12,01));
    TenancyCases tenancyCases=new TenancyCases(timeLapse);
    List<Tenant> tenantList=new ArrayList<>();
    List<ServiceWarehouse> serviceWarehouseList = new ArrayList<>();
    List<ConsumerWarehouse> consumerWarehouseList=new ArrayList<>();
    List<RentableSpace>rentableSpaceList=new ArrayList<>();
    public void startprogram(){
        timeLapse.start();
        System.out.println(
                "Komendy które możesz wydać programowi:" +
                        "\n1.Zakończenie programu." +
                        "\n2.Wybrania którą jesteś osobą (Podaj pesel osoby"+
                        "\n3.Wypisania swoich danych"+
                        "\n4.Wyświetlenia wolnych pomieszczeń"+
                        "\n5.Wynajęcia nowego pomieszczenia "+
                        "\n6.Wybrania pomieszczenia danej osoby i wypisania zawartosci"+
                        "\n7.Zaparkowania nowego pojazdu na miejsce parkingowe(nie zrobione)"+
                        "\n8.Wyjęcia samochodu lub przedmiotu(nie zrobione)"+
                        "\n9.Rozpoczęcia zgloszenia serwisowego(nie zrobione)"+
                        "\n10.Rozpoczęcia naprawy(nie zrobione)"+
                        "\n11.Zapisu aktualnego stanu aplikacji do plików"

        );



        while(timeLapse.getrun()) {
            System.out.println("Podaj komendę z przedziału od 1 do 11");
            Scanner scanner=new Scanner(System.in);
            int commandnumber=scanner.nextInt();
            if (commandnumber>0&&commandnumber<12) {
                switch (commandnumber) {
                    case 1:
                        timeLapse.stop();
                        System.out.println("Zakończyłeś działanie programu");
                        break;
                    case 2:

                        System.out.println("Stworzone osoby:");
                        for (int i=0;i<tenantList.size();i++)
                            System.out.println(tenantList.get(i).getPESEL());
                        System.out.println("Podaj pesel osoby którą chcesz wybrać");
                        Scanner scanner1=new Scanner(System.in);
                        String peselfromuser1= scanner1.nextLine();
                        break;
                    case 3:
                        System.out.println("Podaj pesel");
                        Scanner scanner2=new Scanner(System.in);
                        String peselfromuser2=scanner2.nextLine();
                        for(int i=0;i<tenantList.size();i++){
                            if(tenantList.get(i).getPESEL().equals(peselfromuser2)){
                                System.out.println(
                                        tenantList.get(i).getName()+" "+
                                                tenantList.get(i).getSurname()+" "+
                                                tenantList.get(i).getPESEL()+" "+
                                                tenantList.get(i).getAddress()+" "+
                                                tenantList.get(i).getBirthDate()
                                );
                                System.out.println(tenantList.get(i).getRented());
                            }
                        }
                        break;
                    case 4:
                        for(int i=0;i<serviceWarehouseList.size();i++){
                            if (serviceWarehouseList.get(i).getFreeSpace()>0)
                                System.out.println(serviceWarehouseList.get(i).getId());
                        }
                        for(int i=0;i<consumerWarehouseList.size();i++){
                            if (consumerWarehouseList.get(i).getFreeSpace()>0)
                                System.out.println(consumerWarehouseList.get(i).getId());
                        }
                        break;
                    case 5:
                        System.out.println("Podaj pesel");
                        Scanner scanner5=new Scanner(System.in);
                        String peselfromuser4=scanner5.nextLine();
                        System.out.println("Wybierz pomieszczenie wpisujac id");
                        Scanner scanner6=new Scanner(System.in);
                        String warehouseid1=scanner6.nextLine();
                        int indexoftenant = 0;
                        int indexofwarehouse=0;
                        for(int i=0;i<tenantList.size();i++){
                            if (tenantList.get(i).getPESEL().equals(peselfromuser4)){
                                indexoftenant=i;
                            }
                        }
                        for(int i=0;i<rentableSpaceList.size();i++){
                            if(rentableSpaceList.get(i).getId().equals(warehouseid1)){
                                indexofwarehouse=i;
                            }
                        }

                        try {
                            tenantList.get(indexoftenant).rent(rentableSpaceList.get(indexofwarehouse),timeLapse.getCurrentDate(),timeLapse.getRentEnd());
                        } catch (ProblematicTenantException e) {
                            e.printStackTrace();
                        }


                        break;
                    case 6:
                        System.out.println("Podaj pesel");
                        Scanner scanner3=new Scanner(System.in);
                        String peselfromuser3=scanner3.nextLine();
                        for(int i=0;i<tenantList.size();i++){
                            if(tenantList.get(i).getPESEL().equals(peselfromuser3)){
                                System.out.println(tenantList.get(i).getRented());
                            }
                        }
                        System.out.println("Wybierz pomieszczenie podajac id");
                        Scanner scanner4=new Scanner(System.in);
                        String warehouseid2=scanner4.nextLine();
                        for(int i=0;i<consumerWarehouseList.size();i++){
                            if(consumerWarehouseList.get(i).getId().equals(warehouseid2)){
                                System.out.println(consumerWarehouseList.get(i).getThings());
                            }
                        }
                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 10:

                        break;
                    case 11:
                        try {
                            FileWriter fileWriter=new FileWriter("warehouses.txt");
                            Collections.sort(rentableSpaceList);

                            for(int i=0;i<rentableSpaceList.size();i++){
                                Collections.sort(rentableSpaceList.get(i).getThingList());
                            }

                            for(int i=0;i<rentableSpaceList.size();i++){
                                fileWriter.write(String.valueOf(rentableSpaceList.get(i).getId())+"   ("+"Free Space:"+rentableSpaceList.get(i).getFreeSpace()+",Max Space:"+rentableSpaceList.get(i).getMaxSpace()+")");
                                fileWriter.write("\n");
                                fileWriter.write("\t");
                                fileWriter.write(String.valueOf(rentableSpaceList.get(i).getTenants()));
                                fileWriter.write("\n");
                                fileWriter.write("\t"+"\t");
                                fileWriter.write(String.valueOf(rentableSpaceList.get(i).getThingList()));
                                fileWriter.write("\n");
                            }

                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }else {
                System.out.println("Musisz podać komendę z przedziału od 1 do 11");
                commandnumber = scanner.nextInt();
            }
        }
    }

    public void putTenant(Tenant tenant){
        tenantList.add(tenant);
    }
    public void putConsumerWarehouse(ConsumerWarehouse consumerWarehouse){
        consumerWarehouseList.add(consumerWarehouse);
        rentableSpaceList.add(consumerWarehouse);
    }
    public void putServiceWarehouse(ServiceWarehouse serviceWarehouse){
        serviceWarehouseList.add(serviceWarehouse);
        rentableSpaceList.add(serviceWarehouse);
    }
}
