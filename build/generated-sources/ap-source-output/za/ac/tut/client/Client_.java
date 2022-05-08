package za.ac.tut.client;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.address.Address;
import za.ac.tut.product.Product;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-05-08T22:28:34")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Address> address;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile ListAttribute<Client, Product> products;

}