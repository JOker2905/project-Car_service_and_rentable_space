import person.Tenant;
import space.rentablespace.ConsumerWarehouse;
import space.rentablespace.ServiceWarehouse;
import time.Interface;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Interface Interface=new Interface();

        ServiceWarehouse serviceWarehouse1=new ServiceWarehouse(10, 20, 1200, new BigDecimal(500));
        ServiceWarehouse serviceWarehouse2=new ServiceWarehouse(10, 20, 1300, new BigDecimal(500));
        ServiceWarehouse serviceWarehouse3=new ServiceWarehouse(10, 20, 1000, new BigDecimal(500));
        ServiceWarehouse serviceWarehouse4=new ServiceWarehouse(10, 20, 1500, new BigDecimal(500));
        ServiceWarehouse serviceWarehouse5=new ServiceWarehouse(10, 20, 1100, new BigDecimal(500));
        Interface.putServiceWarehouse(serviceWarehouse1);
        Interface.putServiceWarehouse(serviceWarehouse2);
        Interface.putServiceWarehouse(serviceWarehouse3);
        Interface.putServiceWarehouse(serviceWarehouse4);
        Interface.putServiceWarehouse(serviceWarehouse5);

        ConsumerWarehouse consumerWarehouse1=new ConsumerWarehouse(1300, new BigDecimal(1000));
        ConsumerWarehouse consumerWarehouse2=new ConsumerWarehouse(1000, new BigDecimal(1000));
        ConsumerWarehouse consumerWarehouse3=new ConsumerWarehouse(1100, new BigDecimal(1000));
        ConsumerWarehouse consumerWarehouse4=new ConsumerWarehouse(1150, new BigDecimal(1000));
        ConsumerWarehouse consumerWarehouse5=new ConsumerWarehouse(1500, new BigDecimal(1000));
        Interface.putConsumerWarehouse(consumerWarehouse1);
        Interface.putConsumerWarehouse(consumerWarehouse2);
        Interface.putConsumerWarehouse(consumerWarehouse3);
        Interface.putConsumerWarehouse(consumerWarehouse4);
        Interface.putConsumerWarehouse(consumerWarehouse5);


        Tenant tenant1=new Tenant("Jan","Kowalski","01583696172","Radomska","24-04-2000");
        Tenant tenant2=new Tenant("Jerzy","Nowak","82574806761","Waleczna","24-04-1990");
        Tenant tenant3=new Tenant("Kazimierz","Przybłęda","34816724835","Uliczna","24-04-1991");
        Tenant tenant4=new Tenant("Jakub","Kowalczyk","34816724813","Specjalna","24-04-1992");
        Tenant tenant5=new Tenant("Aleksander","Wielki","24876159874","Nowodworska","24-04-1993");
        Interface.putTenant(tenant1);
        Interface.putTenant(tenant2);
        Interface.putTenant(tenant3);
        Interface.putTenant(tenant4);
        Interface.putTenant(tenant5);


        Interface.startprogram();



    }

}