
package edu.ifpb.pod.xml.object.converter.entidades;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */

@XmlRootElement
public class Person {
    
   private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
   
}
