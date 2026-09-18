package br.com.tiger.model;

import java.io.Serializable;
import java.util.Objects;


// serializable permite ler e escrever no objeto
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // para que serve o equals?
    // para comparar se dois objetos são iguais
    // se o objeto for null, retorna false
    // se o objeto não for uma instância de Person, retorna false
    // se os ids, firstName, lastName, address e gender forem iguais, retorna true
    // se os ids, firstName, lastName, address e gender forem diferentes, retorna false
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) {
            return false;
        }
        return Objects.equals(getId(), person.getId())
                && Objects.equals(getFirstName(), person.getFirstName())
                && Objects.equals(getLastName(), person.getLastName())
                && Objects.equals(getAddress(), person.getAddress())
                && Objects.equals(getGender(), person.getGender());
    }

    // para que serve o hashCode?
    // para gerar um número único para o objeto
    // se o objeto for null, retorna 0
    // se o objeto não for uma instância de Person, retorna 0
    // se os ids, firstName, lastName, address e gender forem iguais, retorna o mesmo número
    // se os ids, firstName, lastName, address e gender forem diferentes, retorna números diferentes
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
