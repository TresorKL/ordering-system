 
package za.ac.tut.client;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import za.ac.tut.address.Address;
import za.ac.tut.product.Product;

 
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    @Column(name="client_name")
    private String name;
    
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name="address_fk")
    private Address address;
    
    @OneToMany(fetch=FetchType.LAZY,targetEntity=Product.class, cascade= CascadeType.PERSIST)
    @JoinTable(name="jnd_client_product", joinColumns=@JoinColumn(name="client_fk"),
               inverseJoinColumns=@JoinColumn(name="product_fk"))
    private List<Product>products;

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
         
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.client.Client[ id=" + id + " ]";
    }
    
}
