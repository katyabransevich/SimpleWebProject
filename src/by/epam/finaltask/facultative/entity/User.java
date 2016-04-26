package by.epam.finaltask.facultative.entity;

import java.io.Serializable;

public class User implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String login;
        private String password;

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getLogin() {
                return login;
        }

        public void setLogin(String login) {
                this.login = login;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }
}
