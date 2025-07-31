package com.andreyS.saracon.models.service;

import org.springframework.stereotype.Service;

import com.andreyS.saracon.models.dao.EntidadDAOIface;
import com.andreyS.saracon.models.entity.Entidad;
import com.andreyS.saracon.models.results.AuthResult;

@Service
public class AuthService implements AuthServiceIface {

    private final EntidadDAOIface entidadDaoIface;

    public AuthService(EntidadDAOIface entidadDaoIface) {
        this.entidadDaoIface = entidadDaoIface;
    }

    @Override
    public AuthResult authenticateUser(String email, String password) {
        Entidad entidad = entidadDaoIface.findByEmail(email);

        if (entidad != null && entidad.getPassword().equals(password)) {
            return new AuthResult(true, entidad.getTipoEntidad().getDescripcion());
        }

        return new AuthResult(false, null);
    }

    @Override
    public void registerUser(String username, String password, String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }

    @Override
    public boolean isUserAuthenticated() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUserAuthenticated'");
    }

    // Implement methods for authentication logic here

}
