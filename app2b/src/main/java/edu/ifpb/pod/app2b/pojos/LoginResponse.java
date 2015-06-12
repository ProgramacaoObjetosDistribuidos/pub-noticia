package edu.ifpb.pod.app2b.pojos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DouglasGabriel
 */
@XmlRootElement
public class LoginResponse {
    
    private String session, name, email, error;   

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }        
}
