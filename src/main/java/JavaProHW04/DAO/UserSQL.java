package JavaProHW04.DAO;

public enum UserSQL {

    INSERT_NEW_USER("INSERT INTO `Users` (`name`, `surname`, `phoneNumber`)" +
            "VALUES ((?), (?), (?))"),

    READ_ALL("SELECT * FROM `Users`");

    String QUERY;

    UserSQL(java.lang.String QUERY) {
        this.QUERY = QUERY;
    }

    public java.lang.String getQUERY() {
        return QUERY;
    }
}
